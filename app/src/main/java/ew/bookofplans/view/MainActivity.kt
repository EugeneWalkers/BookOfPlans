package ew.bookofplans.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import ew.bookofplans.R
import ew.bookofplans.model.Cafe
import ew.bookofplans.model.Film
import ew.bookofplans.model.Plan
import ew.bookofplans.utilities.RecyclerAdapter
import ew.bookofplans.viewModel.MainViewModel
import ew.bookofplans.viewModel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private var filmsFragment: FragmentPage? = null
    private var cafesFragment: FragmentPage? = null
    private var othersFragment: FragmentPage? = null
    private var viewModel: MainViewModel? = null
    private var toolbar: Toolbar? = null
    private var recyclerView: RecyclerView? = null
    private var adapter: RecyclerAdapter? = null


    companion object {

        val J = "Женя"
        val S = "Саша"

        fun obtainViewModel(activity: FragmentActivity): MainViewModel {
            val factory = ViewModelFactory.getInstance(activity.application)
            return ViewModelProviders.of(activity, factory).get(MainViewModel::class.java)
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.films -> {
                toolbar?.setTitle(R.string.title_films)
                supportFragmentManager.beginTransaction()
                        .replace(R.id.my_fragment, filmsFragment)
                        .commit()
                val list = arrayListOf<Plan>(Film("Матрица", J, Date(), true, "Фэнтези/Кинофантастика", true),
                        Film("Призрак Оперы", S, Date(), false, "Драма/Триллер", true),
                        Film("Mamma mia", S, Date(), true, "Романтический фильм/Музыкальный фильм", true),
                        Film("Mamma mia 2", S, Date(), true, "Романтический фильм/Музыкальный фильм", false),
                        Film("Матрица: \nПерезагрузка", J, Date(), false, "Фэнтези/Кинофантастика", false),
                        Film("Матрица: \nРеволюция", J, Date(), false, "Фэнтези/Кинофантастика", false))
                adapter?.setList(list)
                adapter?.notifyDataSetChanged()

                return@OnNavigationItemSelectedListener true
            }
            R.id.cafes -> {
                toolbar?.setTitle(R.string.title_cafes)
                supportFragmentManager.beginTransaction()
                        .replace(R.id.my_fragment, cafesFragment)
                        .commit()
                adapter?.setList(arrayListOf(Cafe("SomeCafe", J, Date(), "Some address") as Plan))
                adapter?.notifyDataSetChanged()

                return@OnNavigationItemSelectedListener true
            }
            R.id.others -> {
                toolbar?.setTitle(R.string.title_others)
                supportFragmentManager.beginTransaction()
                        .replace(R.id.my_fragment, othersFragment)
                        .commit()
                recyclerView?.adapter?.notifyDataSetChanged()

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        initFragments()
        setToolbar()
        setRecyclerView()
        supportFragmentManager.beginTransaction()
                .add(R.id.my_fragment, filmsFragment)
                .commit()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val a = item?.itemId
        when (a) {
            R.id.refresh -> {
                //TODO: write refresher
            }

            R.id.add -> {
                //TODO: write adder
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun initFragments() {
        filmsFragment = FragmentPage()
        cafesFragment = FragmentPage()
        othersFragment = FragmentPage()
    }

    private fun setToolbar() {
        toolbar = findViewById(R.id.my_toolbar)
        toolbar?.setTitle(R.string.title_films)
        toolbar?.inflateMenu(R.menu.menu_toolbar)
    }

    private fun setRecyclerView() {
        recyclerView = my_fragment.recycler
        val list = arrayListOf<Plan>(Film("Матрица", J, Date(), true, "Фэнтези/Кинофантастика", true),
                Film("Призрак Оперы", S, Date(), false, "Драма/Триллер", true),
                Film("Mamma mia", S, Date(), true, "Романтический фильм/Музыкальный фильм", true),
                Film("Mamma mia 2", S, Date(), true, "Романтический фильм/Музыкальный фильм", false),
                Film("Матрица: \nПерезагрузка", J, Date(), false, "Фэнтези/Кинофантастика", false),
                Film("Матрица: \nРеволюция", J, Date(), false, "Фэнтези/Кинофантастика", false))
        adapter = RecyclerAdapter(list)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter = adapter
    }
}
