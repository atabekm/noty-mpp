package com.example.mpp.noty.shared.presentation.list

import com.example.mpp.noty.Note
import com.example.mpp.noty.shared.data.NoteRepository
import com.example.mpp.noty.shared.data.Status
import com.example.mpp.noty.shared.defaultDispatcher
import com.example.mpp.noty.shared.presentation.BasePresenter
import com.example.mpp.noty.shared.uiDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class NoteListPresenter(
    private val noteRepository: NoteRepository,
    coroutineContext: CoroutineContext = defaultDispatcher
) : BasePresenter<NoteListView>(coroutineContext) {

    override fun onViewAttached(view: NoteListView) {
        getAllNotes()
    }

    fun getAllNotes() {
        view?.setLoadingStatus(true)
        scope.launch {
            val result = noteRepository.getAllNotes()

            withContext(uiDispatcher) {
                when (result.status) {
                    Status.LOADING -> {
                        view?.setLoadingStatus(true)
                    }
                    Status.SUCCESS -> {
                        view?.setLoadingStatus(false)
                        view?.updateNotes(result.data ?: listOf())
                    }
                    Status.ERROR -> {
                        view?.setLoadingStatus(false)
                        view?.showError(result.message)
                    }
                }
            }
        }
    }
}

interface NoteListView {
    fun updateNotes(notes: List<Note>)
    fun showError(errorMessage: String)
    fun setLoadingStatus(visible: Boolean)
}
