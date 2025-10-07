//package com.miu.lesson5_part2.data
//
//interface AlphabetRepository {
//    fun getAlphabetData(): List<Pair<Char, String>>
//    fun getNextAlphabet(currentAlphabet: Pair<Char, String>): Pair<Char, String>
//}


package com.miu.lesson5_part2.data

import com.miu.lesson5_part2.ui.ImageUiState

/**
 * Interface for the repository that provides image data.
 */
interface ImageRepository {
    /**
     * Retrieves the complete list of images.
     */
    fun getImages(): List<ImageUiState>
}

