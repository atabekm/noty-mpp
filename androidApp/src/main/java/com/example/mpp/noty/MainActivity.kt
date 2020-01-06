package com.example.mpp.noty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mpp.noty.list.NoteListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.root_container, NoteListFragment())
            .commit()
    }
}
