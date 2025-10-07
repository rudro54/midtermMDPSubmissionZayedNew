//package com.miu.lesson5_part2.di
//
//import android.util.Log
//import com.miu.lesson5_part2.data.AlphabetRepository
//import com.miu.lesson5_part2.data.AlphabetRepositoryImp
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object RepositoryModule {
//    @Provides
////    @Singleton
//    fun provideAlphabetRepository(): AlphabetRepository {
//        Log.d("RepsitoryModule", "prvideAlphabetRepository")
//        return AlphabetRepositoryImp()
//    }
//}

package com.miu.lesson5_part2.di

// Cleaned-up and corrected imports
import com.miu.lesson5_part2.data.ImageRepository
import com.miu.lesson5_part2.data.ImageRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindImageRepository(
        imageRepositoryImp: ImageRepositoryImp
    ): ImageRepository
}
