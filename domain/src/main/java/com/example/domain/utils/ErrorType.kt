package com.example.domain.utils

enum class ErrorType {
    //네트워크 문제
    NETWORK,

    //호출 시간 초과
    TIMEOUT,

    //세션 만료
    SESSION_EXPIRED,

    //알 수 없는 문제
    UNKNOWN
}