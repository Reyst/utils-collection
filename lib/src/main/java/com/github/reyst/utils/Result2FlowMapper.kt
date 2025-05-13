package com.github.reyst.utils

import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

suspend inline fun <T> FlowCollector<T>.collectResult(result: Result<T>) = result.fold(
    onSuccess = { emit(it) },
    onFailure = { throw it },
)

fun <T> flowFromResult(block: suspend () -> Result<T>) = flow { collectResult(block()) }

fun <T> flowFromResult(
    coroutineContext: CoroutineContext,
    block: suspend () -> Result<T>,
) = flowFromResult(block)
    .flowOn(coroutineContext)
