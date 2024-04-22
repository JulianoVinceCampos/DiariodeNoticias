package br.com.julianovince.diariodenoticias.di

import app.cash.sqldelight.db.SqlDriver
import br.com.julianovince.diariodenoticias.db.DatabaseDriverFactory
import br.com.julianovince.diariodenoticias.db.DiariodeNoticiasDatabase
import org.koin.dsl.module

val databaseModule = module{

    single<SqlDriver> { DatabaseDriverFactory().createDriver() }

    single<DiariodeNoticiasDatabase> { DiariodeNoticiasDatabase(get()) }

}