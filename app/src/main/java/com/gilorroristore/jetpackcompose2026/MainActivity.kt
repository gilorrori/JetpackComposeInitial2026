package com.gilorroristore.jetpackcompose2026

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gilorroristore.jetpackcompose2026.advance.InteractionSourceExample
import com.gilorroristore.jetpackcompose2026.advance.MyDerivedState
import com.gilorroristore.jetpackcompose2026.advance.MyLaunchedEffect
import com.gilorroristore.jetpackcompose2026.components.MyAdvanceList
import com.gilorroristore.jetpackcompose2026.components.MyBasicList
import com.gilorroristore.jetpackcompose2026.components.MyCustomDialog
import com.gilorroristore.jetpackcompose2026.components.MyDivider
import com.gilorroristore.jetpackcompose2026.components.MyFAB
import com.gilorroristore.jetpackcompose2026.components.MyFirstNavigationBar
import com.gilorroristore.jetpackcompose2026.components.MyGridList
import com.gilorroristore.jetpackcompose2026.components.MyModalDrawer
import com.gilorroristore.jetpackcompose2026.components.MyTopAppBar
import com.gilorroristore.jetpackcompose2026.components.ScrollList
import com.gilorroristore.jetpackcompose2026.components.navigation.NavigationWrapper
import com.gilorroristore.jetpackcompose2026.model.PokemonCombat
import com.gilorroristore.jetpackcompose2026.ui.theme.JetpackCompose2026Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackCompose2026Theme {

                val snackBarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

                var showDialog: Boolean by remember { mutableStateOf(true) }

                /*MyModalDrawer(drawerState = drawerState) {
                   Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = { MyTopAppBar() { scope.launch { drawerState.open() } } },
                        snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
                        floatingActionButton = { MyFAB() { showDialog = true } },
                        floatingActionButtonPosition = FabPosition.End,
                        bottomBar = { MyFirstNavigationBar() }
                    ) { innerPadding ->
                        Column(
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                           /* Text(
                                text = "Es mi screen",
                                modifier = Modifier.clickable {
                                    scope.launch {
                                        val result = snackBarHostState.showSnackbar(
                                            message = "Ejemplo",
                                            actionLabel = "Deshacer"
                                        )

                                        if (result == SnackbarResult.ActionPerformed) {
                                            //Pulso deshacer
                                        } else {
                                            //No pulso nada
                                        }
                                    }
                                }
                            )*/
                            MyDivider()

                            /*
                            val pokemonCombat =
                                PokemonCombat(pokemonA = "Pikachu", pokemonB = "Gengar")

                            MyCustomDialog(
                                modifier = Modifier.padding(innerPadding),
                                pokemonCombat = pokemonCombat,
                                showDialog = showDialog,
                                onStartCombat = {
                                    // Ejecutar funcion
                                    showDialog = false
                                },
                                onDismissDialog = {
                                    showDialog = false
                                }
                            )*/
                        }
                    }
                }*/

                NavigationWrapper()

            }
        }
    }
}
