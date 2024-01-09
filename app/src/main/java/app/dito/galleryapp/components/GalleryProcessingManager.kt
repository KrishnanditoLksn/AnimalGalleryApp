package app.dito.galleryapp.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import app.dito.galleryapp.R

@Composable
fun GalleryAppMain(modifier: Modifier = Modifier) {
    var imageId by remember {
        mutableIntStateOf(1)
    }

    Column {
        when (imageId) {
            1 -> GallerySwitcher(
                image = R.drawable.dice_1
            )

            2 -> GallerySwitcher(
                image = R.drawable.dice_1
            )

            3 -> GallerySwitcher(
                image = R.drawable.dice_1
            )
        }
        Spacer(modifier.height(20.dp))
        Row {
            Button(onClick = {
                imageId++
            }) {

            }

            Spacer(modifier.height(20.dp))
            Button(onClick = {
                imageId--
            }) {

            }
        }
    }
}

@Composable
fun GallerySwitcher(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    Column {
        Image(
            modifier = modifier.border(
                BorderStroke(4.dp, Color.Black)
            ),
            painter = painterResource(image),
            contentDescription = null,
        )

    }
}
