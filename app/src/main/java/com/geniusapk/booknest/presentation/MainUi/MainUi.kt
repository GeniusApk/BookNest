package com.geniusapk.booknest.presentation.MainUi

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.geniusapk.booknest.R
import com.geniusapk.booknest.presentation.TabScreen.TabScreen
import com.geniusapk.booknest.presentation.nav.Routes
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainUi(navHostController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val urlHandler = LocalUriHandler.current
    val context = LocalContext.current


    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(250.dp)
                        .padding(16.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .align (Alignment.CenterHorizontally )
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_round),
                                contentDescription = "App Logo",
                                modifier = Modifier
                                    .size(100.dp)
                                    .align(Alignment.CenterHorizontally)
                                   // .background(color = Color.White)
                            )
                        }

                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    HorizontalDivider()
                    NavigationDrawerItem(
                        label = { Text("Home") },
                        selected = true,
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Home,
                                contentDescription = "Home"
                            )
                        },
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                        }
                    )
                    HorizontalDivider()
                    NavigationDrawerItem(
                        label = { Text("Versoin 1.0") },
                        selected = false,
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Info,
                                contentDescription = "Versoin 1.0"
                            )
                        },
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            Toast.makeText(context, "Versoin 1.0", Toast.LENGTH_SHORT).show()

                        }
                    )
                    HorizontalDivider()
                    NavigationDrawerItem(
                        label = { Text("Contact Me") },
                        selected = false,
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Email,
                                contentDescription = "Contact Me"
                            )
                        },
                        onClick = { urlHandler.openUri("https://www.linkedin.com/in/mohd-aakib-0546ab272/") }
                    )
                    HorizontalDivider()
                    NavigationDrawerItem(
                        label = { Text("Source Code") },
                        selected = false,
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.githubwhite),
                                contentDescription = "Source Code",
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        onClick = { urlHandler.openUri("https://github.com/GeniusApk/IND_News") }
                    )
                    HorizontalDivider()
                    NavigationDrawerItem(
                        label = { Text("Bug Report") },
                        selected = false,
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.bug),
                                contentDescription = "Source Code",
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        onClick = { urlHandler.openUri("http://github.com/geniusapk") }
                    )
                }
            }
        }
    ) {

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    title = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                "BookNest",
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = { coroutineScope.launch { drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Open Drawer"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { navHostController.navigate(Routes.Bookmarks) }) {
                            Icon(
                                imageVector = Icons.Default.Bookmark,
                                contentDescription = "Show Bookmarks"
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),

            ) {
                TabScreen(navHostController = navHostController)

            }
        }
    }

}