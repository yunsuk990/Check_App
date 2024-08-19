package com.example.domain.repository

import com.example.domain.model.DomainDataScore
import com.example.domain.model.DomainLoveResponse
import com.example.domain.utils.RemoteErrorEmitter
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.firestore.QuerySnapshot

interface MainRepository {
    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        key: String,
        mName: String,
        wName: String
    ): DomainLoveResponse?

    //통계 가져오기
    fun getStatistics(): Task<DataSnapshot>

    //통계 저장하기
    fun setStatistics(plusValue: Int): Task<Void>

    //전적 가져오기
    fun getScore(): Task<QuerySnapshot>

    //전적 저장하기
    fun setScore(score: DomainDataScore): Task<Void>

}