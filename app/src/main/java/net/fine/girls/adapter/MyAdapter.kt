package net.fine.girls.adapter

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import net.fine.girls.R
import net.fine.girls.activity.ChatActivity
import net.fine.girls.model.CardModel


class MyAdapter : RecyclerView.Adapter<MyAdapter.MyAdapterHolder>() {

    var listModels: MutableList<CardModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapterHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_card, parent, false)
        return MyAdapterHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapterHolder, position: Int) {
        holder.bind(listModels[position])
    }

    override fun getItemCount(): Int {
        return listModels.size
    }

    fun setList(list: MutableList<CardModel>){
        this.listModels = list
        notifyDataSetChanged()
    }

    inner class MyAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.name)
        private val percentName: TextView = itemView.findViewById(R.id.percent_name)
        private val mainImage: ImageView = itemView.findViewById(R.id.main_image)
        private val imb_1: ImageView = itemView.findViewById(R.id.imb_1)
        private val imb_2: ImageView = itemView.findViewById(R.id.imb_2)
        private val smg_btn: ImageView = itemView.findViewById(R.id.smg_btn)

        var isClickedImb1 = false
        var isClickedImb2 = false

        fun bind(obj: CardModel) {
            name.text  = obj.name
            percentName.text = "${obj.percent}%"
            Glide
                .with(itemView.context)
                .load(obj.url)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .into(mainImage)

            imb_1.setOnClickListener {
                if (isClickedImb1){
                    isClickedImb1 = false
                    imb_1.setImageDrawable(itemView.context.resources.getDrawable(R.drawable.star))
                } else {
                        isClickedImb1 = true
                        imb_1.setImageDrawable(itemView.context.resources.getDrawable(R.drawable.star_pressed))
                }
            }

            imb_2.setOnClickListener {
                if (isClickedImb2){
                    isClickedImb2 = false
                    imb_2.setImageDrawable(itemView.context.resources.getDrawable(R.drawable.vip))
                } else {
                    isClickedImb2 = true
                    imb_2.setImageDrawable(itemView.context.resources.getDrawable(R.drawable.vip_pressed))
                }
            }

            smg_btn.setOnClickListener {
                itemView.context.startActivity(Intent(itemView.context, ChatActivity::class.java))
            }

        }
    }
}



