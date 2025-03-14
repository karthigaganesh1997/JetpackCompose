package com.example.jetpackcompose.di

import com.example.jetpackcompose.data.remote.ProductApi
import com.example.jetpackcompose.util.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideProductsApi(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Provides
    @Singleton

    fun provideMobileService(retrofit: Retrofit): ProductApi{
        return retrofit.create(ProductApi::class.java)
    }

//    @Provides
//    @Singleton
//    fun provideMyRepository(api: ProductApi,app : MyApplication):ProductRepository{
//        return ProductRepositoryImpl(api,app)
//    }
}