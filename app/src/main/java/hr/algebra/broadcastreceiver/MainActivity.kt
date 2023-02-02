package hr.algebra.broadcastreceiver

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity( ) {
    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        registerReceivers( )
    }

    private fun registerReceivers( ) {
        val filter = IntentFilter( )
        filter.addAction( BCAST_KEY )
        val myReceiver = MyReceiver( )
        registerReceiver( myReceiver, filter )


        val filter2 = IntentFilter( )
        filter2.addAction( BCAST_NOTIFICATION_KEY )
        val myReceiver2 = NotificationReceiver( )
        registerReceiver( myReceiver2, filter2 )
    }
}