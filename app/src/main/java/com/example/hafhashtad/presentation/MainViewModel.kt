package com.example.hafhashtad.presentation

import androidx.lifecycle.ViewModel
import com.example.hafhashtad.base.BaseViewModel
import com.example.hafhashtad.base.CoroutineDispatcherProvider
import com.example.hafhashtad.domain.GetProductListUseCase
import com.example.hafhashtad.domain.Product
import kotlinx.coroutines.launch

class MainViewModel(
    private val getProductListUseCase: GetProductListUseCase,
    coroutineDispatcherProvider: CoroutineDispatcherProvider
) : BaseViewModel(
    coroutineContexts = coroutineDispatcherProvider,
) {
    init {
        getProductListUseCase()
    }

    data class State(
        val productList:List<Product>
    )

    private fun getProductListUseCase() {
      launch {
          onBg {
              runCatching {
                  getProductListUseCase.execute()
              }.onSuccess {

              }.onFailure {

              }
          }
      }
    }
}