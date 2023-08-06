package com.example.contactsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ContactAdapter(val contactDataArray:ArrayList<ContactData>) :Adapter<ContactAdapter.ContactViewHolder>() {

    var onContactClick :OnContactClickListener?=null

    class ContactViewHolder(var view : View) : ViewHolder(view){
        val name:TextView =view.findViewById(R.id.name_show)
        val phone:TextView=view.findViewById(R.id.phone_number)
        val callBtn:ImageButton=view.findViewById(R.id.btn_call)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.contact_item_layout,parent,false))
    }

    override fun getItemCount(): Int {
       return contactDataArray.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.name.text=contactDataArray.get(position).contactName
        holder.phone.text=contactDataArray.get(position).phoneNumber
        holder.view.setOnClickListener{
            onContactClick?.onContactClick(contactDataArray.get(position),position)
        }
        holder.callBtn.setOnClickListener{
            onContactClick?.onCallClick(contactDataArray.get(position),position)
        }


    }
}