package com.example.navigastugas.view

import com.example.navigastugas.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape


@Composable
fun WelcomeScreen(
    onClickNext: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //TEKS SELAMAT DATANG
        Text(
            text = "Selamat Datang",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFFE91E63),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(40.dp))

        // LOGO
        Image(
            painter = painterResource(id = R.drawable.logo_card),
            contentDescription = "Logo Aplikasi",
            modifier = Modifier
                .size(200.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))
        // NAMA DAN NIM
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "    Mariska Esa Purnomo",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFE91E63),
                textAlign = TextAlign.Center
            )
            Text(
                text = "20230140167",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(60.dp))

    }

}


