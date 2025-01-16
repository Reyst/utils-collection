package com.github.reyst.utils

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
fun <T> T?.isNull(): Boolean {
    contract {
        returns(false) implies (this@isNull != null)
    }
    return this == null
}

@OptIn(ExperimentalContracts::class)
fun <T> T?.isNotNull(): Boolean {
    contract {
        returns(true) implies (this@isNotNull != null)
    }
    return !isNull()
}

@OptIn(ExperimentalContracts::class)
inline fun <reified T> T?.isNullOr(predicate: T.() -> Boolean): Boolean {
    contract {
        returns(false) implies (this@isNullOr != null)
    }
    return isNull() || predicate()
}

@OptIn(ExperimentalContracts::class)
inline fun <reified T> T?.isNotNullAnd(predicate: T.() -> Boolean): Boolean {
    contract {
        returns(true) implies (this@isNotNullAnd != null)
    }
    return isNotNull() && predicate()
}
