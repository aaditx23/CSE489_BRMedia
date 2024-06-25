package com.aaditx23.brmedia.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apartment
import androidx.compose.material.icons.filled.MusicVideo
import androidx.compose.material.icons.filled.NetworkPing
import androidx.compose.material.icons.filled.SupervisedUserCircle
import androidx.compose.material.icons.outlined.Apartment
import androidx.compose.material.icons.outlined.MusicVideo
import androidx.compose.material.icons.outlined.NetworkPing
import androidx.compose.material.icons.outlined.SupervisedUserCircle
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavDrawerItem(
    val selectedIcon: ImageVector? = null,
    val unselectedIcon: ImageVector? = null,
    val title: String,
    val isDivider: Boolean = false,
    val isHeader: Boolean = false,
    val index: Int? = null
){
    object Broad_Rec: NavDrawerItem(
        selectedIcon = Icons.Filled.NetworkPing,
        unselectedIcon = Icons.Outlined.NetworkPing,
        title = "Broadcast-Receiver",
        index = 0
    )
    object Media: NavDrawerItem(
        selectedIcon = Icons.Filled.MusicVideo,
        unselectedIcon = Icons.Outlined.MusicVideo,
        title = "Media",
        index = 1
    )

    object Divider: NavDrawerItem(
        title = "Divider",
        isDivider = true
    )

    companion object{
        val navDrawerItems = listOf(
            Broad_Rec,
            Media
        )
    }
}