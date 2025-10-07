//package com.miu.lesson5_part2.data
//
//class FakeRepository (
//    alphabets: List<Pair<Char, String>> = listOf(
//        'A' to "Apple",
//        'B' to "Bravo",
//        'C' to "Charlie"
//    )
//): AlphabetRepository by AlphabetRepositoryImp(alphabets)



package com.miu.lesson5_part2.data

import com.miu.lesson5_part2.ui.ImageUiState

/**
 * A fake implementation of the ImageRepository for use in unit tests.
 * It provides a fixed, predictable list of images.
 */
class FakeRepository : ImageRepository {

    // A predefined list of ImageUiState objects for testing.
    // Note: The imageResId can be 0 or any integer, as the images won't actually be rendered in a unit test.
    private val fakeImages = listOf(
        ImageUiState(imageResId = 1, title = "Test Image 1"),
        ImageUiState(imageResId = 2, title = "Test Image 2"),
        ImageUiState(imageResId = 3, title = "Test Image 3")
    )

    /**
     * Returns the predefined list of fake images.
     */
    override fun getImages(): List<ImageUiState> {
        return fakeImages
    }
}
