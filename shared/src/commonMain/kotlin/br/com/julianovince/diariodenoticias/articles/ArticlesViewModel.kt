package br.com.julianovince.diariodenoticias.articles

import br.com.julianovince.diariodenoticias.BaseViewModel
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

    private fun getArticles() {
        scope.launch {

            val fetchedArticles = useCase.getArticles()

            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }

}