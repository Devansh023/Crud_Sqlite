package com.example.electronics

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DBHelper(var context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {
        const val DB_NAME = "Dname"
        const val DB_VERSION = 1
        const val TB_NAME = "Tname"
        const val ID = "idd"
        const val NAME = "names"
        const val DESC = "description"
        const val PRICE = "prices"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var qry =
            "CREATE TABLE $TB_NAME($ID INTEGER PRIMARY KEY AUTOINCREMENT, $NAME TEXT,$DESC TEXT,$PRICE TEXT)"
        p0?.execSQL(qry)
    }

    // version/table upgrade
     override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        var qry = "DROP TABLE IF EXISTS $TB_NAME"
        p0?.execSQL(qry)
        onCreate(p0)
    }

    // insert in DB
    fun insert(d: model) {
        var db = this.writableDatabase
        var cv = ContentValues()
        cv.put(NAME, d.name)
        cv.put(DESC, d.desc)
        cv.put(PRICE, d.price)

        var flag = db.insert(TB_NAME, null, cv)
        if (flag > 0) {
            Toast.makeText(context, "Successfully Inserted", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Failed to Insert", Toast.LENGTH_SHORT).show()
        }
        db.close()
    }

    // retrieve
    fun retriveAll(): ArrayList<model> {
        var db = readableDatabase
        var arr = ArrayList<model>()
        var cursor = db.query(TB_NAME, null, null, null, null, null, null, null)
        while (cursor.moveToNext()) {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var desc = cursor.getString(2)
            var price = cursor.getString(3)
            var data = model(id, name, desc, price)
            arr.add(data)
        }
        return arr
    }

    // delete
    fun delete(idd: Int) {
        var db = writableDatabase
        db.delete(TB_NAME, "$ID=${idd}", null)
        db.close()
    }


    // update
    fun update(u: model) {
        var db = writableDatabase
        var cv = ContentValues()
        cv.put(NAME, u.name)
        cv.put(DESC, u.desc)

        var flag = db.update(TB_NAME, cv, "$ID=${u.id}", null)
        if (flag > 0) {
            Toast.makeText(context, "Successfully Updated", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Failed to update", Toast.LENGTH_SHORT).show()
        }

        db.close()

    }


}

