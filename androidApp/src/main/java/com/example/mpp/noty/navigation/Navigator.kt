package com.example.mpp.noty.navigation

import android.os.Bundle
import androidx.navigation.NavController
import com.example.mpp.noty.R
import com.example.mpp.noty.shared.navigation.Navigation

class Navigator : Navigation {
    private var navController: NavController? = null

    fun bind(navController: NavController) {
        this.navController = navController
    }

    fun unbind() {
        navController = null
    }

    companion object {
        private lateinit var instance: Navigator

        fun getInstance(): Navigator {
            if (!::instance.isInitialized) {
                instance = Navigator()
            }
            return instance
        }
    }

    override fun openNotesList() {

    }

    override fun openNote(noteId: Long) {
        val bundle = Bundle()
        bundle.putLong("note_id", noteId)
        navController?.navigate(R.id.actionNoteDetails, bundle)
    }

    override fun closeNote() {
        navController?.popBackStack()
    }
}
