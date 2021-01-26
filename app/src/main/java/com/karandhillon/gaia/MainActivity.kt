package com.karandhillon.gaia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.karandhillon.gaia.ui.theme.GaiaTheme
import com.karandhillon.gaia.ui.theme.typography
import androidx.navigation.compose.navigate

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val navController = rememberNavController()
      NavHost(navController = navController, startDestination = "gaia") {
        composable("gaia") { GaiaComposable(navController = navController) }
        composable("poseidon") { PoseidonComposable() }
      }
    }
  }

  @Composable
  fun GaiaComposable(navController: NavHostController) {
    GaiaTheme {
      Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.padding(10.dp)) {
          Image(
            bitmap = imageResource(id = R.drawable.gaia),
            modifier = Modifier
              .preferredHeight(300.dp)
              .fillMaxWidth()
              .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
          )
          Text(
            text = "Gaia",
            style = typography.h6
          )
          Text(
            text = "The ancestral mother of all life",
            style = typography.h6
          )
          Spacer(modifier = Modifier.size(10.dp))
          Text(
            text = """
                The composables covered in this part of the project are:
                • Column
                • Row
                • Text
                • Image
                • Button
              """.trimIndent(),
            style = typography.body2
          )
          Spacer(modifier = Modifier.size(10.dp))
          Button(onClick = {navController.navigate("poseidon") }) {
            Text(text = "navigate to poseidon composable")
          }
        }
      }
    }
  }

  @Composable
  fun PoseidonComposable() {
    GaiaTheme {
      Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.padding(10.dp)) {
          Image(
            bitmap = imageResource(id = R.drawable.poseidon),
            modifier = Modifier
              .preferredHeight(300.dp)
              .fillMaxWidth()
              .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
          )
          Text(
            text = "Poseidon",
            style = typography.h6
          )
          Text(
            text = "The god of sea, earthquakes, storms, and horses",
            style = typography.h6
          )
        }
      }
    }
  }
}