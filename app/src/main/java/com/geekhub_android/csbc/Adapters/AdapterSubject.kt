package com.geekhub_android.csbc.Adapters

import android.graphics.Rect
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.geekhub_android.csbc.Model.Subject
import com.geekhub_android.csbc.R

class AdapterSubject (val listSubject: MutableList<Subject>) : RecyclerView.Adapter<AdapterSubject.HolderSubject>() {


    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int) = HolderSubject(LayoutInflater.from(parent.context).inflate(R.layout.item_subject, parent, false))


    override fun getItemCount() = listSubject.size

    override fun onBindViewHolder(holder: HolderSubject, position: Int) {
        holder.bind(listSubject[position])
    }

    inner class HolderSubject(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val time = itemView.findViewById<TextView>(R.id.time)
        private val name = itemView.findViewById<TextView>(R.id.name)
        private val teacher = itemView.findViewById<TextView>(R.id.teacher)
        private val classroom = itemView.findViewById<TextView>(R.id.classroom)


        fun bind(item: Subject) {
            time.text = times(item.number)
            name.text = item.name
            teacher.text = item.teacher
            classroom.text = item.classroom.toString()

        }

        fun times (number: Int?): String {
            if (number == 1) {
                return "8:30-9:50"
            }

            else if (number == 2) {
                return "10:00-11:20"
            }

            else if (number == 3) {
                return "11:30-12:50"
            }

            else if (number == 4) {
                return "13:10-14:30"
            }

            else if (number == 5) {
                return "14:40-16:00"
            }

            else {
                return ""
            }
        }
    }
}

