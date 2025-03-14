package com.example.jetpackcompose.data.repository_data

import android.app.Application
import arrow.core.Either
import com.example.jetpackcompose.R
import com.example.jetpackcompose.data.mapper.toNetworkError
import com.example.jetpackcompose.data.remote.ProductApi
import com.example.jetpackcompose.domain.model.NetworkError
import com.example.jetpackcompose.domain.model.Product
import com.example.jetpackcompose.domain.repositoryDomain.ProductRepositoryDomain
import javax.inject.Inject
import javax.inject.Singleton



@Singleton
class ProductRepositoryImplData @Inject constructor(val productApi: ProductApi, val app: Application) : ProductRepositoryDomain {

    init {
        val appName = app.getString(R.string.app_name)
        println("Hello from the repository. The app is $appName")
    }
    override suspend fun getProducts(): Either<NetworkError, List<Product>> {
        return  Either.catch {
            productApi.getProducts()
        }.mapLeft {
            it.toNetworkError()
        }

    }

}