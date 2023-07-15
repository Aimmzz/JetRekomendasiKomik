package com.rohim.jetrekomendasikomik.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rohim.jetrekomendasikomik.di.Injection
import com.rohim.jetrekomendasikomik.model.DataKomik
import com.rohim.jetrekomendasikomik.model.Komik
import com.rohim.jetrekomendasikomik.ui.UiState
import com.rohim.jetrekomendasikomik.ui.ViewModelFactory
import com.rohim.jetrekomendasikomik.ui.component.KomikItem
import com.rohim.jetrekomendasikomik.ui.theme.JetRekomendasiKomikTheme
import com.rohim.jetrekomendasikomik.ui.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (Long) -> Unit
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllKomik()
            }
            is UiState.Success -> {
                HomeContent(
                    komik = uiState.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun HomeContent(
    komik: List<Komik>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit
) {
    LazyColumn(modifier = modifier){
        items(komik){ manga ->
            KomikItem(
                title = manga.komik.title,
                author = manga.komik.author,
                image = manga.komik.image,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navigateToDetail(manga.komik.id)
                    }
            )
        }
    }
}

//@Preview
//@Composable
//fun HomePreview() {
//    JetRekomendasiKomikTheme {
//        HomeScreen()
//    }
//}