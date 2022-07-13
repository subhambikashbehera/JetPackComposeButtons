package com.subhambikash.jetpackcompose2

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.subhambikash.jetpackcompose2.ui.theme.JetPackCompose2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()) {

                JetPackCompose2Theme {
                    CustomButtons()
                }

            }

        }
    }


    fun showToast(context: Context, value: String) {
        Toast.makeText(context, value, Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackCompose2Theme {
        CustomButtons()
    }
}

@Composable
fun CustomButtons() {
    val context = LocalContext.current


    Button(onClick = {
        Toast.makeText(context, "Simple Button Clicked", Toast.LENGTH_SHORT).show()
    }, enabled = true) {
        Text(text = "button 1")
    }

    Button(onClick = {
        Toast.makeText(context, "Simple Button Clicked", Toast.LENGTH_SHORT).show()
    }, enabled = false) {
        Text(text = "button 1")
    }

    TextButton(onClick = {
        Toast.makeText(context, "clicked on text button", Toast.LENGTH_SHORT).show()
    }) {
        Text(text = "textButton")
    }

    OutlinedButton(onClick = {
        Toast.makeText(context,
            "clicked on outlined Button",
            Toast.LENGTH_SHORT).show()
    }, modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp, 0.dp)) {
        Text(text = "outlined button new")
    }

    IconButton(onClick = {
        MainActivity().showToast(context = context,
            "clicked on icon button")
    }) {
        Icon(imageVector = Icons.Filled.Refresh,
            contentDescription = "REFRESH",
            tint = Color.DarkGray,
            modifier = Modifier.size(50.dp))
    }


    Button(onClick = { MainActivity().showToast(context, "shapedButton") },
        contentPadding = PaddingValues(10.dp),
        border = BorderStroke(10.dp,
            Color.DarkGray),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.Blue,
            contentColor = Color.Red
        ),
        shape = CutCornerShape(10.dp)
        ) {
        Text(text = "shaped Button", style = MaterialTheme.typography.h4, modifier = Modifier.padding(10.dp))
    }

    Button(onClick = { MainActivity().showToast(context, "shapedButton") },
        contentPadding = PaddingValues(10.dp),
        border = BorderStroke(10.dp,
            Color.DarkGray),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.Blue,
            contentColor = Color.Red
        ),
        shape = CircleShape
    ) {
        Text(text = "shaped Button", style = MaterialTheme.typography.h4, modifier = Modifier.padding(10.dp))
    }

    Button(onClick = { MainActivity().showToast(context, "shapedButton") },
        contentPadding = PaddingValues(10.dp),
        border = BorderStroke(10.dp,
            Color.DarkGray),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.Blue,
            contentColor = Color.Red
        ),
    ) {
        Text(text = "shaped Button", style = MaterialTheme.typography.h4, modifier = Modifier.padding(10.dp))
    }


}

