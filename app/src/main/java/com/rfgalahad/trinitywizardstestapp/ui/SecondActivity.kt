package com.rfgalahad.trinitywizardstestapp.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.rfgalahad.trinitywizardstestapp.R
import com.rfgalahad.trinitywizardstestapp.model.User
import kotlinx.android.synthetic.main.activity_second.etContactEmail
import kotlinx.android.synthetic.main.activity_second.etDateOfBirth
import kotlinx.android.synthetic.main.activity_second.etFirstName
import kotlinx.android.synthetic.main.activity_second.etLastName
import kotlinx.android.synthetic.main.activity_second.tvEditContactCancel

class SecondActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        if (intent.hasExtra("ContactDetails")) {
            val details = intent.getSerializableExtra("ContactDetails") as User
            details.apply {
                etFirstName.setText(details.firstName)
                etLastName.setText(details.lastName)
                etContactEmail.setText(details.email)
                etDateOfBirth.setText(details.dob)
            }
        }

        tvEditContactCancel.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}