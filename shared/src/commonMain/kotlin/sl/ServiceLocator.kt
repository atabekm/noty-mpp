package com.example.mpp.noty.shared.di

import com.example.mpp.noty.NoteDatabase
import com.example.mpp.noty.shared.data.NoteRepository
import com.example.mpp.noty.shared.getDriver
import com.example.mpp.noty.shared.presentation.details.NoteDetailsPresenter
import com.example.mpp.noty.shared.presentation.list.NoteListPresenter

object ServiceLocator {

    private val db = NoteDatabase(getDriver())

    private val noteRepository: NoteRepository by lazy {
        NoteRepository(db)
    }

    val noteListPresenter: NoteListPresenter by lazy {
        NoteListPresenter(noteRepository)
    }

    val noteDetailsPresenter: NoteDetailsPresenter by lazy {
        NoteDetailsPresenter(noteRepository)
    }
}
