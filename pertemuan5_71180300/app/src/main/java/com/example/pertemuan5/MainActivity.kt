package com.example.pertemuan5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtUsername = findViewById<EditText>(R.id.edtNama)
        val edtPass = findViewById<EditText>(R.id.edtPass)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        fun validasi():Boolean{
            if(edtPass.text.contentEquals("1234")){
            return true
            }
            edtPass.error = "Password harus 1234"
            return false

        }

        btnLogin.setOnClickListener {
            if (validasi()){
                val intent = Intent(this, HasilActivity::class.java)
                intent.putExtra("nama", edtUsername.text.toString())
                startActivity(intent)
            }
        }

    }
}