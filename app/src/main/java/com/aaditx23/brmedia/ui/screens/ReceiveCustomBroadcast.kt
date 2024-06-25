package com.aaditx23.brmedia.ui.screens

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class CustomReceiver(private val onMessageReceived: (String) -> Unit) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val message = intent?.getStringExtra("broadcast_message") ?: "No message"
        onMessageReceived(message)
    }
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun ReceiveCustomBroadcast() {
    var receivedMessage by remember {
        mutableStateOf("No message")
    }
    val context = LocalContext.current

    DisposableEffect(Unit) {
        val receiver = CustomReceiver { message ->
            receivedMessage = message
        }

        val filter = IntentFilter("com.aaditx23.brmedia.CUSTOM_BROADCAST")
        context.registerReceiver(receiver, filter, Context.RECEIVER_NOT_EXPORTED)

        onDispose {
            context.unregisterReceiver(receiver)
        }
    }
    
    Text(
        text = "Recieved message: $receivedMessage",
        modifier = Modifier
            .padding(top = 20.dp)
    )

}