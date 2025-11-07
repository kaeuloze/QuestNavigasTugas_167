package com.example.navigasiku.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulirPendaftaranScreen(
    onBackToHome: () -> Unit
) {
    var nama by remember { mutableStateOf(TextFieldValue("")) }
    var alamat by remember { mutableStateOf(TextFieldValue("")) }
    var gender by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    val pinkPrimary = Color(0xFFE91E63)
    val pinkLight = Color(0xFFF8BBD0)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Formulir Pendaftaran",
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
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.95f)
                    .padding(bottom = 8.dp),
                shape = RoundedCornerShape(18.dp),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Top
                ) {
                    // ==== NAMA ====
                    Text(
                        text = "NAMA LENGKAP",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    OutlinedTextField(
                        value = nama,
                        singleLine = true,
                        placeholder = { Text("Isikan nama lengkap") },
                        onValueChange = { nama = it },
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = pinkPrimary,
                            unfocusedBorderColor = pinkLight
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // ==== JENIS KELAMIN ====
                    Text(
                        text = "JENIS KELAMIN",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = (gender == "Laki-laki"),
                            onClick = { gender = "Laki-laki" },
                            colors = RadioButtonDefaults.colors(selectedColor = pinkPrimary)
                        )
                        Text("Laki-laki")
                        Spacer(modifier = Modifier.width(16.dp))
                        RadioButton(
                            selected = (gender == "Perempuan"),
                            onClick = { gender = "Perempuan" },
                            colors = RadioButtonDefaults.colors(selectedColor = pinkPrimary)
                        )
                        Text("Perempuan")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // ==== STATUS PERKAWINAN ====
                    Text(
                        text = "STATUS PERKAWINAN",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        listOf("Janda", "Lajang", "Duda").forEach { item ->
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                RadioButton(
                                    selected = (status == item),
                                    onClick = { status = item },
                                    colors = RadioButtonDefaults.colors(selectedColor = pinkPrimary)
                                )
                                Text(item)
                                Spacer(modifier = Modifier.width(8.dp))
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // ==== ALAMAT ====
                    Text(
                        text = "ALAMAT",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    OutlinedTextField(
                        value = alamat,
                        singleLine = true,
                        placeholder = { Text("Isikan alamat") },
                        onValueChange = { alamat = it },
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = pinkPrimary,
                            unfocusedBorderColor = pinkLight
                        )
                    )

                    Spacer(modifier = Modifier.height(60.dp))

                    // Tombol Navigasi
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        OutlinedButton(
                            onClick = onBackToHome,
                            border = BorderStroke(2.dp, pinkPrimary),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = pinkPrimary
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("Beranda", fontWeight = FontWeight.Bold)
                        }

                        Button(
                            onClick = { showDialog = true },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = pinkPrimary,
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("Submit", fontWeight = FontWeight.Bold)
                        }
                    }
                    // Dialog Konfirmasi
                    if (showDialog) {
                        AlertDialog(
                            onDismissRequest = {},
                            confirmButton = {
                                Button(
                                    onClick = {
                                        showDialog = false
                                        onBackToHome()
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = pinkPrimary,
                                        contentColor = Color.White
                                    ),
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Text("OK", fontWeight = FontWeight.Bold)
                                }
                            },
                            title = {
                                Text(
                                    text = "Data Berhasil Disimpan",
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            text = {
                                Column(modifier = Modifier.padding(8.dp)) {
                                    Text(
                                        text = "Nama           : " + nama.text,
                                        color = Color.Black
                                    )
                                    Text(
                                        text = "Jenis Kelamin  : " + gender,
                                        color = Color.Black
                                    )
                                    Text(
                                        text = "Status         : " + status,
                                        color = Color.Black
                                    )
                                    Text(
                                        text = "Alamat         : " + alamat.text,
                                        color = Color.Black
                                    )
                                }

                            }
                        )
                    }
                }
            }
        }
    }
}
