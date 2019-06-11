package com.aengussong.teststorage

import android.app.Service
import android.content.Intent
import android.os.Binder
import java.util.*

class ProviderService : Service() {

    private val storageInstance = MediatorStorage.instance

    private val timer = Timer()
    private val random = Random(5)

    override fun onBind(intent: Intent?): Binder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startTimer()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }

    private fun startTimer() {
        val timerTask = object : TimerTask() {
            override fun run() {
                storageInstance.updateData(random.nextInt())
            }
        }

        timer.schedule(timerTask, 0, 1000L)
    }
}