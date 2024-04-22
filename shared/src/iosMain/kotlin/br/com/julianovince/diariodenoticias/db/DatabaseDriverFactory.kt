package br.com.julianovince.diariodenoticias.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

actual class DatabaseDriverFactory {

    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(
            schema = DiariodeNoticiasDatabase.Schema,
            name = "DiariodeNoticias.db"
        )
}