package com.example.nycschool

import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * @author: tonghann.teng
 * @since: 9/5/2023
 */
interface DispatcherProvider {
    fun main(): CoroutineDispatcher = Dispatchers.Main
    fun io(): CoroutineDispatcher = Dispatchers.IO
}

open class DefaultDispatcherProvider @Inject constructor() : DispatcherProvider
