@file:Suppress("unused")

package com.github.reyst.utils

import kotlin.time.DurationUnit
import kotlin.time.toDuration

fun Int.nanos() = toDuration(DurationUnit.NANOSECONDS)
fun Int.micros() = toDuration(DurationUnit.MICROSECONDS)
fun Int.mills() = toDuration(DurationUnit.MILLISECONDS)
fun Int.seconds() = toDuration(DurationUnit.SECONDS)
fun Int.minutes() = toDuration(DurationUnit.MINUTES)
fun Int.hours() = toDuration(DurationUnit.HOURS)
fun Int.days() = toDuration(DurationUnit.DAYS)

fun Long.nanos() = toDuration(DurationUnit.NANOSECONDS)
fun Long.micros() = toDuration(DurationUnit.MICROSECONDS)
fun Long.mills() = toDuration(DurationUnit.MILLISECONDS)
fun Long.seconds() = toDuration(DurationUnit.SECONDS)
fun Long.minutes() = toDuration(DurationUnit.MINUTES)
fun Long.hours() = toDuration(DurationUnit.HOURS)
fun Long.days() = toDuration(DurationUnit.DAYS)