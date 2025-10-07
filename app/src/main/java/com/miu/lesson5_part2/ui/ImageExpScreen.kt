//package com.miu.lesson5_part2.ui
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Button
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.miu.lesson5_part2.data.AlphabetRepository
//import com.miu.lesson5_part2.data.AlphabetRepositoryImp
//import com.miu.lesson5_part2.ui.theme.Lesson5_Part2Theme
//
//@Composable
//fun AlphabetExpScreen(modifier: Modifier = Modifier) {
//    Scaffold { innerPadding ->
//        Column(
//            modifier.padding(innerPadding)
//        ) {
//            //Get view model instance
////            val alphabetViewModel: AlphabetViewModel = viewModel {
////                AlphabetViewModel(AlphabetRepositoryImp())
////            }
//            val alphabetViewModel: AlphabetViewModel = hiltViewModel()
//            val alphabetUIState = alphabetViewModel.alphabetUIState.collectAsState()
//
//            Text(text = "${alphabetUIState.value.alphabet} : ${alphabetUIState.value.word}")
//            Button(
//                onClick = {
//                    alphabetViewModel.nextAlphabet()
//                },
//            ) {
//                Text(text = "Next")
//            }
//
//            when {
//                alphabetUIState.value.isCompleted -> {
//                    Text(text="It's completed!")
//                }
//            }
//        }
//    }
//}
//
//@Preview(
//    showSystemUi = true
//)
//@Composable
//private fun AlphabetExpScreenPreview() {
//    Lesson5_Part2Theme {
//        AlphabetExpScreen()
//    }
//}


package com.miu.lesson5_part2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.miu.lesson5_part2.ui.theme.Lesson5_Part2Theme

@Composable
fun ImageExplorerScreen(modifier: Modifier = Modifier) {
    // Get the ViewModel instance using Hilt
    val viewModel: ImageViewModel = hiltViewModel()
    // Collect the UI state from the ViewModel
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(modifier = modifier) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp), // Add some padding around the content
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp) // Space between elements
        ) {
            // 1. An Image
            Image(
                painter = painterResource(id = uiState.imageResId),
                // 4. Content description for accessibility
                contentDescription = uiState.title,
                // 3. Fill width, keep aspect ratio, and crop
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f), // A reasonable aspect ratio
                contentScale = ContentScale.Crop // Cropped fit
            )

            // 2. A Text title below it
            Text(
                text = uiState.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            // 3. A Button to advance to the next image
            Button(
                onClick = { viewModel.nextImage() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ImageExplorerScreenPreview() {
    Lesson5_Part2Theme {
        // You'll need a way to preview this, as it now depends on a ViewModel.
        // For a simple preview, you might need a fake ViewModel or pass state directly.
        // For now, this will just show the basic layout.
        ImageExplorerScreen()
    }
}
