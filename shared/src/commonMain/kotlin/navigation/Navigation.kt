package com.example.mpp.noty.shared.navigation

interface Navigation {
    fun openNotesList()
    fun openNote(noteId: Long)
    fun closeNote()
}
