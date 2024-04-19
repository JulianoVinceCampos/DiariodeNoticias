import br.com.julianovince.diariodenoticias.articles.ArticlesUseCase
import br.com.julianovince.diariodenoticias.articles.ArticlesService
import br.com.julianovince.diariodenoticias.articles.ArticlesViewModel
import org.koin.dsl.module


val articlesModule = module {

    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }

}