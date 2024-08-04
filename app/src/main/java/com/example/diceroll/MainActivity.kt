package com.example.diceroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroll.ui.theme.DiceRollTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollScreen()
        }
    }
}

@Composable
fun DiceRollScreen() {
    DiceRollTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            DiceRollApp()
        }
    }
}

@Composable
fun DiceImage(diceImage: Int){
    val imageResource = when(diceImage){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        6 -> R.drawable.dice_6
        else -> R.drawable.dice_1
    }
    Image(
        painter = painterResource(imageResource),
        contentDescription = stringResource(R.string.dice_image),
        modifier = Modifier
            .padding(16.dp)
            .size(200.dp)
    )
}

@Composable
fun RollButton(onDiceRoll: () -> Unit){
    FilledTonalButton(
        onClick = onDiceRoll
    ){
        Text(text = stringResource(R.string.roll))
    }
}

@Composable
fun DiceRollApp(){
    var diceImage by remember { mutableStateOf(1) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DiceImage(diceImage)
        RollButton {
            diceImage = (1..6).random()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    DiceRollScreen()
}
