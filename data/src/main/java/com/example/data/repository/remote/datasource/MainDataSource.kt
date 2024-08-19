package com.example.data.repository.remote.datasource

import com.example.data.remote.model.DataLoveResponse
import com.example.data.remote.model.DataScore
import com.example.domain.utils.RemoteErrorEmitter
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.firestore.QuerySnapshot

interface MainDataSource {

    //궁합 API 호출
    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        key: String,
        mName: String,
        wName: String
    ): DataLoveResponse?


    //통계 가져오기
    fun getStatistics(): Task<DataSnapshot>

    //통계 저장하기
    fun setStatistics(plusValue: Int): Task<Void>

    //전적 가져오기
    fun getScore(): Task<QuerySnapshot>

    //전적 저장하기
    fun setScore(score: DataScore): Task<Void>
}