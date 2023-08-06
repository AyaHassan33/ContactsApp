package com.example.contactsapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var nameEdit:EditText
    lateinit var phoneEdit:EditText
    lateinit var description:EditText
    lateinit var showText:TextView
    lateinit var btnAddContact:Button
    lateinit var recyclerView: RecyclerView
    lateinit var adapter :ContactAdapter
    var contactDataArray :ArrayList<ContactData> =ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameEdit=findViewById(R.id.edit_name)
        phoneEdit=findViewById(R.id.edit_phone)
        description=findViewById(R.id.edit_description)
        //showText=findViewById(R.id.text_show)
        recyclerView=findViewById(R.id.recycler_contact)
        adapter=ContactAdapter(contactDataArray)
        btnAddContact=findViewById(R.id.btn_save)
        btnAddContact.setOnClickListener(View.OnClickListener {
            /*
            var name = nameEdit.text
            var phoneNumber = phoneEdit.text
            var desc = description.text
            showText.text="$name $phoneNumber $desc"
            nameEdit.setText("");
           phoneEdit.text.clear()
           description.text.clear()
             */
            contactDataArray.add(ContactData(nameEdit.text.toString(),phoneEdit.text.toString(),description.text.toString()))
            recyclerView.adapter=adapter
            nameEdit.setText("");
            phoneEdit.text.clear()
            description.text.clear()

        })

        adapter.onContactClick=object :OnContactClickListener{
            override fun onContactClick(item: ContactData, position: Int) {
                var intent=Intent(this@MainActivity,DescriptionActivity::class.java)
                intent.putExtra("desc","Description :  ${item.description}")
                intent.putExtra("name","Name : ${item.contactName}")
                intent.putExtra("phoneNumber" ,"Phone Number : ${item.phoneNumber}")
                startActivity(intent)
            }

            override fun onCallClick(item: ContactData, position: Int) {
                val intent =Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+item.phoneNumber))
                startActivity(intent)
            }

        }



    }

}