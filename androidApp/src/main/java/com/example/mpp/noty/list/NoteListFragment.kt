package com.example.mpp.noty.list

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.mpp.noty.Note
import com.example.mpp.noty.R
import com.example.mpp.noty.navigation.Navigator
import com.example.mpp.noty.shared.di.ServiceLocator
import com.example.mpp.noty.shared.presentation.list.NoteListView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_note_list.*

class NoteListFragment : Fragment(R.layout.fragment_note_list), NoteListView {
    private val presenter = ServiceLocator.noteListPresenter
    private val adapter = NoteListAdapter()
    private val navigator = Navigator.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notesRecycler.adapter = adapter
        notesFab.setOnClickListener {
            navigator.openNote(-1)
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        presenter.detachView()
        super.onStop()
    }

    override fun updateNotes(notes: List<Note>) {
        adapter.submitList(notes)
    }

    override fun showError(errorMessage: String) {
        Snackbar.make(notesRecycler, errorMessage, Snackbar.LENGTH_INDEFINITE).show()
    }

    override fun setLoadingStatus(visible: Boolean) {
        notesProgress.isVisible = visible
    }
}
