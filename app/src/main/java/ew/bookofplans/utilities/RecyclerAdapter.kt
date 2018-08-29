package ew.bookofplans.utilities

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import ew.bookofplans.R
import ew.bookofplans.model.Cafe
import ew.bookofplans.model.Film
import ew.bookofplans.model.Other
import ew.bookofplans.model.Plan
import kotlinx.android.synthetic.main.card_film.view.*

class RecyclerAdapter(private val items: ArrayList<Plan>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val card = p0.cardView
        val header = card.header
        val who = card.who
        val date = card.date
        header.text = items[p1].name
        who.text = items[p1].who
        date.text = items[p1].date.toString()

        when (items[0]){
            is Film ->{
                val priority = card.priority
                val genre = card.genre
                priority.text = (items[p1] as Film).priority
                genre.text = (items[p1] as Film).genre
            }
            is Cafe ->{

            }
            is Other->{

            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        if (items.size == 0) {
            return ViewHolder(CardView(p0.context))
        } else {
            val card = when (items.get(0)) {
                is Film -> {
                    LayoutInflater.from(p0.context).inflate(R.layout.card_film, p0, false) as CardView
                }
                is Cafe -> {
                    LayoutInflater.from(p0.context).inflate(R.layout.card_cafe, p0, false) as CardView
                }
                is Other -> {
                    LayoutInflater.from(p0.context).inflate(R.layout.card_other, p0, false) as CardView
                }
                else -> {
                    CardView(p0.context)
                }
            }
            return ViewHolder(card)
        }
    }

    class ViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView) {


    }

    override fun getItemCount(): Int = items.size

}
