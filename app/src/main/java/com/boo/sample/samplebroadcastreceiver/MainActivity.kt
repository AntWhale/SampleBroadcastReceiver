package com.boo.sample.samplebroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val TAG = this::class.java.simpleName

    val br = object: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if(intent?.action.equals(Intent.ACTION_BATTERY_CHANGED)){
                Log.d(TAG, "onReceive: Battery status is changed")
            }else if(intent?.action.equals(Intent.ACTION_SCREEN_ON)){
                Log.d(TAG, "onReceive: Screen On")
            }else if(intent?.action.equals("example.test.broadcast")){
                Toast.makeText(context, "Customize broadcast!", Toast.LENGTH_LONG).show()
            }
        }
    }

    //val br2 = BroadCastReceiverUsingManifest()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val br: BroadcastReceiver = MyBroadcastReceiver()

        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).apply {
            addAction("com.boo.sample.samplebroadcastreceiver")
        }
        registerReceiver(br, filter)

        Intent().also { intent ->
            intent.action = "com.boo.sample.samplebroadcastreceiver"
            intent.putExtra("data", "Notice me senpai!")
            sendBroadcast(intent)
        }*/

        val sendButton = findViewById<Button>(R.id.send_broadcast)
        sendButton.setOnClickListener {
            val intent = Intent()
            intent.action = "example.test.broadcast"
            sendBroadcast(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_BATTERY_CHANGED)
        filter.addAction(Intent.ACTION_SCREEN_ON)
        //filter.addAction("example.test.broadcast")
        registerReceiver(br, filter)

        /*val filter2 = IntentFilter()
        filter2.addAction("example.test.broadcast")
        registerReceiver(br2 ,filter2)*/
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(br)
        //unregisterReceiver(br2)
    }
}