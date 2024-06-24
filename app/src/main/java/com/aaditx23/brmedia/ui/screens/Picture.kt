package com.aaditx23.brmedia.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter

@Composable
fun Picture(){
    Text(text = "Picture")

    val painter = rememberAsyncImagePainter("https://img.freepik.com/free-vector/isolated-tree-white-background_1308-26130.jpg?w=740&t=st=1719250285~exp=1719250885~hmac=e547a0a2536b49eb93e604bee59c744b562e7b9e663e2b8bac9826b0cdc15b40")

    Image(painter = painter, contentDescription = "Image from internet")



}