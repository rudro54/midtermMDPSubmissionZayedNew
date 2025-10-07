//


// In a new file: ImageViewModelTest.kt
import com.miu.lesson5_part2.data.FakeRepository
import com.miu.lesson5_part2.ui.ImageViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ImageViewModelTest {

    private lateinit var viewModel: ImageViewModel
    private lateinit var repository: FakeRepository

    @Before
    fun setup() {
        repository = FakeRepository()
        viewModel = ImageViewModel(repository)
    }

    @Test
    fun `initial state is the first image`() {
        val expectedTitle = "Test Image 1"
        val actualTitle = viewModel.uiState.value.title
        assertEquals(expectedTitle, actualTitle)
    }

    @Test
    fun `nextImage advances to the second image`() {
        // Action
        viewModel.nextImage()

        // Verification
        val expectedTitle = "Test Image 2"
        val actualTitle = viewModel.uiState.value.title
        assertEquals(expectedTitle, actualTitle)
    }

    @Test
    fun `nextImage wraps around from last to first image`() {
        // Given the UI is on the last image
        viewModel.nextImage() // now on image 2
        viewModel.nextImage() // now on image 3 (last one)

        // Action: press next again
        viewModel.nextImage()

        // Verification: should wrap around to image 1
        val expectedTitle = "Test Image 1"
        val actualTitle = viewModel.uiState.value.title
        assertEquals(expectedTitle, actualTitle)
    }
}
