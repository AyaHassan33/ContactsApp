package com.example.contactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        var textName :TextView=findViewById(R.id.txt_name)
        var textPhone:TextView=findViewById(R.id.txt_phone)
        var textDesc:TextView =findViewById(R.id.txt_desc)
        textName.text=intent.getStringExtra("name")
        textPhone.text=intent.getStringExtra("phoneNumber")
        textDesc.text=intent.getStringExtra("desc")
    }
}