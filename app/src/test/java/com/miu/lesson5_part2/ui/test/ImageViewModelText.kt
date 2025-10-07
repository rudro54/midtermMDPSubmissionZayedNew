//package com.miu.lesson5_part2.ui.test
//
//import com.miu.lesson5_part2.data.FakeRepository
//import com.miu.lesson5_part2.ui.AlphabetViewModel
//import org.junit.Before
//import org.junit.Test
//
//class ImageViewModelText {
//    // Initialize later
//    private lateinit var alphabetviewModel: AlphabetViewModel
//
//    @Before
//    fun setup() {
//        alphabetviewModel = AlphabetViewModel(FakeRepository())
//    }
//
//    @Test
//    fun testInitialUIState() {
//        val uiState = alphabetviewModel.alphabetUIState.value
//        assert(uiState.alphabet == 'A') //true
//        assert(uiState.word == "Apple") //true
//        assert(!uiState.isCompleted) //is it not completed? =? true
//    }
//
//    @Test
//    fun testAlphabetUIStateAfterNextAlphabet() {
//        alphabetviewModel.nextAlphabet()
//        val uiState = alphabetviewModel.alphabetUIState.value
//        assert(uiState.alphabet == 'B') //true
//        assert(uiState.word == "Bravo") //true
//        assert(!uiState.isCompleted)
//    }
//
//    @Test
//    fun testAlphabetUIStateAfterNextAlphabetCompleted() {
//        repeat(2) {
//            alphabetviewModel.nextAlphabet()
//        }
//        val uiState = alphabetviewModel.alphabetUIState.value
//        assert(uiState.alphabet == 'C') //true
//        assert(uiState.word == "Charlie") //true
//        assert(uiState.isCompleted)
//    }
//}


package com.miu.lesson5_part2.ui

import com.miu.lesson5_part2.data.FakeRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Unit tests for the ImageViewModel.
 */
class ImageViewModelTest {

    // The ViewModel instance we are going to test
    private lateinit var viewModel: ImageViewModel

    // This function runs before each test, setting up a fresh environment
    @Before
    fun setup() {
        // We initialize the ViewModel with our predictable FakeRepository
        viewModel = ImageViewModel(FakeRepository())
    }

    /**
     * Test case to verify that the ViewModel's initial state
     * correctly shows the very first image from the repository.
     */
    @Test
    fun imageViewModel_InitialState_IsFirstImage() {
        // Get the current UI state from the ViewModel
        val uiState = viewModel.uiState.value

        // Define what we expect the title of the first image to be
        val expectedTitle = "Test Image 1"

        // Assert that the actual title in the UI state matches our expectation
        assertEquals(expectedTitle, uiState.title)
    }

    /**
     * Test case to verify that calling nextImage() once
     * correctly advances the state to the second image.
     */
    @Test
    fun imageViewModel_NextImage_AdvancesToSecondImage() {
        // Action: Call the function to advance to the next image
        viewModel.nextImage()

        // Get the new UI state after the action
        val uiState = viewModel.uiState.value

        // Define what we expect the title of the second image to be
        val expectedTitle = "Test Image 2"

        // Assert that the state has been updated correctly
        assertEquals(expectedTitle, uiState.title)
    }

    /**
     * Test case to verify the "wrap-around" logic.
     * When on the last image, calling nextImage() should loop back to the first one.
     */
    @Test
    fun imageViewModel_NextImage_WrapsAroundToFirstImage() {
        // Given: We are on the last image. Our fake repository has 3 images.
        viewModel.nextImage() // Advances to "Test Image 2"
        viewModel.nextImage() // Advances to "Test Image 3" (the last one)

        // Action: Call nextImage() one more time
        viewModel.nextImage()

        // Verification: The state should now be the first image again.
        val uiState = viewModel.uiState.value
        val expectedTitle = "Test Image 1" // The title of the very first image

        // Assert that the wrap-around was successful
        assertEquals(expectedTitle, uiState.title)
    }
}
