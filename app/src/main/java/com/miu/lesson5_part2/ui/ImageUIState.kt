//package com.miu.lesson5_part2.ui
//
//data class AlphabetUIState(
//    val alphabet: Char,
//    val word: String,
//    val isCompleted: Boolean = false,
////    val isLoading: Boolean = false,
////    val isError: String? = null
//)


package com.miu.lesson5_part2.ui

import androidx.annotation.DrawableRes

data class ImageUiState(
    @DrawableRes val imageResId: Int, // Use this to hold the drawable resource ID for the image
    val title: String // Use this to hold the title of the image
)
