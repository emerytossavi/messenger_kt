package com.etstore.firstapp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlin.contracts.ReturnsNotNull


data class ElementItem(
    val imageResId: Int,
    val titre: String,
    val sousTitre1: String,
    val sousTitre2: String,
    val buttonIconResId: Int
)



class ElementAdapter(
    private val items: List<ElementItem>,
    private val onItemClick: (ElementItem) -> Unit, // Callback pour gérer le clic sur le bloc entier
    private val onButtonClick: (ElementItem) -> Unit // Callback pour gérer le clic sur l'ImageButton
) : RecyclerView.Adapter<ElementAdapter.ElementViewHolder>() {

    class ElementViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val textViewTitre: TextView = view.findViewById(R.id.textView6)
        val textViewSousTitre1: TextView = view.findViewById(R.id.textView7)
        val textViewSousTitre2: TextView = view.findViewById(R.id.textView8)
        val snap: ImageButton = view.findViewById(R.id.snap) // Le bouton Snap
        val linearLayout: View = view.findViewById(R.id.bloc) // Le LinearLayout englobant tout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.display_message, parent, false) // Assure-toi que le XML est correct
        return ElementViewHolder(view)
    }

    override fun onBindViewHolder(holder: ElementViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.imageResId)
        holder.textViewTitre.text = item.titre
        holder.textViewSousTitre1.text = item.sousTitre1
        holder.textViewSousTitre2.text = item.sousTitre2
        holder.snap.setImageResource(item.buttonIconResId)

        // Gérer le clic sur le bloc entier (LinearLayout)
        holder.linearLayout.setOnClickListener {
            onItemClick(item) // Appel du callback avec l'élément
        }

        // Gérer le clic sur l'image du bouton
        holder.snap.setOnClickListener {
            onButtonClick(item) // Appel du callback pour le bouton
        }
    }

    override fun getItemCount() = items.size
}
