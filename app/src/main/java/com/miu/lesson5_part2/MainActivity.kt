//package com.miu.lesson5_part2
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.miu.lesson5_part2.ui.AlphabetExpScreen
//import com.miu.lesson5_part2.ui.theme.Lesson5_Part2Theme
//import dagger.hilt.android.AndroidEntryPoint
//
//@AndroidEntryPoint
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            Lesson5_Part2Theme {
//                AlphabetExpScreen()
//            }
//        }
//    }
//}



package com.miu.lesson5_part2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.miu.lesson5_part2.ui.ImageExplorerScreen // <-- 1. Import the new screen
import com.miu.lesson5_part2.ui.theme.Lesson5_Part2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lesson5_Part2Theme {
                // 2. Call the new ImageExplorerScreen
                ImageExplorerScreen()
            }
        }
    }
}
