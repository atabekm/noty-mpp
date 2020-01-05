package com.example.mpp.noty.shared.presentation

import com.example.mpp.noty.Note
import com.example.mpp.noty.shared.data.NoteRepository

class NoteDetailsPresenter(private val noteRepository: NoteRepository) {

    fun getNote(id: Long): Note {
        return noteRepository.getNote(id)
    }

    fun saveNote(note: Note) {
        noteRepository.addNote(note)
    }
}
