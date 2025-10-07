//package com.miu.lesson5_part2.data
//
//class AlphabetRepositoryImp(
//    private val alphabetData: List<Pair<Char, String>> = AlphabetData.alphabetData
//): AlphabetRepository {
//    override fun getAlphabetData(): List<Pair<Char, String>> = alphabetData
//
//    override fun getNextAlphabet(currentAlphabet: Pair<Char, String>): Pair<Char, String> {
//        val alphabetData = getAlphabetData()
//        val currentIndex = alphabetData.indexOf(currentAlphabet)
//        if (currentIndex < getAlphabetData().size - 1) {
//            return alphabetData[currentIndex + 1]
//        } else {
//            return alphabetData.first()
//        }
//    }
//}

package com.miu.lesson5_part2.data

import com.miu.lesson5_part2.ui.ImageUiState
import javax.inject.Inject

/**
 * Implementation of ImageRepository that retrieves data from a local data source.
 * The @Inject annotation on the constructor tells Hilt how to create an instance of this class.
 */
class ImageRepositoryImp @Inject constructor() : ImageRepository {

    /**
     * Returns the list of images from the local ImageData source.
     */
    override fun getImages(): List<ImageUiState> {
        return ImageData.data
    }
}
