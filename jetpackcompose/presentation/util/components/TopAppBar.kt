package com.example.jetpackcompose.presentation.util.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.material3.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    title: String
){
    TopAppBar(
        title = { Text(text = title) },
        modifier = Modifier.shadow(elevation = 5.dp) )
    
}