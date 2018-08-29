package ew.bookofplans.viewModel

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.annotation.VisibleForTesting


class ViewModelFactory() : ViewModelProvider.NewInstanceFactory() {

    @SuppressLint("StaticFieldLeak")

    companion object {
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application): ViewModelFactory? = if (INSTANCE == null) ViewModelFactory() else INSTANCE

        @VisibleForTesting
        fun destroyInstance() {
            INSTANCE = null
        }
    }


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

}