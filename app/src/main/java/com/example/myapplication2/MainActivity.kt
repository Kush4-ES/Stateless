package com.example.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myapplication2.ui.theme.MyApplication2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplication2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun exercici3(modifier: Modifier) {
    Column(modifier.fillMaxSize()) {
        Row(
            modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Column(
                modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color(0xFFEADDFF))
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Text composable",
                    textAlign = TextAlign.Center,
                    modifier = modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "Displays text and follows the recommended Material Design guidelines",
                    textAlign = TextAlign.Justify
                )
            }
            Column(
                modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color(0xFFD0BCFF))
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Image composable",
                    textAlign = TextAlign.Center,
                    modifier = modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "Creates a composable that lays out and draws a given Painter class object.",
                    textAlign = TextAlign.Justify
                )

            }
        }
        Row(
            modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Column(
                modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color(0xFFB69DF8))
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Row composable",
                    textAlign = TextAlign.Center,
                    modifier = modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "A layout composable that places its children in a horizontal sequence.",
                    textAlign = TextAlign.Justify
                )

            }
            Column(
                modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color(0xFFF6EDFF))
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Column composable",
                    textAlign = TextAlign.Center,
                    modifier = modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "A layout composable that places its children in a vertical sequence.",
                    textAlign = TextAlign.Justify
                )

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    ConstraintLayout(modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxGreen, boxCyan, boxMagenta) = createRefs()
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    bottom.linkTo(boxRed.top)
                    end.linkTo(boxRed.start)
                })
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    bottom.linkTo(boxRed.top)
                    start.linkTo(boxRed.end)
                })
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Cyan)
                .constrainAs(boxCyan) {
                    top.linkTo(boxRed.bottom)
                    end.linkTo(boxRed.start)
                })
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Magenta)
                .constrainAs(boxMagenta) {
                    top.linkTo(boxRed.bottom)
                    start.linkTo(boxRed.end)
                })
    }
}

@Composable
fun Ejercicio1(modifier: Modifier) {
    Column(modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = "Example", Modifier.padding(10.dp)
        )
        Text("Jetpack Compose tutorial".uppercase())
        Text(
            "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs."
        )
        Spacer(modifier.height(10.dp))
        Text("In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app's UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI's construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.")
    }
}

@Composable
fun Ejercicio2(modifier: Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .weight(10f),
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = "Example"
        )
        Text("All Tasks Completed!", textAlign = TextAlign.Center)
        Text("Nice Work!", textAlign = TextAlign.Center)
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplication2Theme {
        Ejercicio2(modifier = Modifier)
    }

}