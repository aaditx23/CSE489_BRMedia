package com.aaditx23.brmedia.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter

@Composable
fun Picture(){
    var scale by remember { mutableStateOf(1f) }
    val state = rememberTransformableState { zoomChange, _, _ ->
        scale *= zoomChange
    }

    val painter = rememberAsyncImagePainter("https://img.freepik.com/free-vector/isolated-tree-white-background_1308-26130.jpg?w=740&t=st=1719250285~exp=1719250885~hmac=e547a0a2536b49eb93e604bee59c744b562e7b9e663e2b8bac9826b0cdc15b40")

    Box(
        modifier = Modifier
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .transformable(state = state)
            .fillMaxSize()
            .padding(top = 100.dp, start = 60.dp)
    ){
        Image(painter = painter, contentDescription = "Image from internet")
    }




}