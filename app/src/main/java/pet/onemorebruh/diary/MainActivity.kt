package pet.onemorebruh.diary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init all used elements elements
        val postsView = findViewById<RecyclerView>(R.id.messgesView)
        val pinButton = findViewById<Button>(R.id.pinButton)
        val textField = findViewById<EditText>(R.id.textField)
        val sendButton = findViewById<Button>(R.id.sendButton)

    }

}