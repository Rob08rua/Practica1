package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            Ejemplo1Theme {
                GreetingPreview()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ejemplo1Theme {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            SimpleImage()
            ScreenWithButtonAndTextField()
        }
    }
}

@Composable
fun SimpleImage() {
    Image(
        painter = painterResource(id = R.drawable.desc),
        contentDescription = "Descuento",
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        contentScale = ContentScale.Crop

    )
}

@Composable
fun ScreenWithButtonAndTextField() {
    var numero by remember { mutableStateOf(TextFieldValue("")) }
    var descuento by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleTextField(
            numero = numero,
            label = "Precio Original",
            onNumeroChange = { numero = it }
        )

        // TextField para mostrar el resultado
        SimpleTextField(
            numero = descuento,
            label = "Precio con Descuento (15%)",
            onNumeroChange = { descuento = it },
            enabled = false // Hace que este campo no sea editable
        )
        ButtonWithColor(numero = numero, onResult = { descuento = TextFieldValue(it) })
    }
}

@Composable
fun SimpleTextField(
    numero: TextFieldValue,
    label: String,
    onNumeroChange: (TextFieldValue) -> Unit,
    enabled: Boolean = true
) {
    Spacer(modifier = Modifier.height(20.dp))
    TextField(
        value = numero,
        onValueChange = onNumeroChange,
        label = { Text(label) },
        placeholder = { Text("Teclea el valor") },
        enabled = enabled,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun ButtonWithColor(numero: TextFieldValue, onResult: (String) -> Unit) {
    Spacer(modifier = Modifier.height(32.dp))
    Button(
        onClick = {
            val precioOriginal = numero.text.toDoubleOrNull() ?: 0.0
            val precioConDescuento = precioOriginal - (precioOriginal * 0.15) // 15% de descuento
            onResult(precioConDescuento.toString())
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
    ) {
        Text(text = "Calcular Descuento", color = Color.White)
    }
}