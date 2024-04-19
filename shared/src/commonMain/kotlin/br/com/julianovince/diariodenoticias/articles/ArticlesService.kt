package br.com.julianovince.diariodenoticias.articles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(
    private val httpClient: HttpClient
) {

    private val country = "br"
    private val category = "business"
    private val apiKey = "e7875a1b7ad543208783424c7a1b6236"

    suspend fun fetchArticles(): List<ArticleRaw> {
        try {
            val response: ArticlesResponse = httpClient.get(
                "https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey"
            ).body()
            return response.articles
        } catch (e: Exception) {
            print("Erro Juliano: $e")
            throw e
        }
    }

}