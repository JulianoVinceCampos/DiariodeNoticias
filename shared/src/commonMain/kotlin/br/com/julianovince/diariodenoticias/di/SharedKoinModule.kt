package br.com.julianovince.diariodenoticias.di

import articlesModule

val sharedKoinModule = listOf(
    articlesModule,
    networkModule
)