package me.inassar.common.composable

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.inassar.common.config.Platform
import me.inassar.platform.ChangeStatusBarColors
import me.inassar.platform.currentPlatform

/**
 * Created by Ahmed Nassar on 8/6/23.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    appBarColor: Color = Color.White,
    statusBarColor: Color = Color.White,
    contentColor: Color = Color.White,
    canPop: Boolean = false,
    onNavigationBackClick: () -> Unit = {},
    appBarActions: @Composable RowScope.() -> Unit = {}
) {
    val isAndroid = when (currentPlatform) {
        Platform.IOS -> false
        Platform.ANDROID -> true
        Platform.DESKTOP -> false
    }

    ChangeStatusBarColors(statusBarColor = statusBarColor)

    Surface(shadowElevation = 3.dp) {

        TopAppBar(
            title = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    textAlign = if (isAndroid) TextAlign.Start else TextAlign.Center
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = appBarColor,
                actionIconContentColor = contentColor,
                navigationIconContentColor = contentColor,
                titleContentColor = contentColor
            ),
            navigationIcon = {
                if (canPop) {
                    IconButton(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .size(width = 30.dp, height = 40.dp),
                        onClick = { onNavigationBackClick() }
                    ) {
                        Icon(
                            imageVector = if (isAndroid)
                                Icons.Filled.ArrowBack
                            else
                                Icons.Filled.ArrowBackIosNew,
                            contentDescription = null
                        )
                    }
                }
            },
            actions = appBarActions
        )
    }
}