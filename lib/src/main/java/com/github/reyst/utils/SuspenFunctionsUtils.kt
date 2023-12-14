@file:Suppress("unused")

package com.github.reyst.utils

import kotlinx.coroutines.runBlocking

inline fun <reified T, R> T.runSync(crossinline action: suspend T.() -> R): R = runBlocking {
    action()
}
