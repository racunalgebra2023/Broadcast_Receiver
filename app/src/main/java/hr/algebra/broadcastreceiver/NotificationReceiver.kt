package hr.algebra.broadcastreceiver

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

const val CHANNEL_ID               = "CHANNEL_1"
const val BCAST_NOTIFICATION_KEY   = "hr.algebra.Notts"

class NotificationReceiver : BroadcastReceiver( ) {

    val TAG = "NotificationReceiver"

    override fun onReceive( context: Context?, intent: Intent? ) {

        Log.i( TAG, "onReceive method called..." )
        createNotificationChannel( context )

        var builder = NotificationCompat.Builder( context!!, CHANNEL_ID )
            .setSmallIcon( R.mipmap.ic_launcher_round )
            .setContentTitle( "You got Broadcast!" )
            //.setContentText( "Someone emmited broadcst and You picked it up..." )
            .setStyle(
                NotificationCompat
                    .BigTextStyle( )
                    .bigText( "Someone emmited broadcst and You picked it up..." )
            )
            .setPriority( NotificationCompat.PRIORITY_DEFAULT )

        NotificationManagerCompat
                        .from( context )
                        .notify( 1, builder.build( ) )

    }

    private fun createNotificationChannel( context : Context? ) {
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
            // Create the NotificationChannel
            val name = context?.getString( R.string.cool_channel_name )
            val descriptionText = context?.getString( R.string.cool_channel_description )
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel( CHANNEL_ID, name, importance )
            mChannel.description = descriptionText
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = context?.getSystemService( NOTIFICATION_SERVICE ) as NotificationManager
            notificationManager.createNotificationChannel( mChannel )
        }
    }
}