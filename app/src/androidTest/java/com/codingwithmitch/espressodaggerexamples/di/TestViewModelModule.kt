package com.codingwithmitch.espressodaggerexamples.di

import androidx.lifecycle.ViewModelProvider
import com.codingwithmitch.espressodaggerexamples.repository.FakeMainRepositoryImpl
import com.codingwithmitch.espressodaggerexamples.viewModels.FakeMainViewModelFactory
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
@Module
object TestViewModelModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideFakeViewModelFactory(
        fakeMainRepositoryImpl: FakeMainRepositoryImpl
    ): ViewModelProvider.Factory {
        return FakeMainViewModelFactory(fakeMainRepositoryImpl)
    }
}