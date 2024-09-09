package com.example.eatsphere.adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eatsphere.Notification_Bottom_Fragment
import com.example.eatsphere.databinding.FragmentNotificationBottomBinding
import com.example.eatsphere.databinding.NotificationItemBinding

class NotificationAdapter(private var notitfication : ArrayList<String>, private var notificationImage : ArrayList<Int>) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding = NotificationItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotificationViewHolder(binding)
    }



    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
       holder.bind(position)
    }
    override fun getItemCount(): Int = notitfication.size
    inner class NotificationViewHolder(private val binding:NotificationItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int) {
            binding.apply {
                notificationTextView.text = notitfication[position]
                notificationImageView.setImageResource(notificationImage[position])
            }
        }

    }
}