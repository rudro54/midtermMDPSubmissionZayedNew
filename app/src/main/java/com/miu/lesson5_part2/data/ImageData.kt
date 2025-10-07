//package com.miu.lesson5_part2.data
//
//object AlphabetData {
//    val alphabetData = listOf<Pair<Char, String>>(
//        'A' to "Apple",
//        'B' to "Ball",
//        'C' to "Cat",
//        'D' to "Dog",
//        'E' to "Elephant",
//        'F' to "Fish",
//        'G' to "Giraffe",
//        'H' to "Horse",
//        'I' to "Insect",
//        'J' to "Jellyfish",
//        'K' to "Kangaroo",
//        'L' to "Lion",
//        'M' to "Monkey",
//        'N' to "Nest",
//        'O' to "Owl",
//        'P' to "Penguin",
//        'Q' to "Queen",
//        'R' to "Rabbit",
//        'S' to "Snake",
//        'T' to "Tiger",
//        'U' to "Umbrella",
//        'V' to "Vehicle",
//        'W' to "Whale",
//        'X' to "X-ray",
//        'Y' to "Yellow",
//        'Z' to "Zebra"
//    )
//}


package com.miu.lesson5_part2.data
import com.miu.lesson5_part2.R
//import com.miu.lesson5_part2.R // Import your project's R file
import com.miu.lesson5_part2.ui.ImageUiState

object ImageData {
    // A list of ImageUiState objects containing the drawable resource ID and title for each image.
    val data = listOf(
        ImageUiState(R.drawable.rainbow, "Rainbow"), // Replace 'image1' with your actual file name
        ImageUiState(R.drawable.friends, "Friends"),    // Replace 'image2' etc. with your file names
        ImageUiState(R.drawable.graduation,  "Graduation"),
        ImageUiState(R.drawable.miu_campus, "MIU Campus"),
        ImageUiState(R.drawable.faculty_student, "Faculty Student"),
        ImageUiState(R.drawable.compro_professionals, "Compro Professionals"),
        ImageUiState(R.drawable.compro_admission_team, "Compro Admission Team"),
        ImageUiState(R.drawable.sustainable_living_center, "Sustainable Living Center"),
        ImageUiState(R.drawable.miu_snow_fall, "MIU Snow Fall"),

        // Add as many images as you have in your drawable folder
    )
}
