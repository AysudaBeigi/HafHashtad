package com.example.hafhashtad.presentation

import com.example.hafhashtad.base.*
import com.example.hafhashtad.domain.GetProductListUseCase
import com.example.hafhashtad.domain.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val getProductListUseCase: GetProductListUseCase,
    coroutineDispatcherProvider: CoroutineDispatcherProvider
) : BaseViewModel(
    coroutineContexts = coroutineDispatcherProvider,
) {
    private val _state = MutableStateFlow(State())

    init {
        getProductListUseCase()
    }

    data class State(
        val loadableProductList: LoadableData<List<Product>> = NotLoaded
    )

    private fun getProductListUseCase() {

        launch {
            onBg {
                _state.update {
                    it.copy(loadableProductList = Loading)
                }
                runCatching {
                    getProductListUseCase.execute()
                }.onSuccess { productList ->
                    _state.update {
                        it.copy(loadableProductList = Loaded(data = productList.groupBy { it.category }))
                    }
                }.onFailure { throwable ->
                    _state.update {
                        it.copy(loadableProductList = Failed(throwble = throwable))
                    }
                }
            }
        }
    }
}