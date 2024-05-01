package com.karolyguth.tracker_domain.use_case

import com.karolyguth.tracker_domain.model.TrackedFood
import com.karolyguth.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetFoodsForDate(private val repository: TrackerRepository) {

    operator fun invoke(
        date: LocalDate
    ): Flow<List<TrackedFood>>{
        return repository.getFoodsForDate(date)
    }
}