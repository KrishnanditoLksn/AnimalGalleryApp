package app.dito.galleryapp.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.dito.galleryapp.R

@Composable
fun GalleryAppMain(modifier: Modifier = Modifier) {

    var imageId by remember {
        mutableIntStateOf(1)
    }

    val imageRes: Int = when (imageId) {
        1 -> gallerySwitcher(
            image = R.drawable.pexels_pixabay_47547,
            animalName = R.string.squirrel,
            animalScientificName = R.string.sciuridae,
        )

        2 -> gallerySwitcher(
            image = R.drawable.pexels_roshan_kamath_1661179,
            animalName = R.string.lovebird,
            animalScientificName = R.string.agarponis
        )

        3 -> gallerySwitcher(
            image = R.drawable.pexels_pixabay_162203,
            animalName = R.string.tiger,
            animalScientificName = R.string.panthera
        )

        else -> {
            R.drawable.pexels_pixabay_162203
        }
    }

    Spacer(modifier.height(20.dp))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = imageRes),
            contentDescription = imageId.toString()
        )
        Spacer(modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                if (imageId == 3) {
                    imageId = 1
                } else {
                    imageId++
                }
            }) {
                Text(
                    text = stringResource(id = R.string.b_prev)
                )
            }
            Spacer(modifier.height(20.dp))

            Button(onClick = {
                if (imageId == 1) {
                    imageId = 3
                } else {
                    imageId--
                }
            }) {
                Text(
                    text = stringResource(id = R.string.b_next)
                )
            }
        }
    }

}

@Composable
fun gallerySwitcher(
    @DrawableRes image: Int,
    @StringRes animalName: Int,
    @StringRes animalScientificName: Int,
    modifier: Modifier = Modifier
): Int {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = modifier.border(
                BorderStroke(4.dp, Color.Black)
            ),
            painter = painterResource(image),
            contentDescription = null,
        )

        Column {
            Text(
                text = stringResource(id = animalName),
                fontSize = 20.sp
            )
            Spacer(modifier.height(10.dp))
            Text(
                text = stringResource(id = animalScientificName),
                fontSize = 20.sp
            )
        }
    }
    return image
}
