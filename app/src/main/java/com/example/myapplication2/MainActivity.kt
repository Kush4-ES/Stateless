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
import kotlin.random.Random

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
    var estadoImagenes: Int by remember { mutableIntStateOf(0) } //Estado para controlar el paso
    var contadorExprimir: Int by remember { mutableIntStateOf(1) }

    //Hacemos una variable para las imagenes
    val imagenes = when (estadoImagenes) {
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    //Hacemos una variable para el texto de las imagenes para luego pasarlas
    var textos = when (estadoImagenes) {
        0 -> "Agafa una llimona"
        1 -> "Esprem la llimona"
        2 -> "Beu-te-la"
        else -> "Comença de nou"
    }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = imagenes), contentDescription = textos, alpha = 2f
        )

        //Hacemos el TextBotton
        TextButton(
            onClick = {
                if (estadoImagenes == 1) {
                    contadorExprimir--
                    if (contadorExprimir <= 0) {
                        estadoImagenes++
                    }

                } else {
                    estadoImagenes++
                }

                if (estadoImagenes > 3) {
                    estadoImagenes = 0
                }

                if (estadoImagenes == 1) {
                    contadorExprimir = ExprimirRandom()
                }

            }) {
            Text(
                text = textos, fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black
            )
        }
    }

}

fun ExprimirRandom(): Int {
    return Random.nextInt(1, 10)
}

}
@Composable
fun DiceRoller() {

    // Variables
    var dado_1: Int by remember { mutableIntStateOf(1) }
    var dado_2: Int by remember { mutableIntStateOf(1) }
    var dadoImagen1: Int by remember { mutableIntStateOf(R.drawable.dice_1) }
    var dadoImagen2: Int by remember { mutableIntStateOf(R.drawable.dice_1) }
    var context = LocalContext.current

    // Fondo
    Image(
        painter = painterResource(id = R.drawable.tapestry),
        contentDescription = "Fondo",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )

    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Image(
            painter = painterResource(id = R.drawable.title),
            contentDescription = "Logo",
            modifier = Modifier.size(400.dp)
        )

        Button(
            onClick = {
                //Damos un numero random a los dados
                dado_1 = NumeroRandomDado()
                dado_2 = NumeroRandomDado()

                //Cuando hemos dado el numero random, miramos que numero esta y cambiamos la imagen
                dadoImagen1 = RandomDado(dado_1) //Dado 1
                dadoImagen2 = RandomDado(dado_2) //Dado 2

                if (dado_1 == 6 && dado_2 == 6) {
                    Toast.makeText(context, "¡JACKPOT!", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth(0.9f),
            colors = buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Roll the dice", fontSize = 24.sp, color = Color.White)
        }

        Spacer(Modifier.fillMaxHeight(0.05f))

        //Dados
        Row {
            Image(
                painter = painterResource(id = dadoImagen1),
                contentDescription = "Dado 1",
                modifier = Modifier.size(200.dp).clickable {
                    dado_1 = NumeroRandomDado()
                    dadoImagen1 = RandomDado(dado_1)
                }
            )

            Image(
                painter = painterResource(id = dadoImagen2),
                contentDescription = "Dado 2",
                modifier = Modifier.size(200.dp).clickable {
                    dado_2 = NumeroRandomDado()
                    dadoImagen2 = RandomDado(dado_2)
                }
            )
        }
    }
}

// Funcion de dado random
fun RandomDado(dado: Int): Int {
    return when (dado) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}

fun NumeroRandomDado(): Int {
    return Random.nextInt(1, 7)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplication2Theme {
        LemonadeAPP(modifier = Modifier)
    }

}