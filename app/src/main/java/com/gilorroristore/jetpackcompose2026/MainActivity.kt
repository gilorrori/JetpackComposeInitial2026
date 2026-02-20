package com.gilorroristore.jetpackcompose2026

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.gilorroristore.jetpackcompose2026.animations.FullAnimateAsState
import com.gilorroristore.jetpackcompose2026.animations.MyAnimateContent
import com.gilorroristore.jetpackcompose2026.animations.MyAnimatedVisibility
import com.gilorroristore.jetpackcompose2026.animations.MyContentSize
import com.gilorroristore.jetpackcompose2026.animations.MyCrossfade
import com.gilorroristore.jetpackcompose2026.animations.MyInfiniteTransition
import com.gilorroristore.jetpackcompose2026.components.navigation.navigation2.NavigationWrapper
import com.gilorroristore.jetpackcompose2026.ui.theme.JetpackCompose2026Theme

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

                //NavigationWrapper()
                //MyAnimatedVisibility()
                MyInfiniteTransition()

            }
        }
    }
}
