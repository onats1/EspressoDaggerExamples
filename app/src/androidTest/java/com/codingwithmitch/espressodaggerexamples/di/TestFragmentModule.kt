package com.codingwithmitch.espressodaggerexamples.di

import androidx.fragment.app.FragmentFactory
import com.codingwithmitch.espressodaggerexamples.fragments.FakeMainFragmentFactory
import com.codingwithmitch.espressodaggerexamples.util.FakeGlideRequestManager
import com.codingwithmitch.espressodaggerexamples.viewModels.FakeMainViewModelFactory
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Singleton

@Module
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
object TestFragmentModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideMainFragmentFactory(
        viewModelFactory: FakeMainViewModelFactory,
        requestManager: FakeGlideRequestManager
    ): FragmentFactory {
        return FakeMainFragmentFactory(viewModelFactory, requestManager)
    }
}