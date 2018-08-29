package ew.bookofplans.view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ew.bookofplans.R
import ew.bookofplans.viewModel.MainViewModel

class FragmentPage : Fragment() {

    private var viewModel: MainViewModel? = null
    private var myArguments: Bundle? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        viewModel = MainActivity.obtainViewModel(context as FragmentActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myArguments = arguments
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_page, container, false)

        return v
    }


}