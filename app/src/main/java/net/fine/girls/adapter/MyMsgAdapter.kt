package net.fine.girls.adapter

import android.graphics.Color
import android.provider.CalendarContract
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import net.fine.girls.R
import net.fine.girls.activity.MsgModel
import net.fine.girls.model.CardModel


class MyMsgAdapter : RecyclerView.Adapter<MyMsgAdapter.MyAdapterHolder>() {

    var listMsgs: MutableList<MsgModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapterHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_msg, parent, false)
        return MyAdapterHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapterHolder, position: Int) {
        holder.bind(listMsgs[position])
    }

    override fun getItemCount(): Int {
        return listMsgs.size
    }

    fun setList(list: MutableList<MsgModel>){
        this.listMsgs = list.sortedWith(compareBy { it.timestamp }).reversed().toMutableList()
        notifyDataSetChanged()
    }

    inner class MyAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val msg_card: CardView = itemView.findViewById(R.id.msg_card)
        private val msg_text: TextView = itemView.findViewById(R.id.msg_text)

        fun bind(obj: MsgModel) {
            if (obj.fromShe){
                msg_card.setCardBackgroundColor(Color.parseColor("#ff6ec7"))
            } else {
                msg_card.setCardBackgroundColor(itemView.context.resources.getColor(R.color.orange))
            }

            msg_text.text  = obj.text

        }
    }
}



