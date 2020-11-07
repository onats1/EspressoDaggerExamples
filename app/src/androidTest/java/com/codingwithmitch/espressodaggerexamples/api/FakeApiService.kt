package com.codingwithmitch.espressodaggerexamples.api

import com.codingwithmitch.espressodaggerexamples.models.BlogPost
import com.codingwithmitch.espressodaggerexamples.models.Category
import com.codingwithmitch.espressodaggerexamples.util.Constants
import com.codingwithmitch.espressodaggerexamples.util.JsonUtil
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeApiService
@Inject
constructor(
    val jsonUtil: JsonUtil
): ApiService{

    var blogPostJsonFileName = Constants.BLOG_POSTS_DATA_FILENAME
    var categoriesDataFileName = Constants.CATEGORIES_DATA_FILENAME
    var networkDelay: Long = 0L


    override suspend fun getBlogPosts(category: String): List<BlogPost> {
        val rawJson = jsonUtil.readJSONFromAsset(blogPostJsonFileName)
        val blogs = Gson().fromJson<List<BlogPost>>(
            rawJson,
            object : TypeToken<List<BlogPost>>(){}.type
        )
        val filteredBlogPosts = blogs.filter { blogPost ->
            blogPost.category == category
        }
        delay(networkDelay)
        return filteredBlogPosts
    }

    override suspend fun getAllBlogPosts(): List<BlogPost> {
        val rawJson = jsonUtil.readJSONFromAsset(blogPostJsonFileName)
        val blogs = Gson().fromJson<List<BlogPost>>(
            rawJson,
            object : TypeToken<List<BlogPost>>(){}.type
        )
        delay(networkDelay)
        return blogs
    }

    override suspend fun getCategories(): List<Category> {
        val rawJson = jsonUtil.readJSONFromAsset(categoriesDataFileName)
        val categories = Gson().fromJson<List<Category>>(
            rawJson,
            object : TypeToken<List<BlogPost>>(){}.type
        )
        delay(networkDelay)
        return categories
    }
}