package br.com.julianovince.diariodenoticias.articles.presentation

import br.com.julianovince.diariodenoticias.articles.application.Article

data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error:String? = null
)
