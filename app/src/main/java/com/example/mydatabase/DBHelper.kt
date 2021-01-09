package com.example.mydatabase

import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper (context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        val DATABASE_NAME = "Users.db"
        val DATABASE_VERSION = 1
        private val SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DBInfo.UserInput.TABLE_NAME + " (" + DBInfo.UserInput.COL_EMAIL +
                    " VARCHAR(200) PRIMARY KEY, " + DBInfo.UserInput.COL_FULLNAME + " TEXT, " +
                    DBInfo.UserInput.COL_ADDRESS + " VARCHAR(200), " + DBInfo.UserInput.COL_GENDER +
                    " VARCHAR(30), " + DBInfo.UserInput.COL_TELP + " VARCHAR(15) )"
        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DBInfo.UserInput.TABLE_NAME
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @Throws(SQLiteConstraintException::class)
    fun insertData(emailin: String, fullnamein: String, addressin: String, genderin: String, telpin: String): Boolean {
        val db = writableDatabase
        val namatablet = DBInfo.UserInput.TABLE_NAME
        val emailt = DBInfo.UserInput.COL_EMAIL
        val fullnamet = DBInfo.UserInput.COL_FULLNAME
        val addresst = DBInfo.UserInput.COL_ADDRESS
        val gendert = DBInfo.UserInput.COL_GENDER
        val telpt = DBInfo.UserInput.COL_TELP

        var sql = "INSERT INTO "+ namatablet +"("+emailt+", "+fullnamet+", "+addresst+", "+gendert+", "+telpt+") " +
                "VALUES('"+emailin+"', '"+fullnamein+"', '"+addressin+"', '"+genderin+"', '"+telpin+"')"
        db.execSQL(sql)
        return true
    }
    fun fullData():ArrayList<DBModel>{
        //      val users = ArrayList<DBModel>()
        val users = arrayListOf<DBModel>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("SELECT * FROM "+ DBInfo.UserInput.TABLE_NAME, null)
        }catch (e:SQLException){
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }

        var emailt: String
        var fullnamet: String
        var addresst: String
        var gendert: String
        var telpt: String
        if (cursor!!.moveToFirst()){
            while (cursor.isAfterLast==false){
                emailt = cursor.getString(cursor.getColumnIndex(DBInfo.UserInput.COL_EMAIL))
                fullnamet = cursor.getString(cursor.getColumnIndex(DBInfo.UserInput.COL_FULLNAME))
                addresst = cursor.getString(cursor.getColumnIndex(DBInfo.UserInput.COL_ADDRESS))
                gendert = cursor.getString(cursor.getColumnIndex(DBInfo.UserInput.COL_GENDER))
                telpt = cursor.getString(cursor.getColumnIndex(DBInfo.UserInput.COL_TELP))

                users.add(DBModel(emailt, fullnamet, addresst, gendert, telpt))
                cursor.moveToNext()
            }
        }
        return  users
    }

}