package pet.onemorebruh.diary.database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pet.onemorebruh.diary.R

class MessageListAdapter(): RecyclerView.Adapter<MessageListAdapter.MessageListHolder>() {

    private var messages = emptyList<Message>()
    class MessageListHolder(currentItem: View): RecyclerView.ViewHolder(currentItem) {
        val text: TextView = currentItem.findViewById(R.id.messageText)
        val time: TextView = currentItem.findViewById(R.id.messageTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageListHolder {
        val currentItem = LayoutInflater.from(parent.context).inflate(R.layout.cell_message, parent,false)
        return MessageListHolder(currentItem)
    }

    override fun onBindViewHolder(holder: MessageListHolder, position: Int) {
        //binds data with visible objects
        holder.text.text = messages[position].text
        holder.time.text = messages[position].text
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    fun setData(messages: List<Message>){
        this.messages = messages
        notifyDataSetChanged()
    }
}