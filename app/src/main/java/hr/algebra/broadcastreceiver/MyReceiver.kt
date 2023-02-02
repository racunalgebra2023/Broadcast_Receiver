package hr.algebra.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

const val BCAST_KEY   = "hr.algebra.broadcastreceiver.Broadcast"
const val BCAST_EXTRA = "hr.algebra.broadcastreceiver.Extra"

class MyReceiver : BroadcastReceiver( ) {

    override fun onReceive( context: Context?, intent: Intent? ) {
        if( intent?.action == BCAST_KEY ) {
            val myMessage = intent.getStringExtra( BCAST_EXTRA )
            Toast
                .makeText( context, "Received data from broadcast: $myMessage", Toast.LENGTH_LONG )
                .show( )
        }
    }
}