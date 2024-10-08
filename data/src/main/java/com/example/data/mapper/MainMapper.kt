package com.example.data.mapper

import com.example.data.remote.model.DataLoveResponse
import com.example.data.remote.model.DataScore
import com.example.domain.model.DomainDataScore
import com.example.domain.model.DomainLoveResponse

object MainMapper {

    fun loveMapper(
        dataResponse: DataLoveResponse?
    ): DomainLoveResponse?{
        return if(dataResponse != null){
            DomainLoveResponse(
                fname = dataResponse.fname,
                percentage = dataResponse.percentage,
                result = dataResponse.result,
                sname = dataResponse.sname
            )
        }else dataResponse
    }

    fun scoreMapper(
        domainResponse: DomainDataScore
    ): DataScore {
        return DataScore(
            man = domainResponse.man,
            woman = domainResponse.woman,
            percentage = domainResponse.percentage,
            date = domainResponse.date
        )
    }
}