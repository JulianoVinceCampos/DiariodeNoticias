package br.com.julianovince.diariodenoticias

import br.com.julianovince.diariodenoticias.articles.ArticleRaw
import br.com.julianovince.diariodenoticias.articles.ArticlesDataSource
import br.com.julianovince.diariodenoticias.articles.ArticlesService

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticlesService
) {

    suspend fun getArticles(): List<ArticleRaw> {
        val articlesDb = dataSource.getAllArticles()

        if(articlesDb.isEmpty()) {
            val fetchedArticles = service.fetchArticles()
            dataSource.insertArticles(fetchedArticles)
            return fetchedArticles
        }

        return articlesDb
    }
}