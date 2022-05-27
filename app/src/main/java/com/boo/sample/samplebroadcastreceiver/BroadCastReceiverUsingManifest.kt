package com.boo.sample.samplebroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class BroadCastReceiverUsingManifest : BroadcastReceiver() {
    val TAG = this::class.java.simpleName
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action.equals("example.test.broadcast")){
            Toast.makeText(context, "Customize broadcast!", Toast.LENGTH_LONG).show()
            Log.d(TAG, "onReceive: BATTERY CHANGED")
        }
    }
}