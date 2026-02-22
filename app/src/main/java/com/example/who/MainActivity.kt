package com.example.who

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import android.widget.Toast
import androidx.compose.ui.tooling.preview.Preview
import com.example.who.ui.theme.WhoTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import android.view.Gravity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhoTheme {
                var firstName by remember { mutableStateOf("") }
                var lastName by remember { mutableStateOf("") }
                var fullName by remember { mutableStateOf("") }
                var welcomeText = stringResource(id = R.string.welcome_to_the_app)
                var enterNameErrorMessage = stringResource(R.string.welcome_to_the_app)
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(16.dp),
                    horizontalAlignment =
                        Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Content goes here
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = firstName,
                            onValueChange = { firstName = it },
                            label = {
                                Text(
                                    text = stringResource(
                                        id = R.string.first_name
                                    )
                                )
                            },
                        )
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = lastName,
                            onValueChange = { lastName = it },
                            label = {
                                Text(
                                    text = stringResource(
                                        id = R.string.last_name
                                    )
                                )
                            }
                        )
                        val context = LocalContext.current
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                if (
                                    firstName.isNotBlank() && lastName.isNotBlank()
                                )
                                    fullName = "$firstName $lastName"
                                else {
                                    fullName = ""
                                    val toast = Toast.makeText(
                                        context,
                                        enterNameErrorMessage,
                                        Toast.LENGTH_LONG
                                    )
                                    toast.setGravity(Gravity.CENTER, 0, 0)
                                    toast.show()
                                }
                            }

                        ){

                        }

                }


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WhoTheme {
        Greeting("Android")
    }
}