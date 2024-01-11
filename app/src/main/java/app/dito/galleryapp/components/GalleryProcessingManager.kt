package app.dito.galleryapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
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
import app.dito.galleryapp.data.ImageDatas

@Composable
fun GalleryAppMain(modifier: Modifier = Modifier) {

    var imageId by remember {
        mutableIntStateOf(1)
    }

    val imageRes: ImageDatas = when (imageId) {
        1 ->
            ImageDatas(
                image = R.drawable.pexels_pixabay_47547,
                animalName = R.string.squirrel,
                animalScientificName = R.string.sciuridae,
            )

        2 -> ImageDatas(
            image = R.drawable.pexels_roshan_kamath_1661179,
            animalName = R.string.lovebird,
            animalScientificName = R.string.agarponis
        )

        3 -> ImageDatas(
            image = R.drawable.pexels_pixabay_162203,
            animalName = R.string.tiger,
            animalScientificName = R.string.panthera
        )

        else -> {
            throw IllegalStateException("Fragment $imageId is not correct")
        }
    }

    Spacer(modifier.height(20.dp))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.verticalScroll(rememberScrollState())
    )
    {
        Image(
            painter = painterResource(id = imageRes.image),
            contentDescription = imageId.toString(),
            modifier.padding(20.dp)
        )
        Spacer(modifier.height(20.dp))

        Surface(
            color = Color.Gray,
            shadowElevation = 20.dp
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = imageRes.animalName),
                    fontSize = 20.sp
                )
                Spacer(modifier.height(15.dp))

                Text(
                    text = stringResource(id = imageRes.animalScientificName),
                    fontSize = 20.sp
                )
            }
        }
        Spacer(modifier.height(30.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
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