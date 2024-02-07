package com.rfgalahad.trinitywizardstestapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rfgalahad.trinitywizardstestapp.R
import com.rfgalahad.trinitywizardstestapp.holder.ContactViewHolder
import com.rfgalahad.trinitywizardstestapp.listener.UserContactListener
import com.rfgalahad.trinitywizardstestapp.model.User

class ContactsAdapter(
    private val list: ArrayList<User>,
    private val listener: UserContactListener
    ) : RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(list[position], listener)
    }
}