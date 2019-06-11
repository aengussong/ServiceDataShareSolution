package com.aengussong.teststorage

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

class MediatorStorage {

    companion object {
        val instance = MediatorStorage()
    }

    private var dataStorage = MutableLiveData<Int>()

    fun updateData(value: Int) {
        dataStorage.postValue(value)
    }

    fun getUpdates(): LiveData<Int> = dataStorage
}