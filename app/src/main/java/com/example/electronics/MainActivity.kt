package com.example.electronics

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.design.*
import kotlinx.android.synthetic.main.dialog_box.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button1.setOnClickListener {
            var name = Pname.text.toString()
            var desc = Dname.text.toString()
            var price = Price.text.toString()
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(desc) || TextUtils.isEmpty(price)) {
                Toast.makeText(this, "Plz Enter Fields", Toast.LENGTH_SHORT).show()
            } else {
                var db = DBHelper(this)
                var product = model(name,desc,price)
                db.insert(product)
                Pname.setText("")
                Dname.setText("")
                Price.setText("")
            }
        }

        button2.setOnClickListener {
            var intent = Intent(this,first::class.java)
            startActivity(intent)
        }

    }

}





//        fun retriAll(){
//            var db=DBHelper(this)
//            var arr:ArrayList<model> = db.retriveAll()
//            var adaptrr= adapt(this,arr)
//            recView1.adapter = adaptrr
//        }



//        var arry = ArrayList<model>()
//        arry.add(model("nokia","desc1"))
//        arry.add(model("dell","desc2"))
//        arry.add(model("panasonic","desc3"))
//        arry.add(model("nokia","desc1"))
//        arry.add(model("dell","desc2"))
//        var adaptr= adapt(this,arry)
//        recView.adapter = adaptr



