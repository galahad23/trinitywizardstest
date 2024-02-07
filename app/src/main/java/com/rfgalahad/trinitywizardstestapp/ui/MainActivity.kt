package com.rfgalahad.trinitywizardstestapp.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rfgalahad.trinitywizardstestapp.R
import com.rfgalahad.trinitywizardstestapp.adapter.ContactsAdapter
import com.rfgalahad.trinitywizardstestapp.listener.UserContactListener
import com.rfgalahad.trinitywizardstestapp.model.User
import kotlinx.android.synthetic.main.activity_main.ivAddContact
import kotlinx.android.synthetic.main.activity_main.rvContactsList

class MainActivity : Activity(), UserContactListener {

    private var newAdapter: ContactsAdapter? = null
    private var userData = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonString = readJsonFromAssets(baseContext, "data.json")
        userData = parseJsonToModel(jsonString)

        newAdapter = ContactsAdapter(userData,this)
        rvContactsList.layoutManager = GridLayoutManager(this, 2)
        rvContactsList.adapter = newAdapter

        ivAddContact.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    fun readJsonFromAssets(context: Context, fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }

    fun parseJsonToModel(jsonString: String): ArrayList<User> {
        val gson = Gson()
        return gson.fromJson(jsonString, object : TypeToken<ArrayList<User>>() {}.type)
    }

    override fun onContactSelected(pos: Int) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("ContactDetails", userData[pos])
        startActivity(intent)
    }
}