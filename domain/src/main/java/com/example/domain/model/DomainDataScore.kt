package com.example.domain.model

data class DomainDataScore(
    val man: String,
    val woman: String,
    val percentage: Float,
    val date: String
){
    constructor(): this("오류","오류",0f,"오류")
}