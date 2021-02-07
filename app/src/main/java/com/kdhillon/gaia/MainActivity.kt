package com.kdhillon.gaia

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import com.kdhillon.gaia.Screen.*
import com.kdhillon.gaia.ui.theme.GaiaTheme
import com.kdhillon.gaia.ui.theme.typography

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      val navController = rememberNavController()
      val items = listOf(Gaia, Poseidon, Zeus)

      GaiaTheme {
        Scaffold(
          bottomBar = {
            BottomNavigation {
              val navBackStackEntry by navController.currentBackStackEntryAsState()
              val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

              items.forEach { screen ->
                BottomNavigationItem(
                  icon = { Icon(Icons.Filled.Person) },
                  label = { Text(screen.label) },
                  selected = currentRoute == screen.route,
                  onClick = {
                    navController.navigate(screen.route) {
                      popUpTo = navController.graph.startDestination
                      launchSingleTop = true
                    }
                  }
                )
              }
            }
          },
        ) {
          Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            NavHost(
              navController = navController,
              startDestination = "gaia"
            ) {
              composable("gaia") { GaiaComposable() }
              composable("poseidon") { PoseidonComposable() }
              composable("zeus") { ZeusComposable() }
            }
          }
        }
      }
    }
  }

  @Composable
  fun GodComposable(
    godName: String,
    godExcerpt: String,
    @DrawableRes drawableId: Int
  ) {
    Column(
      modifier = Modifier.padding(8.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Image(
        bitmap = imageResource(drawableId),
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .width(250.dp)
          .height(250.dp)
          .clip(RoundedCornerShape(10.dp))
      )
      Spacer(modifier = Modifier.size(10.dp))
      Text(
        text = godName,
        style = typography.h6
      )
      Text(
        text = godExcerpt,
        style = typography.body1
      )
    }
  }

  @Composable
  fun GaiaComposable() = GodComposable(
    godName = "Gaia",
    godExcerpt = "The ancestral mother of all life",
    drawableId = R.drawable.gaia
  )

  @Composable
  fun PoseidonComposable() = GodComposable(
    godName = "Poseidon",
    godExcerpt = "The god of sea, earthquakes, storms, and horses",
    drawableId = R.drawable.poseidon
  )

  @Composable
  fun ZeusComposable() = GodComposable(
    godName = "Zeus",
    godExcerpt = "God of all other gods",
    drawableId = R.drawable.zeus
  )
}