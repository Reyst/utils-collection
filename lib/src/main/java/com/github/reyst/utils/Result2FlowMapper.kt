@file:Suppress("unused")

package com.github.reyst.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

suspend inline fun <T> FlowCollector<T>.collectResult(result: Result<T>) = result.fold(
    onSuccess = { emit(it) },
    onFailure = { throw it },
)

fun <T> flowFromResult(
    coroutineContext: CoroutineContext = Dispatchers.Default,
    resultFactory: suspend () -> Result<T>,
) = flow { collectResult(resultFactory()) }
    .flowOn(coroutineContext)
