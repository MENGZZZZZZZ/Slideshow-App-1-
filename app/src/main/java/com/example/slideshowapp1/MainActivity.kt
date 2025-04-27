package com.example.slideshowapp1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val images = arrayOf(
        R.drawable.hello,
        R.drawable.sunsetview,
        R.drawable.thankyouforwatching
    )

    private val captions = arrayOf(
        "Hello",
        "Sunset View",
        "Thanks for Watching"
    )

    private var currentIndex = 0

    private lateinit var imageView: ImageView
    private lateinit var captionText: TextView
    private lateinit var inputField: EditText
    private lateinit var prevButton: Button
    private lateinit var nextButton: Button
    private lateinit var goButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        captionText = findViewById(R.id.captionText)
        inputField = findViewById(R.id.inputField)
        prevButton = findViewById(R.id.prevButton)
        nextButton = findViewById(R.id.nextButton)
        goButton = findViewById(R.id.goButton)

        updateContent()

        prevButton.setOnClickListener {
            if (currentIndex == 0) {
                currentIndex = images.size - 1
            } else {
                currentIndex--
            }
            updateContent()
        }

        nextButton.setOnClickListener {
            if (currentIndex == images.size - 1) {
                currentIndex = 0
            } else {
                currentIndex++
            }
            updateContent()
        }

        goButton.setOnClickListener {
            val inputText = inputField.text.toString()
            val number = inputText.toIntOrNull()

            if (number != null && number in 1..images.size) {
                currentIndex = number - 1
                updateContent()
            }
        }
    }

    private fun updateContent() {
        imageView.setImageResource(images[currentIndex])
        captionText.text = captions[currentIndex]
    }
}
