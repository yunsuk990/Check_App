package com.example.presentation.view

import android.provider.ContactsContract.Data
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentResultBinding
import com.example.presentation.viewModel.MainViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ResultFragment : BaseFragment<FragmentResultBinding>(R.layout.fragment_result) {
    private val mainViewModel by activityViewModels<MainViewModel>()
    override fun init() {
        binding.fragment = this
        initResult()
        saveScore()
    }

    private fun initResult(){
        binding.percentage.text = mainViewModel.apiCallResult.percentage.toString()
        when(mainViewModel.apiCallResult.percentage){
            in 0f..20f -> setLoveMsgTxt("조금 힘들어 보여요")
            in 21f..40f -> setLoveMsgTxt("노력해 보세요")
            in 41f..70f -> setLoveMsgTxt("기대해도 좋겠는데요?")
            in 71f..90f -> setLoveMsgTxt("일단 축하드려요")
            in 91f..99f-> setLoveMsgTxt("와우.. 눈을 의심하고 있어요")
            100f -> {
                saveStatistics()
                setLoveMsgTxt("완벽하네요! 축하드려요")
            }
            else -> setLoveMsgTxt("알 수 없는 힘?")
        }
    }

    private fun saveStatistics(){
        mainViewModel.getStatistics()
            .addOnSuccessListener {
                if(it!=null) mainViewModel.setStatistics(it.value.toString().toInt() + 1)
                    .addOnFailureListener {
                        error()
                    }
            }
            .addOnFailureListener{
                error()
            }
    }

    private fun saveScore() = with(mainViewModel.apiCallResult){
        mainViewModel.setScore(this.fname, this.sname, this.percentage, nowTime())
    }

    private fun nowTime(): String = SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분", Locale("ko","KR")).format(
        Date(System.currentTimeMillis())
    )

    private fun error() = shortShowToast("통계를 저장하는데 오류가 발생했습니다")

    private fun setLoveMsgTxt(msg: String) = binding.loveTxt.setText(msg)

    fun clickBackMainBtn(view: View){
        this.findNavController().navigate(R.id.action_resultFragment_to_mainFragment)
    }
}