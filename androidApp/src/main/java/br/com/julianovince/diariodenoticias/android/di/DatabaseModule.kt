package br.com.julianovince.diariodenoticias.android.di

import app.cash.sqldelight.db.SqlDriver
import br.com.julianovince.diariodenoticias.db.DatabaseDriverFactory
import br.com.julianovince.diariodenoticias.db.DiariodeNoticiasDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }

    single<DiariodeNoticiasDatabase> { DiariodeNoticiasDatabase(get()) }

}