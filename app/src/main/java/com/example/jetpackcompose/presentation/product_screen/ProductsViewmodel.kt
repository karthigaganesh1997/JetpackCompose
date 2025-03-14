package com.example.jetpackcompose.presentation.product_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.domain.repositoryDomain.ProductRepositoryDomain
import com.example.jetpackcompose.util.Event
import com.example.jetpackcompose.util.EventBus.sendEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewmodel @Inject constructor(private val productRepository: ProductRepositoryDomain ): ViewModel() {

    private val _state = MutableStateFlow(ProductViewState())
    val state = _state.asStateFlow()

    init {
        getProduct()
    }

    fun getProduct(){

        viewModelScope.launch {

            _state.update {
                it.copy(isLoading = true)
            }

            productRepository.getProducts()
                .onRight {

                    product ->
                    _state.update {
                        it.copy(products = product)
                    }
                }.onLeft {
                    error ->
                    _state.update {
                        it.copy(error = error.error.message)
                    }

                    sendEvent(Event.Toast(error.error.message))

                }


            _state.update {
                it.copy(isLoading = false)
            }

        }

    }
}