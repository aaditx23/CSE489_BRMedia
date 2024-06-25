package com.aaditx23.brmedia.ui.screens

import android.Manifest
import android.media.MediaPlayer
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun Audio(){
    var file = "/storage/emulated/0/Documents/demo.aac"

    var hasPermission by remember { mutableStateOf(false) }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted ->
            hasPermission = granted
        }
    )

    LaunchedEffect(Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            permissionLauncher.launch(Manifest.permission.READ_MEDIA_AUDIO)
        } else {
            hasPermission = true
        }
    }

    var mediaplayer: MediaPlayer? by remember { mutableStateOf(null) }
    var isPlaying by remember { mutableStateOf(false) }

    DisposableEffect(Unit) {
        onDispose {
            mediaplayer?.release()
        }
    }

    Button(onClick = {
        if (isPlaying){
            mediaplayer?.pause()
        }
        else{
            if (mediaplayer == null){
               mediaplayer = MediaPlayer().apply {
                   setDataSource(file)
                   prepare()
                   start()
               }
            }
            else{
                mediaplayer?.start()
            }
        }
        isPlaying = !isPlaying
    }
    ) {
        Text(text =
            if (isPlaying) "Pause" else "Play"
        )

    }
}