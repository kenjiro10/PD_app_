package com.example.pd_app

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.pd_app.ui.theme.PD_AppTheme
import androidx.compose.material.*
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PD_AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                }
            }
        }
    }
}
sealed class Item(var dist: String, var icon: ImageVector) {
    object Home : Item("Home", Icons.Filled.Home)
    object Email : Item("Email", Icons.Filled.Email)
    object Stars : Item("Stars", Icons.Filled.Star)
    object Lists : Item("Lists", Icons.Filled.List)
}
@Composable
fun MultipleItemsBottomNavigation() {
    var selectedItem = remember { mutableStateOf(0) }
    val items = listOf(Item.Home, Item.Email, Item.Stars, Item.Lists)
    BottomNavigation {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.dist) },
                label = { Text(item.dist) },
                alwaysShowLabel = false, // 4つ以上のItemのとき
                selected = selectedItem.value == index,
                onClick = { selectedItem.value = index }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview2() {
    MyApplicationTheme {
        MultipleItemsBottomNavigation()
    }
}
@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = BottomNavigationDefaults.Elevation,
    content: @Composable RowScope.() -> Unit
) {
}
