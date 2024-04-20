package br.com.julianovince.diariodenoticias.articles

import br.com.julianovince.diariodenoticias.db.Article
import br.com.julianovince.diariodenoticias.db.DiariodeNoticiasDatabase

class ArticlesDataSource(
    private val database: DiariodeNoticiasDatabase
) {

    fun getAllArticles(): List<ArticleRaw> = database.diariodeNoticiasDatabaseQueries
        .selectAllArticles(::mapToArticleRaw)
        .executeAsList()

    fun insertArticles(articles: List<ArticleRaw>) {
        database.diariodeNoticiasDatabaseQueries.transaction {
            articles.forEach { articleRaw -> insertArticle(articleRaw) }
        }
    }



    private fun insertArticle(articleRaw: ArticleRaw){
        database.diariodeNoticiasDatabaseQueries.insertArticle(
            articleRaw.title,
            articleRaw.description,
            articleRaw.date,
            articleRaw.imageUrl
        )
    }

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        url: String?
    ): ArticleRaw =
        ArticleRaw(
            title,
            desc,
            date,
            url
        )

}