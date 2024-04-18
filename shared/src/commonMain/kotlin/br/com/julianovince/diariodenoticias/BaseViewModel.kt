package br.com.julianovince.diariodenoticias

import kotlinx.coroutines.CoroutineScope

expect  open class BaseViewModel() {

    val scope:CoroutineScope

}