package com.example.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myapplication2.ui.theme.MyApplication2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplication2Theme {
                LemonadeAPP(modifier = Modifier)
            }
        }
    }
}

@Composable
fun Body() {
    var name: String by remember { mutableStateOf("") }
    var showText: Boolean by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Enter Your Name") })
        Button(onClick = { showText = true }) {
            Text("Say Hello")
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        if (showText) {
            Text("Hello $name ", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        }
    }
}

@Composable
fun CalculaPropia() {
    var preuMEnu: String by remember { mutableStateOf("") }
    var percetatgePropina: String by remember { mutableStateOf("") }
    var preuTotal: Double by remember { mutableDoubleStateOf(0.0) }
    var showText: Boolean by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = preuMEnu,
            onValueChange = { preuMEnu = it },
            label = { Text("Introduiex el preu total del menu") })
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        TextField(
            value = percetatgePropina,
            onValueChange = { percetatgePropina = it },
            label = { Text("Introduix el porcentatge de la propina") })
        Button(onClick = {
            var descuento: Double = percetatgePropina.toDouble() / 100
            preuTotal = preuMEnu.toDouble() + (descuento * preuMEnu.toDouble())
            showText = true
        }) {
            Text("Calcular")
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        if (showText) {
            Text("Preu Total a Pagar $preuTotal", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        }
    }
}

@Composable
fun CalculImc() {
    var nomUsuari: String by remember { mutableStateOf("") }
    var anyNeixement: String by remember { mutableStateOf("") }
    var alcada: String by remember { mutableStateOf("") }
    var edad: Int by remember { mutableStateOf(0) }
    var pes: String by remember { mutableStateOf("") }
    var calculo: Double by remember { mutableDoubleStateOf(0.0) }
    var showText: Boolean by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = nomUsuari,
            onValueChange = { nomUsuari = it },
            label = { Text("introduix el teu nom d'usuari") })
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        TextField(
            value = anyNeixement,
            onValueChange = { anyNeixement = it },
            label = { Text("introduix la teva data de naixement") })
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        TextField(
            value = alcada,
            onValueChange = { alcada = it },
            label = { Text("introduix el teva alçada") })
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        TextField(
            value = pes,
            onValueChange = { pes = it },
            label = { Text("introduix el teu pes") })
        Button(onClick = {
            edad = 2025 - anyNeixement.toInt()
            calculo = pes.toInt() / Math.pow(alcada.toDouble(), 2.0)
            showText = true
        }) {
            Text("calcula")
        }
        if (showText) {
            if (calculo < 18.5) {
                Text("$nomUsuari, $edad , IMC Insuficient")
            } else if (18.5 >= calculo && calculo <= 24.9) {
                Text("$nomUsuari, $edad , IMC Normal")
            } else if (25 >= calculo && calculo <= 50) {
                Text("$nomUsuari, $edad , IMC Sobrepes")
            } else if (50 <= calculo) {
                Text("$nomUsuari, $edad , IMC Obesitat")
            } else {
                Text("hola Panceta")
            }
        }
    }
}

@Composable
fun NumeroSecreto() {
    var numeroSecreto: Int by remember { mutableIntStateOf((0..100).random()) }
    var numero: String by remember { mutableStateOf("") }
    var showText: Boolean by remember { mutableStateOf(false) }
    var contador: Int by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = numero,
            onValueChange = { numero = it; showText = false },
            label = { Text("Introdueix un Numero") })
        Button(onClick = {
            showText = true
            contador++
        }) {
            Text("Comprobar")
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.1f))
        if (showText) {
            Text(adivinar(numero, numeroSecreto))
            Text("Intentos" + contador.toString())
        }
    }
}

fun adivinar(numero: String, numeroSecreto: Int): String {
    var printar = ""
    when {
        numero.toInt() == numeroSecreto -> printar = "Has Encertat"
        numero.toInt() > numeroSecreto -> printar = "el numero es mes petit"
        numero.toInt() < numeroSecreto -> printar = "el numero es mes gran"
    }
    return printar
}

@Composable
fun ConversorUnitats(modifier: Modifier) {
    var valor: String by remember { mutableStateOf("") }
    var resultado: String by remember { mutableStateOf("") }
    var showText: Boolean by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var hobbies = listOf(
        "De polzada a centímetre",
        "De iarda a metre",
        "De milla a quilòmetre",
        "De centímetre a polzada",
        "De metre a iarda",
        "De quilòmetre a milla"
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "CONVERSORS UNITARIS",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        TextField(
            value = valor,
            onValueChange = {
                valor = it
                showText = false
            },
            label = { Text("Introduce el valor que quieres transformar") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Column() {
            OutlinedTextField(
                value = selectedText,
                onValueChange = { selectedText = it },
                enabled = false,
                readOnly = true,
                modifier = Modifier
                    .clickable { expanded = true }
                    .fillMaxWidth()
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            hobbies.forEach { hobby ->
                DropdownMenuItem(text = { Text(text = hobby) }, onClick = {
                    expanded = false
                    selectedText = hobby
                })
            }
        }

        Button(onClick = {
            showText = true
            if (selectedText.isNotBlank() && valor.isNotBlank()) {
                resultado = Cambio(selectedText, valor)
            } else {
                resultado = "Introduce los valores correctamente"
            }
        }) {
            Text("Calcular")
        }
        if (showText) {
            Text(resultado)

        }
    }
}

fun Cambio(selecText: String, valor: String): String {

    return when (selecText) {
        "De polzada a centímetre" -> (valor.toDouble() * 2.54).toString()
        "De iarda a metre" -> (valor.toDouble() * (91 / 100)).toString()
        "De milla a quilòmetre" -> (valor.toDouble() * 1.60934).toString()
        "De centímetre a polzada" -> (valor.toDouble() * 0.39).toString()
        "De metre a iarda" -> (valor.toDouble() * 1.0936133).toString()
        "De quilòmetre a milla" -> (valor.toDouble() * 0.621371192).toString()
        else -> "GORA ETA"
    }
}

@Composable
fun LemonadeAPP(modifier: Modifier) {
    //Variables
    var estadoImagenes : Int by remember { mutableIntStateOf(1) }

    var imagenes = when (estadoImagenes) {
        1 -> R.drawable.lemon_tree
            2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    var estadoTextos = when(estadoImagenes){
        1 -> "Agafa una llimona”"
        2 -> "Esprem la llimona"
        3 -> "Beu-te-la"
        else -> "Comença de Nou"
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.lemon_tree),
            contentDescription = "Example",
            alpha = 1f
        )
        TextButton(onClick = {
            if ()
        }){
            Text(text = "Clica")
        }
    }

    Spacer(modifier = Modifier.fillMaxHeight(0.1f))
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
                .weight(1f),
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
        LemonadeAPP(modifier = Modifier)
    }

}