package com.rfgalahad.trinitywizardstestapp.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rfgalahad.trinitywizardstestapp.listener.UserContactListener
import com.rfgalahad.trinitywizardstestapp.model.User
import kotlinx.android.synthetic.main.item_contact.view.tvContactFullName

class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var listener: UserContactListener? = null

    fun bind(item: User, click: UserContactListener) {
        listener = click

        itemView.tvContactFullName.text = "${item.firstName} ${item.lastName}"

        itemView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0) {
            itemView -> {
                listener?.onContactSelected(bindingAdapterPosition)
            }
        }
    }
}