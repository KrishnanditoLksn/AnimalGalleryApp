package app.dito.galleryapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ImageDatas(
    @DrawableRes var image: Int,
    @StringRes var animalName: Int,
    @StringRes var animalScientificName: Int
)