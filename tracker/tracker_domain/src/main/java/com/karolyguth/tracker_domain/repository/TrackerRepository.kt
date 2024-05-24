package com.karolyguth.tracker_domain.repository

import com.karolyguth.tracker_domain.model.Ingredient
import com.karolyguth.tracker_domain.model.Dish
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface TrackerRepository {
    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<Ingredient>>

    suspend fun insertTrackedFood(food: Dish)
    suspend fun deleteTrackedFood(food: Dish)
    fun getFoodsForDate(localDate: LocalDate): Flow<List<Dish>>
}