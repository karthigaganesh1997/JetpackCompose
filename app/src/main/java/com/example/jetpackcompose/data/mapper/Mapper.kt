package com.example.jetpackcompose.data.mapper

import coil.network.HttpException
import com.example.jetpackcompose.domain.model.ApiError
import com.example.jetpackcompose.domain.model.NetworkError
import java.io.IOException

fun Throwable.toNetworkError() : NetworkError{
    val error = when(this){
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnKnownError
    }
    return NetworkError(
        error = error,
        t = this
    )
}