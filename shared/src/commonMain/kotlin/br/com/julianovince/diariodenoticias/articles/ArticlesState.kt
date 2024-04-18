package br.com.julianovince.diariodenoticias.articles

data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error:String? = null
)
