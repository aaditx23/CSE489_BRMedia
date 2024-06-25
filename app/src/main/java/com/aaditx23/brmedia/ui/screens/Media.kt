package com.aaditx23.brmedia.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aaditx23.brmedia.components.BottomNavigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Media(){
    var selectedIndexBotNav by rememberSaveable {
        mutableIntStateOf(0)
    }
    val navController = rememberNavController()


    Scaffold(
        bottomBar = {
            BottomNavigation(selectedIndex = selectedIndexBotNav) { index ->
                selectedIndexBotNav = index
                when (index) {
                    0 -> navController.navigate("Picture")
                    1 -> navController.navigate("Audio")
                    2 -> navController.navigate("Video")
                }

            }
        }

    ){
        NavHost(navController = navController, startDestination = "Picture" ){
            // Routes
            composable("Picture"){
                Picture()
            }
            composable("Audio"){
                Audio()
            }
            composable("Video"){
                Video()
            }
        }
    }

}