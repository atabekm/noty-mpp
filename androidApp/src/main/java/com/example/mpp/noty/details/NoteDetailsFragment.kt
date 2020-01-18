package com.example.mpp.noty.details

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.mpp.noty.Note
import com.example.mpp.noty.R
import com.example.mpp.noty.navigation.Navigator
import com.example.mpp.noty.shared.di.ServiceLocator
import com.example.mpp.noty.shared.presentation.details.NoteDetailsView
import com.example.mpp.noty.utils.closeKeyboard
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_note_details.*
import kotlinx.android.synthetic.main.fragment_note_list.*

class NoteDetailsFragment : Fragment(R.layout.fragment_note_details), NoteDetailsView {
    private var noteId: Long = NEW_NOTE
    private val presenter = ServiceLocator.noteDetailsPresenter
    private val navigator = Navigator.getInstance()

    companion object {
        private const val NOTE_ID = "note_id"
        private const val NEW_NOTE = -1L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        noteId = arguments?.getLong(NOTE_ID) ?: NEW_NOTE
        presenter.attachView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)

        if (noteId != NEW_NOTE) {
            presenter.getNote(noteId)
        }
    }

    override fun onStop() {
        closeKeyboard()
        super.onStop()
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.details_menu, menu);
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_save -> {
                if (noteId == NEW_NOTE) {
                    presenter.saveNote(noteDetailsTitle.text.toString(), noteDetailsContent.text.toString())
                } else {
                    presenter.updateNote(noteId, noteDetailsTitle.text.toString(), noteDetailsContent.text.toString())
                }
                navigator.closeNote()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showNote(note: Note) {
        noteDetailsTitle.setText(note.title)
        noteDetailsContent.setText(note.content)
    }

    override fun showError(errorMessage: String) {
        Snackbar.make(notesRecycler, errorMessage, Snackbar.LENGTH_INDEFINITE).show()
    }

    override fun setLoadingStatus(visible: Boolean) {
        noteProgress.isVisible = visible
    }
}
