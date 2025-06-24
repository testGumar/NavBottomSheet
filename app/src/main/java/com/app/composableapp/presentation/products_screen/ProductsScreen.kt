package com.app.composableapp.presentation.products_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.app.composableapp.presentation.products_screen.component.ProductCard
import com.app.composableapp.presentation.util.components.LoadingDialog
import com.app.composableapp.presentation.util.components.TopBar
import io.flutter.embedding.android.FlutterActivity


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
    ){ padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            LazyVerticalStaggeredGrid(
                modifier = Modifier
                    .weight(1f) // Let it take remaining space
                    .fillMaxWidth(),
                columns = StaggeredGridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalItemSpacing = 10.dp
            ) {
                items(state.products) { prod ->
                    ProductCard(product = prod)
                }
            }

            LaunchFlutterButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            )
        }
       /* LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(top = it.calculateTopPadding()),
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 10.dp
        ) {
            items(state.products) { prod ->
                ProductCard(product = prod)
            }
        }*/
    }
}
@Composable
fun LaunchFlutterButton(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Button(
        onClick = {
            context.startActivity(
                FlutterActivity.createDefaultIntent(context)
            )
        },
//        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Open Flutter Screen")
    }
}
