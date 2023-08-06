package com.example.contactsapp

import java.text.FieldPosition

interface OnContactClickListener {
    fun onContactClick(item :ContactData ,position:Int)
    fun onCallClick(item : ContactData,position: Int)
}