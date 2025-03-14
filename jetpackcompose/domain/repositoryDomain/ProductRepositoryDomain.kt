package com.example.jetpackcompose.domain.repositoryDomain

import arrow.core.Either
import com.example.jetpackcompose.domain.model.NetworkError
import com.example.jetpackcompose.domain.model.Product

interface  ProductRepositoryDomain
{
suspend fun getProducts() : Either<NetworkError, List<Product>>


}