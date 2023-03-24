package com.example.btvnactivity

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageView
import android.widget.TextClock
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() ,OnClickListener{

    private lateinit var txClock: TextClock
    private lateinit var imgDialer: ImageView
    private lateinit var imgMessage: ImageView
    private lateinit var imgContacts: ImageView
    private lateinit var imgCamera: ImageView
    private lateinit var imgMusic: ImageView
    private lateinit var imgGallery: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txClock =   findViewById<TextClock>(R.id.textcock)
        imgDialer = findViewById<ImageView>(R.id.dialer)
        imgMessage =   findViewById<ImageView>(R.id.message)
        imgContacts =   findViewById<ImageView>(R.id.contacts)
        imgCamera =   findViewById<ImageView>(R.id.camera)
        imgMusic =   findViewById<ImageView>(R.id.music)
        imgGallery =   findViewById<ImageView>(R.id.gallery)

        txClock.setOnClickListener(this)
        imgDialer.setOnClickListener(this)
        imgMessage.setOnClickListener(this)
        imgContacts.setOnClickListener(this)
        imgCamera.setOnClickListener(this)
        imgMusic.setOnClickListener(this)
        imgGallery.setOnClickListener(this)

    }

    override fun onClick(view: View) {
      when(view.id){
          R.id.gallery -> {
              openGallery()
          }
          R.id.dialer -> {
              openDiale()
          }
          R.id.message -> {
              openMessage()
          }
          R.id.contacts ->{
              openContacts()
          }
          R.id.music ->{
              openMusic()
          }
          R.id.camera ->{
              openCamera()
          }

      }
    }
    private fun openGallery() {
        val intent = Intent()
        intent.action = Intent.ACTION_PICK
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.setType("image/*")
        startActivityForResult(intent, 10)
    }
    private fun openDiale(){
        val intent = Intent()
        intent.action = Intent.ACTION_DIAL
        startActivityForResult(intent, 10)
    }
    private fun openMessage(){
      val intent = Intent()
        intent.action = Intent.ACTION_MAIN
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING)
        startActivityForResult(intent, 10)

    }
    private fun openContacts(){
        val intent = Intent(Intent.ACTION_DEFAULT, ContactsContract.Contacts.CONTENT_URI)
        startActivityForResult(intent, 10)
    }
    private fun openMusic(){
        val intent = Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
    private fun openCamera(){
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, 10)
    }
}