package com.example.mpp.noty.shared.data

import com.example.mpp.noty.Note
import com.example.mpp.noty.NoteDatabase

class NoteRepository(private val db: NoteDatabase) {

    fun getAllNotes(): Resource<List<Note>> {
        return try {
            val notes = db.noteDatabaseQueries.selectNotes().executeAsList()
            Resource.success(notes)
        } catch (e: Exception) {
            Resource.error(e.toString())
        }
    }

    fun getNote(id: Long): Resource<Note> {
        return try {
            val note = db.noteDatabaseQueries.selectNoteById(id).executeAsOne()
            Resource.success(note)
        } catch (e: Exception) {
            Resource.error(e.toString())
        }
    }

    fun addNote(title: String, content: String): Resource<Unit> {
        return try {
            db.noteDatabaseQueries.insertNote(title, content)
            Resource.success(Unit)
        } catch (e: Exception) {
            Resource.error(e.toString())
        }
    }

    fun updateNote(id: Long, title: String, content: String): Resource<Unit> {
        return try {
            db.noteDatabaseQueries.updateNote(title, content, id)
            Resource.success(Unit)
        } catch (e: Exception) {
            Resource.error(e.toString())
        }
    }
}
