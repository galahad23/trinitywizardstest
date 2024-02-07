package com.rfgalahad.trinitywizardstestapp.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rfgalahad.trinitywizardstestapp.model.User
import kotlinx.android.synthetic.main.item_contact.view.tvContactFullName

class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: User) {
        itemView.tvContactFullName.text = "${item.firstName} ${item.lastName}"
    }
}