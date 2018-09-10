package com.chikeandroid.tutsplusespressotesting

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var loginTitleTextView: TextView
    private lateinit var passwordEditText: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.et_username)
        passwordEditText = findViewById(R.id.et_password)
        submitButton = findViewById(R.id.btn_submit)
        loginTitleTextView = findViewById(R.id.tv_login)

        submitButton.setOnClickListener {
            if (usernameEditText.text.toString() == "chike" &&
                    passwordEditText.text.toString() == "password") {
                loginTitleTextView.text = "Success"
            } else {
                loginTitleTextView.text = "Failure"
            }
        }
    }
}
