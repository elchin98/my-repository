package com.example.busschedule.database.schedule

import androidx.room.Dao
import androidx.room.Query


@Dao
interface ScheduleDao {

    @Query("select * from  schedule Order By arrival_time asc")
    fun getAll() : List<Schedule>


    @Query("select * from schedule where stop_name= :stopName Order by  arrival_time asc")
    fun getByStopName(stopName : String) : List<Schedule>

}