package com.utcc.projecttodolist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class EditProfile: AppCompatActivity() {

    private val REQ_CODE = 1333

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editprofile)

        val imageIntent = Intent(Intent.ACTION_GET_CONTENT)
        imageIntent.setType("image/*")
        val profilePic = findViewById<ImageView>(R.id.profilePic)
        val btnSaveProfile = findViewById<Button>(R.id.buttonSaveProfile)
        val edtUser = findViewById<EditText>(R.id.editTextTextPersonName)
        val editProfileBack = findViewById<ImageButton>(R.id.imageButton4)

        profilePic.setOnClickListener{
            startActivityForResult(imageIntent,REQ_CODE);
        }

        btnSaveProfile.setOnClickListener {
            DatabaseHelper.user = edtUser.text.toString()
            val intent = Intent(this@EditProfile,Profile::class.java);
            startActivity(intent)
        }

        editProfileBack.setOnClickListener {
            val intent = Intent(this@EditProfile,Profile::class.java);
            startActivity(intent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode != Activity.RESULT_OK){
            return
        }
        if(requestCode == REQ_CODE){
            val uri = data?.data;
            findViewById<ImageView>(R.id.profilePic).setImageURI(uri);
            DatabaseHelper.link = uri.toString()
        }
    }
}