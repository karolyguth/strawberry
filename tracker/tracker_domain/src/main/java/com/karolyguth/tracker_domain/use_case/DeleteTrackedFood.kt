package com.karolyguth.tracker_domain.use_case

import com.karolyguth.tracker_domain.model.Dish
import com.karolyguth.tracker_domain.repository.TrackerRepository

class DeleteTrackedFood(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(dish: Dish) {
        repository.deleteTrackedFood(dish)
    }
}