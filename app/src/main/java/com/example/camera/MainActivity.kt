package com.example.camera

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import com.github.drjacky.imagepicker.ImagePicker


class MainActivity : AppCompatActivity() {

    private var uri: Uri?=null
    lateinit var img_view: AppCompatImageView
    lateinit var btn_upload: AppCompatImageView
    lateinit var btn_gallery: AppCompatImageView

    lateinit var btn_Show: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img_view = findViewById(R.id.iv_preview)
        btn_upload = findViewById(R.id.camera)
        btn_gallery = findViewById(R.id.gallery)
//        btn_Show = findViewById(R.id.btn_Preview)

        btn_upload.setOnClickListener {
            launcher.launch(
                ImagePicker.with(this)
                    //...
                    .cameraOnly() // or galleryOnly()
                    .crop()
                    .createIntent()
            )
        }

        btn_gallery.setOnClickListener {
            launcher.launch(
                ImagePicker.with(this)
                    //...
                    .galleryOnly() // or galleryOnly()
                    .crop()
                    .createIntent()
            )
        }
//        btn_Show.setOnClickListener {
//            val intent = Intent(this, PreviewActivity::class.java)
//            intent.putExtra("imageUri", uri)
//            startActivity(intent)
//        }
    }

    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            uri = it.data?.data!!
            img_view.setImageURI(uri)
            // Use the uri to load the image
        }
    }

}