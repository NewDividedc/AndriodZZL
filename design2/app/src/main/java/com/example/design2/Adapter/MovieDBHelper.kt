package com.example.design2.Adapter

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class MovieDBHelper (val context: Context, name: String, version: Int) :
    SQLiteOpenHelper(context, name, null, version) {

    private val createBook = "create table Movie (" +
            "id integer primary key," +
            "intro text," +
            "poster text," +
            "chName text," +
            "oriName text," +
            "othName text," +
            "proTime text," +
            "country text," +
            "genre text," +
            "duration text," +
            "dataReleased text," +
            "language text," +
            "director text," +
            "actor text," +
            "imdbID text," +
            "imdbRating text)"
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createBook)
        Toast.makeText(context, "Create succeeded", Toast.LENGTH_SHORT).show()
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }
}