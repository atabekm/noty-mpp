package com.example.mpp.noty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mpp.noty.shared.createApplicationScreenMessage
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_text.text = createApplicationScreenMessage()
    }
}
