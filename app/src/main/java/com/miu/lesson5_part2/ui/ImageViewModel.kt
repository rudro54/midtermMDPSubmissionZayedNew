//package com.miu.lesson5_part2.ui
//
//import androidx.compose.runtime.MutableIntState
//import androidx.compose.runtime.structuralEqualityPolicy
//import androidx.lifecycle.ViewModel
//import com.miu.lesson5_part2.data.AlphabetData
//import com.miu.lesson5_part2.data.AlphabetRepository
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.flow.update
//import javax.inject.Inject
//
//@HiltViewModel
//class AlphabetViewModel @Inject constructor (
//    private val alphabetRepository: AlphabetRepository
//): ViewModel() {
////    private val alphabetData = AlphabetData.alphabetData
//    private val alphabetData = alphabetRepository.getAlphabetData()
//
//    // create MutableStateFlow
//    private val _alphabetUIState = MutableStateFlow(
//        AlphabetUIState(
//            alphabet = alphabetData[0].first,
//            word = alphabetData[0].second
//        )
//    )
//
//    //Expose it as read only state
//    val alphabetUIState = _alphabetUIState.asStateFlow()
//
//    fun nextAlphabet() {
//        val nextAlphabet = alphabetRepository.getNextAlphabet(_alphabetUIState.value.alphabet to _alphabetUIState.value.word)
//        if (nextAlphabet == alphabetData.last()) {
//            _alphabetUIState.update {
//                it.copy(
//                    nextAlphabet.first,
//                    nextAlphabet.second,
//                    isCompleted = true
//                )
//            }
//        } else {
//            _alphabetUIState.update {
//                it.copy(
//                    nextAlphabet.first,
//                    nextAlphabet.second,
//                    isCompleted = false
//                )
//            }
//        }
////        val currentIndex = alphabetData.indexOfFirst { it.first == _alphabetUIState.value.alphabet }
////        val currentIndex = alphabetData.indexOf(_alphabetUIState.value.alphabet to _alphabetUIState.value.word)
////        if (currentIndex < alphabetData.size - 1) {
////            val nextAlphabet = alphabetData[currentIndex + 1]
////            _alphabetUIState.update {
////                it.copy(
////                    alphabet = nextAlphabet.first,
////                    word = nextAlphabet.second
////                )
////            }
////        } else {
////            _alphabetUIState.update {
////                it.copy(
////                    alphabet = alphabetData[0].first,
////                    word = alphabetData[0].second
////                )
////            }
////        }
////
////        if (currentIndex == alphabetData.size - 2) {
////            _alphabetUIState.update {
////                it.copy(
////                    isCompleted = true
////                )
////            }
////        }
//    }
//}

package com.miu.lesson5_part2.ui

import androidx.lifecycle.ViewModel
// import androidx.wear.compose.foundation.size // <-- DELETE THIS LINE
import com.miu.lesson5_part2.data.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(
    private val imageRepository: ImageRepository // Inject the new ImageRepository
) : ViewModel() {

    // Get the list of images from the repository
    private val images = imageRepository.getImages()
    private var currentIndex = 0

    // Create MutableStateFlow with the first image's data
    private val _uiState = MutableStateFlow(
        ImageUiState(
            imageResId = images[currentIndex].imageResId,
            title = images[currentIndex].title
        )
    )

    // Expose it as a read-only state flow
    val uiState = _uiState.asStateFlow()

    /**
     * Advances to the next image in the list.
     * After the last item, it wraps around to the first.
     */
    fun nextImage() {
        // Calculate the index of the next image, wrapping around if necessary
        currentIndex = (currentIndex + 1) % images.size

        // Get the next image data from the list
        val nextImage = images[currentIndex]

        // Update the UI state with the new image and title
        _uiState.update {
            it.copy(
                imageResId = nextImage.imageResId,
                title = nextImage.title
            )
        }
    }
}


