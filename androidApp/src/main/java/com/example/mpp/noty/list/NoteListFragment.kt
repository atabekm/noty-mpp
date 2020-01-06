package com.example.mpp.noty.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.mpp.noty.R
import com.example.mpp.noty.shared.di.Injector
import kotlinx.android.synthetic.main.fragment_note_list.*

class NoteListFragment : Fragment(R.layout.fragment_note_list) {
    private val adapter = NoteListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notes_recycler.adapter = adapter

        val notes = Injector.noteListPresenter.getAllNotes()
        adapter.submitList(notes)
    }
}
