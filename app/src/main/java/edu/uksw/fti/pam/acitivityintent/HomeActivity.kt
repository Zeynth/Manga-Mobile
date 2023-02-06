package edu.uksw.fti.pam.acitivityintent

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import edu.uksw.fti.pam.acitivityintent.ui.theme.PAMAcitivityIntentTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
class HomeActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAMAcitivityIntentTheme {
                val painter = painterResource(id = R.drawable.onepiecebanner)
                val description = " "
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                ) {
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize(),
                        scaffoldState = scaffoldState,
                        topBar = {
                            ViewPagerSlider(
                                onNavigationIconClick = {
                                    scope.launch {
                                        scaffoldState.drawerState.open()
                                    }
                                }
                            )
                        },
                        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                        drawerContent = {
                            DrawerHeader()
                            DrawerBody(
                                items = listOf(
                                    MenuItem(
                                        id = "home",
                                        title = "Home",
                                        contentDescription = "Go to home screen",
                                        icon = Icons.Default.Home
                                    ),
                                    MenuItem(
                                        id = "settings",
                                        title = "Settings",
                                        contentDescription = "Go to settings screen",
                                        icon = Icons.Default.Settings
                                    ),
                                    MenuItem(
                                        id = "help",
                                        title = "Help",
                                        contentDescription = "Get help",
                                        icon = Icons.Default.Info
                                    ),
                                ),
                                onItemClick = {
                                    println("Clicked on ${it.title}")
                                }
                            )
                        }
                    ) {

                    }
                }
            }

        }
    }
}

@Composable
fun Section(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 350.dp)
            .padding(start = 20.dp)
            .padding(end = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
            Text(
                text = "Latest News",
                color = Color.White,
                fontSize = 24.sp
            )
            Text(
                modifier = Modifier.padding(bottom = 15.dp),
                text = "One Piece has proven several things with the Wano saga, and one of the most important has to do with its animation. Despite being an annual series, the team at Toei Animation put its all into One Piece's latest arc.",
                color = Color.White,
                fontSize = 14.sp,
            )
            Text(
                text = "Latest Update",
                color = Color.White,
                fontSize = 24.sp
            )
            Text(
                modifier = Modifier.padding(top = 230.dp),
                text = "Most Popular",
                color = Color.White,
                fontSize = 24.sp
            )
    }
}