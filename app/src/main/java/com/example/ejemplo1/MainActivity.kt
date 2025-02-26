package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
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
        Column {
            SimpleButton()
            ButtonWithColor()
            ButtonWithTwoTextView()
            ButtonWithIcon()
            ButtonWithRectangleShape()
            ButtonWithRoundCornerShape()
            ButtonWithCutCornerShape()
            ButtonWithBorder()
            ButtonWithElevation()
        }
    }
}

@Composable
fun SimpleButton() {
    Button(onClick = {
        //your onclick code here
    }) {
        Text(text = "Simple Button")
    }
}

@Composable
fun ButtonWithColor(){
    Button(onClick = {
        //your onclick code
    },
        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray))

    {
        Text(text = "Button with gray background",color = Color.White)
    }
}

@Composable
fun ButtonWithTwoTextView() {
    Button(onClick = {
        //your onclick code here
    }) {
        Text(text = "Click ", color = Color.Magenta)
        Text(text = "Here", color = Color.Green)
    }
}

@Composable
fun ButtonWithIcon() {
    Button(onClick = {}) {
        Image(
            painterResource(id = R.drawable.ic_cart),
            contentDescription ="Cart button icon",
            modifier = Modifier.size(20.dp))

        Text(text = "Add to cart",Modifier.padding(start = 10.dp))
    }
}

//Forma de Rectangulo:

@Composable
fun ButtonWithRectangleShape() {
    Button(onClick = {}, shape = RectangleShape) {
        Text(text = "Forma de Rectangulo")
    }
}
//Esquina Redondeada:

@Composable
fun ButtonWithRoundCornerShape() {
    Button(onClick = {}, shape = RoundedCornerShape(20.dp)) {
        Text(text = "Esquina redondeada")
    }
}

//Esquina con terminacion recta:

@Composable
fun ButtonWithCutCornerShape() {
    Button(onClick = {}, shape = CutCornerShape(10)) {
        Text(text = "Esquina en corte")
    }
}

@Composable
fun ButtonWithBorder() {
    Button(
        onClick = {
            //codigo
        },
        border = BorderStroke(1.dp, Color.Red),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
    ) {
        Text(text = "Boton con borde", color = Color.DarkGray)
    }
}

@Composable
fun ButtonWithElevation() {
    Button(onClick = {
        //Codigo
    },elevation =  ButtonDefaults.buttonElevation(
        defaultElevation = 10.dp,
        pressedElevation = 15.dp,
        disabledElevation = 0.dp
    )) {
        Text(text = "Button con elevacion")
    }
}