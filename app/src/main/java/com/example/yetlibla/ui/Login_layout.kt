package com.example.yetlibla.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.yetlibla.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login_layout.*
import kotlinx.android.synthetic.main.activity_login_layout.inputemails
import kotlinx.android.synthetic.main.activity_login_layout.inputPassword
import kotlinx.android.synthetic.main.activity_register.*

class Login_layout : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_layout)
        auth = FirebaseAuth.getInstance()
        val progressBar = findViewById<ProgressBar>(R.id.progressBar2)
        val gotoregister = findViewById(R.id.gotoRegister) as TextView
        gotoregister.setOnClickListener {  startActivity(Intent(this,
            register::class.java)) }
        btnLogin.setOnClickListener { login()
            progressBar.visibility = View.VISIBLE}
      btnLoginGuest.setOnClickListener { startActivity(Intent(this,
          search::class.java)) }
    }


    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    fun updateUI(currentUser: FirebaseUser?) {
                if(currentUser!=null)
                    startActivity(Intent(this, search::class.java))
    }

    private fun login(){


        auth.signInWithEmailAndPassword(inputemails.text.toString(), inputPassword.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Login in success, update UI with the signed-in user's information

                    Toast.makeText(applicationContext,"User Login successfull",Toast.LENGTH_LONG).show()
                    val user = auth.currentUser
                    updateUI(user)
                    progressBar.visibility = View.INVISIBLE
                } else {

                    // If Login in fails, display a message to the user.
                 //   Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(baseContext, "Authentication failed." + task.exception ,
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)

                }

                // ...
            }

    }




}