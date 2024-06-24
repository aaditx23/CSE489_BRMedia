package com.buccbracu.bucc.ui

import android.annotation.SuppressLint
import android.content.BroadcastReceiver

import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aaditx23.brmedia.components.NavDrawer
import com.aaditx23.brmedia.components.TopActionBar
import kotlinx.coroutines.launch
import com.aaditx23.brmedia.ui.screens.Media
import com.aaditx23.brmedia.ui.screens.SystemBroadcast



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Main(){

    var selectedIndexDrawer by rememberSaveable {
        mutableIntStateOf(0)
    }
    val navController = rememberNavController()
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var scope = rememberCoroutineScope()
    var scrollState = rememberScrollState()



    
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { ModalDrawerSheet {
            NavDrawer(
                scrollState = scrollState,
                selectedIndex = selectedIndexDrawer,
                onClick = {item ->
                    navController.navigate(item.title)
                    scope.launch {
                        drawerState.close()
                    }
                    selectedIndexDrawer = item.index!!
                    
                },
                
            )
            }
        },
        gesturesEnabled = true
    ) {

        Scaffold(
            topBar = { TopActionBar(drawerState = drawerState, scope = scope ) }
        ){
            NavHost(navController = navController, startDestination = "Broadcast-Receiver" ){
                // Routes
                composable("Media"){
                    Media()
                }
                composable("Broadcast-Receiver"){
                    SystemBroadcast()
                }
            }
        }
        
    }
}



