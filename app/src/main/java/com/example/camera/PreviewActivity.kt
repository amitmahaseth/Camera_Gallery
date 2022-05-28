package com.example.camera

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView

class PreviewActivity : AppCompatActivity() {
     lateinit var iv_preview:AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        iv_preview=findViewById(R.id.iv_preview1)
//        val myUri: Uri = Uri.parse(intent.extras!!.getString("imageUri"))
//        iv_preview.setImageURI(myUri)

        val image = intent.extras!!.getString("imageUri")
        if (image != null) {
            val imageUri = Uri.parse(image)
            iv_preview.setImageURI(imageUri)
        }

    }
}