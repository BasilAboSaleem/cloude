package com.example.cloude1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        save.setOnClickListener {
            var name = name.text.toString()
            var id = id.text.toString()
            var age = age.text.toString()

            val person = hashMapOf(
                "name" to "name",
                "id" to "id",
                "age" to age,
            )

            db.collection("person")
                .add(person)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(applicationContext, "${documentReference.id}", Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(applicationContext, "$e", Toast.LENGTH_LONG).show()
                }
        }
    }
}
