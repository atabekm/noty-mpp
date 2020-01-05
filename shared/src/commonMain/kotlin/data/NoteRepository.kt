package com.example.mpp.noty.shared.data

import com.example.mpp.noty.Note
import com.example.mpp.noty.NoteDatabase

class NoteRepository(private val db: NoteDatabase) {

    fun getAllNotes(): List<Note> {
        return db.noteDatabaseQueries.selectNotes().executeAsList()
    }

    fun getNote(id: Long): Note {
        return db.noteDatabaseQueries.selectNoteById(id).executeAsOne()
    }

    fun addNote(note: Note) {
        db.noteDatabaseQueries.insertNote(note.id, note.title, note.content)
    }
}
