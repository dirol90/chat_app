package net.fine.girls

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.ViewAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import net.fine.girls.adapter.MyAdapter
import net.fine.girls.mock.Mock.Companion.list
import net.fine.girls.mock.Mock.Companion.namesList
import net.fine.girls.model.CardModel
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_1.setOnClickListener {
            rlw.visibility = View.VISIBLE
            alert_text.visibility = View.GONE
            btn_1.setImageDrawable(applicationContext.resources.getDrawable(R.drawable.hearts_pressed))
            btn_2.setImageDrawable(applicationContext.resources.getDrawable(R.drawable.chats))
        }

        btn_2.setOnClickListener {
            rlw.visibility = View.GONE
            alert_text.visibility = View.VISIBLE
            btn_1.setImageDrawable(applicationContext.resources.getDrawable(R.drawable.hearts))
            btn_2.setImageDrawable(applicationContext.resources.getDrawable(R.drawable.chats_pressed))
        }

        val adapter = MyAdapter()
        val cardList = mutableListOf<CardModel>()

        namesList.shuffle()
        list.shuffle()

        for (i in 0 until list.size) {
            cardList.add(CardModel(list[i], namesList[i], Random.nextInt(90, 100)))
        }

        adapter.setList(cardList)
        rlw.layoutManager = LinearLayoutManager(this)
        rlw.adapter = adapter

    }
}
