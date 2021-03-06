package com.example.mpp.noty.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mpp.noty.Note
import com.example.mpp.noty.R
import kotlinx.android.synthetic.main.item_note.view.*

class NoteListAdapter(
    private val noteClickCallback: (Long) -> Unit
) : ListAdapter<Note, NoteListAdapter.ViewHolder>(NoteDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), noteClickCallback)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(note: Note, noteClickCallback: (Long) -> Unit) {
            itemView.note_item_title.isGone = note.title.isNullOrEmpty()
            itemView.note_item_title.text = note.title
            itemView.note_item_content.text = note.content
            itemView.setOnClickListener {
                noteClickCallback.invoke(note.id)
            }
        }
    }
}

class NoteDiffCallback : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id == newItem.id && oldItem.title == newItem.title && oldItem.content == newItem.content
    }
}
