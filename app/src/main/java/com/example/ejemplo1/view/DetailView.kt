package com.example.ejemplo1.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ejemplo1.components.ActionButton
import com.example.ejemplo1.components.MainIconButton
import com.example.ejemplo1.components.TitleBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar("Detail View") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Blue
                ),
                navigationIcon = {
                    MainIconButton(Icons.AutoMirrored.Filled.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        },
        floatingActionButton = {
            ActionButton(Color.Blue)
        }
    ) {
        ContentView(navController)
    }
}

@Composable
private fun ContentView(navController: NavController) {
    LazyColumn {
        item {
            Text(
                text = "Item 1",
                modifier = Modifier.padding(64.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        item {
            Text(
                text = "Item 2",
                modifier = Modifier.padding(64.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        item {
            Text(
                text = "Item 3",
                modifier = Modifier.padding(64.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        item {
            Text(
                text = "Item 4",
                modifier = Modifier.padding(64.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        item {
            Text(
                text = "Item 5",
                modifier = Modifier.padding(64.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        item {
            Text(
                text = "Item 6",
                modifier = Modifier.padding(64.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        item {
            Text(
                text = "Item 7",
                modifier = Modifier.padding(64.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        item {
            Text(
                text = "Item 8",
                modifier = Modifier.padding(64.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}