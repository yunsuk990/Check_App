package com.example.presentation.view

import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.domain.utils.ErrorType
import com.example.domain.utils.ScreenState
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentManNameBinding
import com.example.presentation.viewModel.MainViewModel

class ManNameFragment : BaseFragment<FragmentManNameBinding>(R.layout.fragment_man_name) {
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
        observeViewModel()
    }

    fun nextBtnClick(view: View){
        binding.progressBar.visibility = View.VISIBLE
        mainViewModel.checkLoveCalculator(
            "5146|eBy8sUpI1ABuMhRXIrS0l20Av3CvukzhMnUiCkmd",
            binding.editTxt.text.toString(),
            mainViewModel.womanNameResult
        )
    }

    private fun observeViewModel(){
        mainViewModel.apiCallEvent.observe(this){
            binding.progressBar.visibility = View.INVISIBLE
            when(it){
                ScreenState.LOADING -> this.findNavController().navigate(R.id.action_manNameFragment_to_resultFragment)
                ScreenState.ERROR -> toastErrorMsg()
                else -> shortShowToast("알수없는 오류가 발생했습니다")
            }
        }
    }

    private fun toastErrorMsg(){
        when(mainViewModel.apiErrorType){
            ErrorType.NETWORK -> longShowToast("네트워크 오류가 발생했습니다")
            ErrorType.SESSION_EXPIRED -> longShowToast("세션이 만료되었습니다")
            ErrorType.TIMEOUT -> longShowToast("호출 시간이 초과되었습니다")
            ErrorType.UNKNOWN -> longShowToast("알 수 없는 오류가 발생했습니다")
        }
    }


}