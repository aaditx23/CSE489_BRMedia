package com.aaditx23.brmedia.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Audiotrack
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material.icons.outlined.Audiotrack
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.VideoLibrary
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    badge: Boolean,
    badgeCount: Int = 0,
    val idx: Int
) {
    var badge = mutableStateOf(badge)
    val badgeCount = mutableIntStateOf(badgeCount)
    object Picture: BottomNavItem(
        title = "Picture",
        selectedIcon = Icons.Filled.Image,
        unselectedIcon = Icons.Outlined.Image,
        badge = false,
        idx = 0
    )
    object Audio: BottomNavItem(
        title = "Audio",
        selectedIcon = Icons.Filled.Audiotrack,
        unselectedIcon = Icons.Outlined.Audiotrack,
        badge = false,
        idx = 1
    )
    object Video: BottomNavItem(
        title = "Video",
        selectedIcon = Icons.Filled.VideoLibrary,
        unselectedIcon = Icons.Outlined.VideoLibrary,
        badge = false,
        idx = 2
    )


    companion object{
        val bottomNavItemList = listOf(
            Picture,
            Audio,
            Video
        )
    }



}

