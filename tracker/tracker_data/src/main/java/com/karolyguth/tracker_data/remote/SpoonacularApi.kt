package com.karolyguth.tracker_data.remote

import com.karolyguth.tracker_data.remote.dto.SearchDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SpoonacularApi {

    @GET("food/ingredients/search?query=banana&number=2&sort=calories&sortDirection=desc")
    suspend fun searchFood(
        @Query("query") query: String,
        @Query("number") number: Int,
        @Query("page_size") pageSize: Int
    ): SearchDto

    companion object {
        const val BASE_URL = "https://api.spoonacular.com/"
    }
}