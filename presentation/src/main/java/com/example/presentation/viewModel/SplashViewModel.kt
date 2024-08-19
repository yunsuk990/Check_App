package com.example.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.CheckAppVersionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val checkAppVersionUseCase: CheckAppVersionUseCase
): ViewModel() {

    fun checkAppVersionUseCase() = checkAppVersionUseCase.execute()

}