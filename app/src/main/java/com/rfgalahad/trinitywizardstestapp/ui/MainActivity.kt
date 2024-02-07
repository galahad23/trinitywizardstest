package com.rfgalahad.trinitywizardstestapp.ui

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rfgalahad.trinitywizardstestapp.R
import com.rfgalahad.trinitywizardstestapp.adapter.ContactsAdapter
import com.rfgalahad.trinitywizardstestapp.model.User
import kotlinx.android.synthetic.main.activity_main.rvContactsList

class MainActivity : Activity() {

    private var newAdapter: ContactsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonString = readJsonFromAssets(baseContext, "data.json")
        val userData = parseJsonToModel(jsonString)

        newAdapter = ContactsAdapter(userData)
        rvContactsList.layoutManager = GridLayoutManager(this, 2)
        rvContactsList.adapter = newAdapter
    }

    fun readJsonFromAssets(context: Context, fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }

    fun parseJsonToModel(jsonString: String): List<User> {
        val gson = Gson()
        return gson.fromJson(jsonString, object : TypeToken<List<User>>() {}.type)
    }
}