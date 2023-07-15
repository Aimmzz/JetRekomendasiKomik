package com.rohim.jetrekomendasikomik.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rohim.jetrekomendasikomik.R
import com.rohim.jetrekomendasikomik.di.Injection
import com.rohim.jetrekomendasikomik.model.DataKomik
import com.rohim.jetrekomendasikomik.ui.UiState
import com.rohim.jetrekomendasikomik.ui.ViewModelFactory
import com.rohim.jetrekomendasikomik.ui.theme.JetRekomendasiKomikTheme
import com.rohim.jetrekomendasikomik.ui.viewmodel.DetailViewModel

@Composable
fun DetailScreen(
    komikId: Long,
    viewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository()
        )
    ),
    navigateBack: () -> Unit,
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getKomikById(komikId)
            }
            is UiState.Success -> {
                val data = uiState.data
                DetailComponent(
                    title = data.komik.title,
                    author = data.komik.author,
                    image = data.komik.image,
                    desc = data.komik.desc,
                    onBackClick = navigateBack
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun DetailComponent(
    title: String,
    author: String,
    image: Int,
    desc: String,
    onBackClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()).padding(start = 8.dp, end = 8.dp)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .size(230.dp)
                .padding(22.dp)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = author,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Text(
            text = desc,
            style = MaterialTheme.typography.caption,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 22.dp)
        )
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailContentPreview() {
    JetRekomendasiKomikTheme {
        DetailComponent(
            title = "Jujutsu Kaisen",
            author = "Gege Akutami",
            image = R.drawable.jujutsukaisen,
            desc = stringResource(R.string.desc),
            onBackClick = {},
        )
    }
}