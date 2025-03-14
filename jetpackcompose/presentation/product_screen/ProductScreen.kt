package com.example.jetpackcompose.presentation.product_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.jetpackcompose.presentation.product_screen.Components.ProductCard
import com.example.jetpackcompose.presentation.util.components.LoadingDialog
import com.example.jetpackcompose.presentation.util.components.TopAppBar
import androidx.hilt.navigation.compose.hiltViewModel


@SuppressLint("SuspiciousIndentation")
@Composable
internal fun ProductScreen(
    viewmodel: ProductsViewmodel = hiltViewModel()
){
 val state by viewmodel.state.collectAsStateWithLifecycle()
    ProductsContent(state = state)
}

@Composable
fun ProductsContent( state: ProductViewState) {
LoadingDialog(isLoading = state.isLoading  )
    Scaffold(modifier = Modifier.fillMaxSize(),
         topBar = {

             TopAppBar(title = "Products")
         }) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(top = it.calculateTopPadding()),
            columns =  StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 10.dp
        ) {

            items(state.products){
                product ->

                ProductCard(product = product)
            }

        }

    }
}