package com.rohim.jetrekomendasikomik.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rohim.jetrekomendasikomik.R
import com.rohim.jetrekomendasikomik.ui.theme.JetRekomendasiKomikTheme

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.me),
            contentDescription = stringResource(R.string.name),
            modifier = Modifier
                .size(320.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(R.string.name),
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3ddc84),
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = stringResource(R.string.email),
            style = MaterialTheme.typography.subtitle2
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AboutPreview() {
    JetRekomendasiKomikTheme {
        AboutScreen()
    }
}