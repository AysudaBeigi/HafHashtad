package com.example.hafhashtad.di

import com.example.hafhashtad.data.Api
import org.koin.dsl.module
import retrofit2.Retrofit


val hafHashtadModule = module {

    single<Api> { get<Retrofit>().create(Api::class.java) }

}