package com.example.electronics

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.design.view.*

//connects design to model

class adapt (var context: Context,var arr:ArrayList<model>) : RecyclerView.Adapter<adapt.myViewHolder>()
{
       // Inflate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
       val inflat= LayoutInflater.from(parent.context)
        val vw= inflat.inflate(R.layout.design,parent,false)
        return myViewHolder(vw)
    }

        // array
    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.bind(arr[position])
            holder.itemView.imgdel.setOnClickListener {
                    (context as first).delet(position)
           }
            holder.itemView.imgupdt.setOnClickListener {
                    (context as first).updte(position)
            }
    }

        // arraySize
    override fun getItemCount(): Int {
        return arr.size
    }


        // ViewHolder
    class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  //connects design to model
    {
        fun bind (dataa:model){
            itemView.tvid.text= dataa.id.toString()
            itemView.tvname.text= dataa.name
            itemView.tvdesc.text= dataa.desc
            itemView.tvprice.text= dataa.price
        }
    }

}
