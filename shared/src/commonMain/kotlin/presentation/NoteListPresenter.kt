package com.example.mpp.noty.shared.presentation

import com.example.mpp.noty.Note
import com.example.mpp.noty.shared.data.NoteRepository

class NoteListPresenter(private val noteRepository: NoteRepository) {

    fun getAllNotes(): List<Note> {
        return noteRepository.getAllNotes()
    }
}
