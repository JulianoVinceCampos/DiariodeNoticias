package br.com.julianovince.diariodenoticias.android

import android.app.Application
import br.com.julianovince.diariodenoticias.android.di.databaseModule
import br.com.julianovince.diariodenoticias.android.di.viewModelsModule
import br.com.julianovince.diariodenoticias.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DailyPulseApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModule + viewModelsModule + databaseModule

        startKoin{
            androidContext(this@DailyPulseApp)
            modules(modules)
        }
    }
}