package app.dito.galleryapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun GalleryAppMain(modifier: Modifier = Modifier) {
    var imageId by remember {
        mutableIntStateOf(1)
    }

    when (imageId) {
        1 -> Column(
            modifier.wrapContentSize(),
        ) {
            /*  Image(
                  painter = painterResource(id = R.drawable),
                  contentDescription = null
              )*/
            Row {

            }
        }

        2 -> Column(
            modifier.wrapContentSize()
        ) {
            Row {

            }
        }

        3 -> Column {

        }
    }
}