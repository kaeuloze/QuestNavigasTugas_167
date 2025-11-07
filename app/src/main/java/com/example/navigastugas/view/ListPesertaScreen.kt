package com.example.navigastugas.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.BorderStroke

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListPesertaScreen(
    goToForm: () -> Unit,
    goToHome: () -> Unit = {}
) {
    // Tema warna
    val pinkPrimary = Color(0xFFE91E63)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "List Daftar Peserta",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // CARD 1
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(2.dp, pinkPrimary), // ⬅️ Garis tepi pink
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent // ⬅️ Tidak ada warna latar
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Kolom kiri
                    Column(modifier = Modifier.weight(1f)) {
                        Text("NAMA LENGKAP", fontWeight = FontWeight.Bold, color = pinkPrimary, fontSize = 14.sp)
                        Text("Dipo Sanjaya")

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("STATUS PERKAWINAN", fontWeight = FontWeight.Bold, color = pinkPrimary, fontSize = 14.sp)
                        Text("Lajang")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    // Kolom kanan
                    Column(modifier = Modifier.weight(1f)) {
                        Text("JENIS KELAMIN", fontWeight = FontWeight.Bold, color = pinkPrimary, fontSize = 14.sp)
                        Text("Laki - Laki")

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("ALAMAT", fontWeight = FontWeight.Bold, color = pinkPrimary, fontSize = 14.sp)
                        Text("Tegal")
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // ==== CARD 2 ====
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(2.dp, pinkPrimary),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text("NAMA LENGKAP", fontWeight = FontWeight.Bold, color = pinkPrimary, fontSize = 14.sp)
                        Text("Farhasiva Aulia")

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("STATUS PERKAWINAN", fontWeight = FontWeight.Bold, color = pinkPrimary, fontSize = 14.sp)
                        Text("Lajang")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text("JENIS KELAMIN", fontWeight = FontWeight.Bold, color = pinkPrimary, fontSize = 14.sp)
                        Text("Perempuan")

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("ALAMAT", fontWeight = FontWeight.Bold, color = pinkPrimary, fontSize = 14.sp)
                        Text("Bogor")
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // ==== Tombol Navigasi ====
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // 🔹 Tombol Beranda - Outline Pink
                OutlinedButton(
                    onClick = goToHome,
                    border = BorderStroke(2.dp, pinkPrimary),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = pinkPrimary
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Beranda", fontWeight = FontWeight.Bold)
                }

                // 🔹 Tombol Formulir - Pink Solid
                Button(
                    onClick = goToForm,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = pinkPrimary,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Formulir", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}


