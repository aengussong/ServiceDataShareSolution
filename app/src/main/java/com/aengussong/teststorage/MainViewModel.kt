package com.aengussong.teststorage

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val storage = MediatorStorage.instance

    fun getUpdates(): LiveData<Int> = storage.getUpdates()
}