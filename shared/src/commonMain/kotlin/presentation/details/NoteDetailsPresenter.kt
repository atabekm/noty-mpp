package com.example.mpp.noty.shared.presentation.details

import com.example.mpp.noty.Note
import com.example.mpp.noty.shared.data.NoteRepository
import com.example.mpp.noty.shared.data.Status
import com.example.mpp.noty.shared.defaultDispatcher
import com.example.mpp.noty.shared.presentation.BasePresenter
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class NoteDetailsPresenter(
    private val noteRepository: NoteRepository,
    coroutineContext: CoroutineContext = defaultDispatcher
) : BasePresenter<NoteDetailsView>(coroutineContext) {

    fun getNote(id: Long) {
        view?.setLoadingStatus(true)
        scope.launch {
            val result = noteRepository.getNote(id)
            when (result.status) {
                Status.LOADING -> {
                    view?.setLoadingStatus(true)
                }
                Status.SUCCESS -> {
                    view?.setLoadingStatus(false)
                    view?.showNote(result.data ?: Note.Impl(-1, "", ""))
                }
                Status.ERROR -> {
                    view?.setLoadingStatus(false)
                    view?.showError(result.message)
                }
            }
        }
    }

    fun saveNote(title: String, content: String) {
        view?.setLoadingStatus(true)
        scope.launch {
            val result = noteRepository.addNote(title, content)

            when (result.status) {
                Status.LOADING -> {
                    view?.setLoadingStatus(true)
                }
                Status.SUCCESS -> {
                    view?.setLoadingStatus(false)
                }
                Status.ERROR -> {
                    view?.setLoadingStatus(false)
                    view?.showError(result.message)
                }
            }
        }
    }
}

interface NoteDetailsView {
    fun showNote(note: Note)
    fun showError(errorMessage: String)
    fun setLoadingStatus(visible: Boolean)
}
