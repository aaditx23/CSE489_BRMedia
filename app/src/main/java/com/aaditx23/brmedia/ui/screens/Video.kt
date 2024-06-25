package com.aaditx23.brmedia.ui.screens

import android.Manifest
import android.net.Uri
import android.os.Build
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun Video() {
    var file = "/storage/emulated/0/Documents/demo.mp4"
    var hasPermission by remember { mutableStateOf(false) }
    var videoView: VideoView? by remember { mutableStateOf(null) }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted ->
            hasPermission = granted
        }
    )

    LaunchedEffect(Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            permissionLauncher.launch(Manifest.permission.READ_MEDIA_VIDEO)
        } else {
            hasPermission = true
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            videoView?.stopPlayback()
        }
    }

    AndroidView(
        factory = {
            VideoView(it).apply {
                videoView = this
                setVideoURI(Uri.parse(file))
                setMediaController(MediaController(it).apply {
                    setAnchorView(this@apply)
                })
                requestFocus()
                start()
            }
        },
        update = {
            videoView = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    )


}