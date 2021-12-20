package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity2 : AppCompatActivity() {
    private val firestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val firestore = FirebaseFirestore.getInstance()

        val edtNama = findViewById<EditText>(R.id.edtNama)
        val edtId = findViewById<EditText>(R.id.edtId)
        val edtThn = findViewById<EditText>(R.id.edtThn)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnDel = findViewById<Button>(R.id.btnDel)
        val btnChange = findViewById<Button>(R.id.btnChange)
        val txyOutput = findViewById<TextView>(R.id.txyOutput)

        btnAdd.setOnClickListener {
            val film = Film(edtNama.text.toString(), edtThn.text.toString().toInt())
            edtNama.setText("")
            edtThn.setText("")
            firestore?.collection("film")?.add(film)
        }




        btnChange.setOnClickListener {
            firestore?.collection("film").get()!!
                .addOnSuccessListener { docs ->
                    var output = ""
                    for (doc in docs){
                        output += "\n${doc["id"]} | ${doc["nama"]} | ${doc["tahun"]}"
                    }
                    txyOutput.setText(output)
                }
        }
            firestore?.collection("film").addSnapshotListener { snapshoot, e ->
                if (e == null) {
                    var output = ""
                for (doc in snapshoot!!.documents) {
                    output += "\n${doc["id"]} | ${doc["nama"]} | ${doc["tahun"]}"
                }
                txyOutput.setText(output)
            }
    }



}
}