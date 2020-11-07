package com.codingwithmitch.espressodaggerexamples

import com.codingwithmitch.espressodaggerexamples.api.FakeApiService
import com.codingwithmitch.espressodaggerexamples.di.TestAppComponent
import com.codingwithmitch.espressodaggerexamples.repository.FakeMainRepositoryImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
abstract class BaseMainActivityTest {

    abstract fun injectTest(application: TestBaseApplication)

    fun configureFakeApiService(
        blogsDataSource: String? = null,
        categoryDatasource: String? = null,
        networkDelay: Long? = null,
        application: TestBaseApplication
    ): FakeApiService {
        val apiService = (application.appComponent as TestAppComponent).apiService
        blogsDataSource?.let { apiService.blogPostJsonFileName = it }
        categoryDatasource?.let { apiService.categoriesDataFileName = it }
        networkDelay?.let { apiService.networkDelay = it }
        return apiService
    }

    fun configureFakeRepository(
        fakeApiService: FakeApiService,
        application: TestBaseApplication
    ): FakeMainRepositoryImpl {
        val mainRepository = (application.appComponent as TestAppComponent).mainRepository
        mainRepository.apiService = fakeApiService
        return mainRepository
    }
}