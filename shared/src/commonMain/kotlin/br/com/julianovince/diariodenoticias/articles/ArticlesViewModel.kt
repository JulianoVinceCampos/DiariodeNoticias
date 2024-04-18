package br.com.julianovince.diariodenoticias.articles

import br.com.julianovince.diariodenoticias.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel:BaseViewModel() {

   private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))

    val articleState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            delay(1500)

            _articlesState.emit(ArticlesState(error = "Erro não encontrado"))
            delay(1500)

            val fetchedArticles = fetchArticles()

            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }

    suspend fun fetchArticles(): List<Article> = mockArticles

    private val mockArticles = listOf(
        Article(
            "Olá aqui",
            "Minimum supported Android Gradle Plugin version: 7.0",
            "01/10/2024",
            "https://t2.tudocdn.net/701417?w=646&h=284"
        ),
        Article(
            "Primeira noticia",
            "Maximum tested Android Gradle Plugin version: 8.2",
            "30/01/2021",
            "https://t2.tudocdn.net/702231?w=1000&fit=clip"
        ),
        Article(
            "Ultima noticia",
            "The applied Android Gradle Plugin version (8.3.1) is higher",
            "21/03/1989",
            "https://t2.tudocdn.net/702243?w=1000&fit=clip"
        )
    )
}