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
import ew.bookofplans.model.Film
import ew.bookofplans.model.Plan
import ew.bookofplans.utilities.RecyclerAdapter
import ew.bookofplans.viewModel.MainViewModel
import ew.bookofplans.viewModel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_page.*
import kotlinx.android.synthetic.main.fragment_page.view.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private var filmsFragment: FragmentPage? = null
    private var cafesFragment: FragmentPage? = null
    private var othersFragment: FragmentPage? = null
    private var viewModel: MainViewModel? = null
    private var toolbar: Toolbar? = null
    private var recyclerView:RecyclerView? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.films -> {
                toolbar?.setTitle(R.string.title_films)
                supportFragmentManager.beginTransaction()
                        .replace(R.id.my_fragment, filmsFragment)
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.cafes -> {
                toolbar?.setTitle(R.string.title_cafes)
                supportFragmentManager.beginTransaction()
                        .replace(R.id.my_fragment, cafesFragment)
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.others -> {
                toolbar?.setTitle(R.string.title_others)
                supportFragmentManager.beginTransaction()
                        .replace(R.id.my_fragment, othersFragment)
                        .commit()
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

            }

            R.id.add -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {

        fun obtainViewModel(activity: FragmentActivity): MainViewModel {
            val factory = ViewModelFactory.getInstance(activity.application)
            return ViewModelProviders.of(activity, factory).get(MainViewModel::class.java)
        }
    }

    private fun initFragments(){
        filmsFragment = FragmentPage()
        cafesFragment = FragmentPage()
        othersFragment = FragmentPage()
    }

    private fun setToolbar(){
        toolbar = findViewById(R.id.my_toolbar)
        toolbar?.setTitle(R.string.title_films)
        toolbar?.inflateMenu(R.menu.menu_tolbar)
    }

    private fun setRecyclerView(){
        recyclerView = my_fragment.recycler
        val list = arrayListOf(Film("lololo", "Женя", Date(), "High", "Comedy") as Plan)
        val adapter = RecyclerAdapter(list)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter = adapter
    }
}
