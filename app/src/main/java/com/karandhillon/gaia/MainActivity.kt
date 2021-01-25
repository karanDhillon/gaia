package com.karandhillon.gaia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.karandhillon.gaia.ui.theme.GaiaTheme
import com.karandhillon.gaia.ui.theme.typography

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
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
              """.trimIndent(),
              style = typography.body2
            )
          }
        }
      }
    }
  }
}