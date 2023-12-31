package pet.onemorebruh.diary

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pet.onemorebruh.diary.database.Message
import pet.onemorebruh.diary.database.MessageListAdapter
import pet.onemorebruh.diary.database.MessageViewModel
import java.text.SimpleDateFormat
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var textField: EditText
    private lateinit var messageViewModel: MessageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init all used elements elements
        val messagesView = findViewById<RecyclerView>(R.id.messgesView)
        val pinButton = findViewById<ImageButton>(R.id.pinButton)
        val sendButton = findViewById<ImageButton>(R.id.sendButton)
        textField = findViewById<EditText>(R.id.textField)
        messageViewModel = ViewModelProvider(this)[MessageViewModel::class.java]
        val adapter = MessageListAdapter()


        //load data from database
        messageViewModel.allMessages.observe(this) { message ->
            adapter.setData(message)
        }
        messagesView.adapter = adapter
        messagesView.layoutManager = LinearLayoutManager(this)


        //set button actions

        //pinButton.setOnClickListener {
        //    throw NotImplementedError()//TODO add images support
        //}

        sendButton.setOnClickListener {
            if (textField.text.equals("")) {//writes new record to database if text is not empty
                val status = sendMessage(textField.text.toString())
                //send error message or clean textField
                if (!status){
                    Toast.makeText(
                        this,
                        R.string.send_message_error,
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    textField.text.clear()
                }
            }
        }

    }

    private fun sendMessage(text: String): Boolean{
        try {
            //get current time
            val timestamp = SimpleDateFormat("dd.MM HH:mm").format(Calendar.getInstance().time)
            //gather data to message
            val message: Message = Message(0, text, timestamp)
            //insert message to database
            messageViewModel.insertMessage(message)
            return true
        }
        catch (exception: Exception) {//here have to be one of Room's Exceptions but i haven't found correct one yet
            return false
        }
    }
}