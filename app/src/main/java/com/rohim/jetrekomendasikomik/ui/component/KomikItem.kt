package com.rohim.jetrekomendasikomik.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rohim.jetrekomendasikomik.R
import com.rohim.jetrekomendasikomik.ui.theme.JetRekomendasiKomikTheme
import com.rohim.jetrekomendasikomik.ui.theme.Shapes

@Composable
fun KomikItem(
    title: String,
    author: String,
    image: Int,
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(100.dp)
                .clip(Shapes.medium)
                .padding(8.dp)
        )
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = modifier
        ) {
            Text(
                text = title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
                modifier= Modifier.padding(4.dp)
            )
            Text(
                text = author,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    JetRekomendasiKomikTheme {
        KomikItem(
            title = "Jujutsu Kaisen",
            author = "Gege Akutami",
            image = R.drawable.jujutsukaisen
        )
    }
}