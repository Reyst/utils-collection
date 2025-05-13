package com.github.reyst.utils

fun Boolean?.orTrue() = orDefault(true)

fun Boolean?.orFalse() = orDefault(false)

fun Boolean?.orDefault(default: Boolean) = this ?: default
