package com.example.mydatabase

import android.provider.BaseColumns

object DBInfo {
        class UserInput: BaseColumns {
            companion object {

                val TABLE_NAME = "users"
                val COL_EMAIL = "email"
                val COL_FULLNAME = "fullname"
                val COL_ADDRESS = "address"
                val COL_GENDER = "gender"
                val COL_TELP = "telp"

            }
        }
    }
