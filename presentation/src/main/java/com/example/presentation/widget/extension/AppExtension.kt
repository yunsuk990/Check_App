package com.example.presentation.widget.extension

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.showVertical(context: Context){
    this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
}