package com.ben39053372.myandroidtemplate.utils

import android.app.Service
import android.content.Intent
import android.os.*
import android.widget.Toast
import timber.log.Timber


/**
 * BaseService extends Service
 * will create a new Thread to avoid use the main thread
 *
 */
abstract class BaseService: Service() {

    /**
     * use for create a new thread
     */
    abstract val threadName: String

    private val binder: IBinder? = null
    private var serviceLooper: Looper? = null
    private var serviceHandler: ServiceHandler? = null

    /**
     * * This will call when onStartCommand.
     *
     * * This will receive service start intent.
     */
    abstract fun onRun(data: Bundle)

    inner class ServiceHandler(looper: Looper): Handler(looper){
        override fun handleMessage(msg: Message) {
            // do some work here, like download a file.
            try {
                Timber.i("do some work")
                onRun(msg.data)
            }catch(e: InterruptedException) {
                // Restore interrupt status.
                Thread.currentThread().interrupt()
            }
            stopSelf(msg.arg1)
        }
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Timber.d("onStartCommand")

        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show()

        // For each start request, send a message to start a job and deliver the
        // start ID so we know which request we're stopping when we finish the job
        serviceHandler?.obtainMessage()?.also { msg ->
            msg.arg1 = startId
            msg.data = intent.extras
            serviceHandler?.sendMessage(msg)

        }

        // If we get killed, after returning from here, restart
        return START_STICKY
    }

    override fun onCreate() {
        Timber.d("onCreate")
        HandlerThread(threadName, Process.THREAD_PRIORITY_BACKGROUND).apply {
            start()

            serviceLooper = looper
            serviceHandler = ServiceHandler(looper)
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        return binder
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Service Destroy", Toast.LENGTH_SHORT).show()
    }
}