//package com.app.nbapp.presentation.ui.coin_list.components
//
//@Composable
//fun CoinListScreen(viewModel: CoinListViewModel = hiltViewModel()) {
//    val state = viewModel.coinState.collectAsState().value
//
//    when (state) {
//        is Resource.Loading -> {
//            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
//        }
//        is Resource.Success -> {
//            LazyColumn {
//                items(state.data ?: emptyList()) { coin ->
//                    Text(
//                        text = "${coin.rank}. ${coin.name} (${coin.symbol})",
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(8.dp)
//                    )
//                }
//            }
//        }
//        is Resource.Error -> {
//            Text(
//                text = state.message ?: "Unknown error",
//                color = Color.Red,
//                modifier = Modifier.padding(16.dp)
//            )
//        }
//    }
//}
