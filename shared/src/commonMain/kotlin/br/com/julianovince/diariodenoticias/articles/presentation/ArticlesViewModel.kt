package br.com.julianovince.diariodenoticias.articles.presentation

import br.com.julianovince.diariodenoticias.BaseViewModel
import br.com.julianovince.diariodenoticias.articles.application.ArticlesUseCase
import br.com.julianovince.diariodenoticias.articles.presentation.ArticlesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val useCase: ArticlesUseCase
):BaseViewModel() {

   private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))

    val articleState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    fun getArticles(forceFetch: Boolean = false) {
        scope.launch {

            _articlesState.emit(ArticlesState(loading = true, articles = _articlesState.value.articles))

            val fetchedArticles = useCase.getArticles(forceFetch)

            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }

}