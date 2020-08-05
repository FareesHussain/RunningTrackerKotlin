package farees.hussain.runningtracker.repositories

import farees.hussain.runningtracker.database.Run
import farees.hussain.runningtracker.database.RunDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDao: RunDao
) {
    suspend fun insertRun(run: Run) = runDao.insertRun(run)
    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

    fun getAllRunSortedByDate() = runDao.getAllRunsSortedByDate()
    fun getAllRunSortedByDistance() = runDao.getAllRunsSortedByDistance()
    fun getAllRunSortedByTimeInMillis() = runDao.getAllRunsSortedByTimeInMillis()
    fun getAllRunSortedByAvgSpeed() = runDao.getAllRunsSortedByAvgspeed()
    fun getAllRunSortedByAvgCaloriesBurned() = runDao.getAllRunsSortedByDate()

    fun getCompleteAvgSpeed() = runDao.getCompleteAvgSpeed()
    fun getTotalDistance() = runDao.getTotalDistance()
    fun getTotalCaloriesBurned() = runDao.getTotalCaloriesburned()
    fun getTotalTimeInMillis() = runDao.getTotalTimeInMillis()

}