package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
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
    Column {
        //TextFieldSencillo()
        //TextFieldPlaceHolder()
        //TextFieldKeyboard()
        //OutLineTextFieldSample()
        TextFieldWithIcons()
    }
}

@Composable
fun  TextFieldSencillo()
{
    var text by remember { mutableStateOf("") }
    Column{
        TextField(
            value = text,
            onValueChange =  { newText ->
                text = newText
            },
            label = { Text( "introduce tu nombre")}
        )
        Text(text = "Tu nombre es:  $text")
    }
}


@Composable
fun TextFieldPlaceHolder(){
    var text by remember{ mutableStateOf("") }
    Column {
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            label = { Text("nombre")},
            placeholder = { Text("introduce tu nombre")}
        )
        Text (text = "Tu nombre es: $text")
    }
}

@Composable
fun TextFieldKeyboard(){
    var text by remember { mutableStateOf("") }
    Column {
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            label = { Text("nombre")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(text = "Tu numero es:  $text")
    }
}


@Composable
fun OutLineTextFieldSample() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column {
        OutlinedTextField(
            value = text,
            label = { Text(text = "Enter Your Name") },
            onValueChange = {
                text = it
            }
        )
        Text(text = "Tu nombre es :  ${text.text}")
    }
}


@Composable
fun TextFieldWithIcons() {
    var text by remember { mutableStateOf(("")) }
    Column {
        return OutlinedTextField(
            value = text,
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
            //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
            onValueChange = {
                text = it
            },
            label = { Text(text = "Email address") },
            placeholder = { Text(text = "Enter your e-mail") },
        )
        Text(text =  "Tu nombre es: $text")
    }
}