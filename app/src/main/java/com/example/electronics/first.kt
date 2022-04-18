package com.example.electronics

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_first.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.design.*
import kotlinx.android.synthetic.main.dialog_box.*

class first : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
         retriAll()
    }

        fun retriAll(){
            var db=DBHelper(this)
            var arr:ArrayList<model> = db.retriveAll()
            var adaptrr= adapt(this,arr)
            recView1.adapter = adaptrr
        }

        fun delet(position: Int){
            var db=DBHelper(this)
            var arr:ArrayList<model> = db.retriveAll()
            var pos= arr.get(position)
            db.delete(pos.id)
            retriAll()
        }

        fun updte(position: Int){
            var db = DBHelper(this)
            var arr:ArrayList<model> = db.retriveAll()
            var pos = arr.get(position)
            var dialog = Dialog(this)

            // Fetch Dialog Layout
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.dialog_box)

            //fetch
            dialog.idTv.setText(pos.id.toString())
            dialog.upName.setText(pos.name)
            dialog.upDesc.setText(pos.desc)

            dialog.bUpdte.setOnClickListener{
                 var iddd = dialog.idTv.text.toString().toInt()
                var name = dialog.upName.text.toString()
                var desc = dialog.upDesc.text.toString()
                var add=  model(iddd, name, desc)
                db.update(add)
                Toast.makeText(this,"update success",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
                retriAll()
            }
            dialog.bCancel.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }
}


