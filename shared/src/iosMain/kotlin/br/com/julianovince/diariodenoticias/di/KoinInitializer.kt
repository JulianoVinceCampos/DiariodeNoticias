package br.com.julianovince.diariodenoticias.di

import br.com.julianovince.diariodenoticias.articles.ArticlesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {

    val modules = sharedKoinModule

    startKoin {
        modules(modules)
    }

    class ArticlesInjector : KoinComponent {
        val articlesViewModel: ArticlesViewModel by inject()
    }

}