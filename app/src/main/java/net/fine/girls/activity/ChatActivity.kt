package net.fine.girls.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_chat.*
import net.fine.girls.R
import net.fine.girls.adapter.MyMsgAdapter
import kotlin.random.Random

class ChatActivity : AppCompatActivity() {

    var answersIterator: Int = 0

    val answersList: MutableList<String> = mutableListOf(
        "Hello!",
        "I am OK",
        "How are you?",
        "I love yur photos",
        "You looks cool",
        ";)",
        "Where are you from?",
        "Awesome!",
        "I need to go, BB"
    )

    val msgList: MutableList<MsgModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val adapter = MyMsgAdapter()

        send_btn.setOnClickListener {
            if (et.text.toString() != "") {
                msgList.add(MsgModel(false, et.text.toString(), System.currentTimeMillis()))
                et.text.clear()
                adapter.setList(msgList)
                msg_alert.visibility = View.GONE

                if (answersIterator < answersList.size) {
                    Handler().postDelayed({
                        msgList.add(
                            MsgModel(
                                true,
                                answersList[answersIterator++],
                                System.currentTimeMillis()
                            )
                        )
                        adapter.setList(msgList)
                    }, Random.nextLong(1000, 5000))
                }

            }
        }

        if (msgList.isEmpty()){msg_alert.visibility = View.VISIBLE}

        chat_rlw.layoutManager = LinearLayoutManager(this)
        chat_rlw.adapter = adapter

    }
}
