package br.com.julianovince.diariodenoticias.android.di

import br.com.julianovince.diariodenoticias.articles.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { ArticlesViewModel(get()) }
}