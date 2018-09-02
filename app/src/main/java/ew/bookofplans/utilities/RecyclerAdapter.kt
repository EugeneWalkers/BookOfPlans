package ew.bookofplans.utilities

import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ew.bookofplans.R
import ew.bookofplans.model.Cafe
import ew.bookofplans.model.Film
import ew.bookofplans.model.Other
import ew.bookofplans.model.Plan
import ew.bookofplans.view.MainActivity
import ew.bookofplans.viewModel.MainViewModel
import kotlinx.android.synthetic.main.card_film.view.*

class RecyclerAdapter(private val items: ArrayList<Plan>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var viewModel: MainViewModel? = null

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val card = p0.cardView
        val header = card.header
        //val who = card.who
        val date = card.date
        val completed = card.isCompleted
        header.text = items[p1].name
        //who.text = items[p1].who
        date.text = "${items[p1].date.day}.${items[p1].date.month}.${items[p1].date.year} ${items[p1].date.hours}:${items[p1].date.minutes}:${items[p1].date.seconds}"

        val color = if (items[p1].who.equals(MainActivity.S)) ContextCompat.getColor(p0.cardView.context, R.color.colorS)
        else ContextCompat.getColor(p0.cardView.context, R.color.colorJ)

        val isCompleted = !items[p1].inFuture
        completed.isChecked = isCompleted

        card.layout.setBackgroundColor(color)

        when (items[0]) {

            is Film -> {
                val genre = card.genre
                genre.text = (items[p1] as Film).genre

                if (((items[p1]) as Film).highPriority) {
                    card.high_priority.visibility = ConstraintLayout.VISIBLE
                } else {
                    card.high_priority.visibility = ConstraintLayout.INVISIBLE
                }
            }

            is Cafe -> {

            }

            is Other -> {

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


        init {
            val myMenu = cardView.my_menu
            myMenu.setOnClickListener {
                val popupMenu = PopupMenu(cardView.context, it)
                popupMenu.inflate(R.menu.menu_item)
                popupMenu.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.edit -> {

                            return@setOnMenuItemClickListener true
                        }
                        R.id.delete -> {

                            return@setOnMenuItemClickListener true
                        }
                    }

                    return@setOnMenuItemClickListener false
                }
                popupMenu.show()
            }
        }

    }

    override fun getItemCount(): Int = items.size

    fun setList(list: ArrayList<Plan>) {
        items.clear();
        items.addAll(list)
    }
}
