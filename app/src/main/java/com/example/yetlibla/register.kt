package com.example.yetlibla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login_layout.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.FULLNAME
import kotlinx.android.synthetic.main.activity_register.inputPassword

class register : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = FirebaseAuth.getInstance()
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val gotoLogin = findViewById(R.id.gotoLogin) as TextView
        btnRegister.setOnClickListener {
            //Sign up the user
            signup()
            progressBar.visibility = View.VISIBLE

        }
        gotoLogin.setOnClickListener {  startActivity(Intent(this,Login_layout::class.java)) }

    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }
    fun updateUI(currentUser: FirebaseUser?) {
        if(currentUser!=null)
            startActivity(Intent(this,Homepage::class.java))
    }
    private fun signup(){
        auth.createUserWithEmailAndPassword(inputemail.text.toString(), inputPassword.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "createUserWithEmail:success")
                    Toast.makeText(baseContext, "User registered successfully" ,
                        Toast.LENGTH_SHORT).show()
                    val user = auth.currentUser
                    updateUI(user)
                    progressBar.visibility = View.INVISIBLE
                } else {
                    progressBar.visibility = View.INVISIBLE
                    // If sign in fails, display a message to the user.
                    //   Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed."  + task.exception,
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)

                }

                // ...
            }


    }


}