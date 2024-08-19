package com.example.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DomainDataScore
import com.example.domain.model.DomainLoveResponse
import com.example.domain.usecase.CheckLoveCalculatorUseCase
import com.example.domain.usecase.GetScoreUseCase
import com.example.domain.usecase.GetStatisticsUseCase
import com.example.domain.usecase.SetScoreUseCase
import com.example.domain.usecase.SetStatisticsUseCase
import com.example.domain.utils.ErrorType
import com.example.domain.utils.RemoteErrorEmitter
import com.example.domain.utils.ScreenState
import com.example.presentation.widget.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class MainViewModel @Inject constructor(
    private val checkLoveCalculatorUseCase: CheckLoveCalculatorUseCase,
    private val setStatisticsUseCase: SetStatisticsUseCase,
    private val getStatisticsUseCase: GetStatisticsUseCase,
    private val setScoreUseCase: SetScoreUseCase,
    private val getScoreUseCase: GetScoreUseCase
): ViewModel(), RemoteErrorEmitter {


    val apiCallEvent: LiveData<ScreenState> get() = _apiCallEvent
    private var _apiCallEvent = SingleLiveEvent<ScreenState>()

    val getStatisticsEvent: LiveData<Int> get() = _getStatisticsEvent
    private var _getStatisticsEvent = SingleLiveEvent<Int>()

    val getScoreEvent: LiveData<Any> get() = _getScoreEvent
    private var _getScoreEvent = SingleLiveEvent<Any>()


    var apiCallResult = DomainLoveResponse("","", 0f,"")
    var apiErrorType = ErrorType.UNKNOWN
    var apiErrorMessage = "none"
    var manNameResult = "man"
    var womanNameResult = "woman"
    var scoreList = arrayListOf<DomainDataScore>()

    fun checkLoveCalculator(key: String, mName: String, wName: String) {
        Log.d("checkLoveCalculator", "key: $key -- mName: $mName -- wName: $wName")
        viewModelScope.launch {
            checkLoveCalculatorUseCase.execute(this@MainViewModel, key, mName, wName)
                .let { response ->
                    Log.d("network", response.toString())
                    if (response != null) {
                        apiCallResult = response
                        _apiCallEvent.postValue(ScreenState.LOADING)
                    } else {
                        _apiCallEvent.postValue(ScreenState.ERROR)
                    }
                }
        }
    }

    fun setStatistics(plusValue: Int) = setStatisticsUseCase.execute(plusValue)

    fun getStatistics() = getStatisticsUseCase.execute()

    fun getStatisticsDisplay() = getStatisticsUseCase.execute()
        .addOnSuccessListener {
            _getStatisticsEvent.postValue(it.value.toString().toInt())
        }

    fun getScore() = viewModelScope.launch {
        getScoreUseCase.execute()
            .addOnSuccessListener { snapshot ->
                scoreList.clear()
                for(item in snapshot.documents){
                    item.toObject(DomainDataScore::class.java).let {
                        scoreList.add(it!!)
                    }
                }
                Log.d("getScore", scoreList.toString())
                _getScoreEvent.call()
            }
    }

    fun setScore(man: String, woman: String, percent: Float, date: String) = viewModelScope.launch {
        setScoreUseCase.execute(DomainDataScore(man,woman,percent,date))
    }
    override fun onError(msg: String) {
        apiErrorMessage = msg
    }

    override fun onError(errorType: ErrorType) {
        apiErrorType = errorType
    }


}