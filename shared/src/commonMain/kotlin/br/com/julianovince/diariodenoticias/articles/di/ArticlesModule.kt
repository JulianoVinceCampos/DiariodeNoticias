import br.com.julianovince.diariodenoticias.articles.data.ArticlesRepository
import br.com.julianovince.diariodenoticias.articles.data.ArticlesDataSource
import br.com.julianovince.diariodenoticias.articles.application.ArticlesUseCase
import br.com.julianovince.diariodenoticias.articles.data.ArticlesService
import br.com.julianovince.diariodenoticias.articles.presentation.ArticlesViewModel
import org.koin.dsl.module


val articlesModule = module {

    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }

}