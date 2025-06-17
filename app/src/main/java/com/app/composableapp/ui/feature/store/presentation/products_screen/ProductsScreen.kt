package com.app.composableapp.ui.feature.store.presentation.products_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.app.composableapp.ui.feature.store.presentation.util.components.LoadingDialog
import com.app.composableapp.ui.feature.store.presentation.util.components.TopBar
import androidx.compose.runtime.getValue
import com.app.composableapp.ui.feature.store.presentation.products_screen.component.ProductCard


@Composable
internal fun ProductScreen(
    viewModel: ProductsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    ProductsContent(state = state)
}

@Composable
fun ProductsContent(
    state: ProductsViewState
) {

    LoadingDialog(state.isLoading)

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar(title = "Products") }
    ){
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(top = it.calculateTopPadding()),
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 10.dp
        ) {
            items(state.products) { prod ->
                ProductCard(product = prod)
            }
        }
    }
}