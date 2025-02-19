package com.example.practica2

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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica2.ui.theme.Practica2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica2Theme {
                    GreetingPreview()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        SimpleImage()
        SimpleTextField()
        SimpleTextField2()
        ButtonWithColor()
    }
}

@Composable
fun SimpleImage() {
    Image(
        painter = painterResource(id = R.drawable.prog),
        contentDescription = "Programacion",
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        contentScale = ContentScale.Crop

    )
}

@Composable
fun SimpleTextField() {
    Spacer(modifier = Modifier.height(20.dp))
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = {
            Text(
                text = "Valor 1"
            )
        }
    )
}

@Composable
fun SimpleTextField2() {
    Spacer(modifier = Modifier.height(44.dp))
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = {
            Text(
                text = "Valor 2"
            )
        }
    )
}

@Composable
fun ButtonWithColor(){
    Spacer(modifier = Modifier.height(32.dp))
    Button(
        onClick = {
            //your onclick code
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
    )

    {
        Text(text = "Calcular", color = Color.White)
    }
}