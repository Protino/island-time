//
// This file is auto-generated by 'tools:code-generator'
//
@file:JvmMultifileClass
@file:JvmName("SecondsKt")

package io.islandtime.measures

import io.islandtime.internal.MICROSECONDS_PER_SECOND
import io.islandtime.internal.MILLISECONDS_PER_SECOND
import io.islandtime.internal.NANOSECONDS_PER_SECOND
import io.islandtime.internal.SECONDS_PER_DAY
import io.islandtime.internal.SECONDS_PER_HOUR
import io.islandtime.internal.SECONDS_PER_MINUTE
import io.islandtime.internal.minusExact
import io.islandtime.internal.negateExact
import io.islandtime.internal.plusExact
import io.islandtime.internal.timesExact
import io.islandtime.internal.toIntExact
import kotlin.Boolean
import kotlin.Comparable
import kotlin.Int
import kotlin.Long
import kotlin.PublishedApi
import kotlin.String
import kotlin.Suppress
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import kotlin.math.absoluteValue

/**
 * A number of seconds.
 */
@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS")
inline class IntSeconds(
  /**
   * The underlying value.
   */
  val value: Int
) : Comparable<IntSeconds> {
  /**
   * Get the absolute value.
   * @throws ArithmeticException if overflow occurs
   */
  val absoluteValue: IntSeconds
    get() = if (value < 0) IntSeconds(value.negateExact()) else this
  /**
   * Convert to nanoseconds.
   */
  val inNanoseconds: LongNanoseconds
    get() = (value.toLong() * NANOSECONDS_PER_SECOND).nanoseconds

  /**
   * Convert to microseconds.
   */
  val inMicroseconds: LongMicroseconds
    get() = (value.toLong() * MICROSECONDS_PER_SECOND).microseconds

  /**
   * Convert to milliseconds.
   */
  val inMilliseconds: LongMilliseconds
    get() = (value.toLong() * MILLISECONDS_PER_SECOND).milliseconds

  /**
   * Convert to whole minutes.
   */
  val inMinutes: IntMinutes
    get() = (value / SECONDS_PER_MINUTE).minutes

  /**
   * Convert to whole hours.
   */
  val inHours: IntHours
    get() = (value / SECONDS_PER_HOUR).hours

  /**
   * Convert to whole days.
   */
  val inDays: IntDays
    get() = (value / SECONDS_PER_DAY).days

  /**
   * Is this duration zero?
   */
  fun isZero(): Boolean = value == 0

  /**
   * Is this duration negative?
   */
  fun isNegative(): Boolean = value < 0

  /**
   * Is this duration positive?
   */
  fun isPositive(): Boolean = value > 0

  override fun compareTo(other: IntSeconds): Int = value.compareTo(other.value)

  /**
   * Convert to an ISO-8601 time interval representation.
   */
  override fun toString(): String {
     return when {
       isZero() -> "PT0S"
       value == Int.MIN_VALUE -> "-PT2147483648S"
       else -> buildString {
         if (isNegative()) { append('-') }
         append("PT")
         append(value.absoluteValue)
         append('S')
       }
     }
  }

  /**
   * Negate the value.
   * @throws ArithmeticException if overflow occurs
   */
  operator fun unaryMinus() = IntSeconds(value.negateExact())

  /**
   * Negate the value without checking for overflow.
   */
  internal fun negateUnchecked() = IntSeconds(-value)

  /**
   * Multiply by a scalar value.
   * @throws ArithmeticException if overflow occurs
   */
  operator fun times(scalar: Int) = IntSeconds(value timesExact scalar)

  /**
   * Multiply by a scalar value.
   * @throws ArithmeticException if overflow occurs
   */
  operator fun times(scalar: Long) = this.toLongSeconds() * scalar

  /**
   * Divide by a scalar value.
   * @throws ArithmeticException if overflow occurs or the scalar is zero
   */
  operator fun div(scalar: Int): IntSeconds {
     return if (scalar == -1) {
       -this
     } else {
       IntSeconds(value / scalar)
     }
  }

  /**
   * Divide by a scalar value.
   * @throws ArithmeticException if the scalar is zero
   */
  operator fun div(scalar: Long): LongSeconds = this.toLongSeconds() / scalar
  operator fun rem(scalar: Int) = IntSeconds(value % scalar)

  operator fun rem(scalar: Long) = this.toLongSeconds() % scalar

  operator fun plus(nanoseconds: IntNanoseconds) = this.inNanoseconds + nanoseconds

  operator fun minus(nanoseconds: IntNanoseconds) = this.inNanoseconds - nanoseconds

  operator fun plus(nanoseconds: LongNanoseconds) = this.toLongSeconds().inNanoseconds + nanoseconds

  operator fun minus(nanoseconds: LongNanoseconds) = this.toLongSeconds().inNanoseconds -
      nanoseconds

  operator fun plus(microseconds: IntMicroseconds) = this.inMicroseconds + microseconds

  operator fun minus(microseconds: IntMicroseconds) = this.inMicroseconds - microseconds

  operator fun plus(microseconds: LongMicroseconds) = this.toLongSeconds().inMicroseconds +
      microseconds

  operator fun minus(microseconds: LongMicroseconds) = this.toLongSeconds().inMicroseconds -
      microseconds

  operator fun plus(milliseconds: IntMilliseconds) = this.inMilliseconds + milliseconds

  operator fun minus(milliseconds: IntMilliseconds) = this.inMilliseconds - milliseconds

  operator fun plus(milliseconds: LongMilliseconds) = this.toLongSeconds().inMilliseconds +
      milliseconds

  operator fun minus(milliseconds: LongMilliseconds) = this.toLongSeconds().inMilliseconds -
      milliseconds

  operator fun plus(seconds: IntSeconds) = IntSeconds(value plusExact seconds.value)

  operator fun minus(seconds: IntSeconds) = IntSeconds(value minusExact seconds.value)

  operator fun plus(seconds: LongSeconds) = LongSeconds(value.toLong() plusExact seconds.value)

  operator fun minus(seconds: LongSeconds) = LongSeconds(value.toLong() minusExact seconds.value)

  operator fun plus(minutes: IntMinutes) = this + minutes.inSeconds

  operator fun minus(minutes: IntMinutes) = this - minutes.inSeconds

  operator fun plus(minutes: LongMinutes) = this.toLongSeconds() + minutes.inSeconds

  operator fun minus(minutes: LongMinutes) = this.toLongSeconds() - minutes.inSeconds

  operator fun plus(hours: IntHours) = this + hours.inSeconds

  operator fun minus(hours: IntHours) = this - hours.inSeconds

  operator fun plus(hours: LongHours) = this.toLongSeconds() + hours.inSeconds

  operator fun minus(hours: LongHours) = this.toLongSeconds() - hours.inSeconds

  operator fun plus(days: IntDays) = this + days.inSeconds

  operator fun minus(days: IntDays) = this - days.inSeconds

  operator fun plus(days: LongDays) = this.toLongSeconds() + days.inSeconds

  operator fun minus(days: LongDays) = this.toLongSeconds() - days.inSeconds

  inline fun <T> toComponents(action: (minutes: IntMinutes, seconds: IntSeconds) -> T): T {
    val minutes = this.inMinutes
    val seconds = (this - minutes)
    return action(minutes, seconds)
  }

  inline fun <T> toComponents(action: (
    hours: IntHours,
    minutes: IntMinutes,
    seconds: IntSeconds
  ) -> T): T {
    val hours = this.inHours
    val minutes = (this - hours).inMinutes
    val seconds = (this - hours - minutes)
    return action(hours, minutes, seconds)
  }

  inline fun <T> toComponents(action: (
    days: IntDays,
    hours: IntHours,
    minutes: IntMinutes,
    seconds: IntSeconds
  ) -> T): T {
    val days = this.inDays
    val hours = (this - days).inHours
    val minutes = (this - days - hours).inMinutes
    val seconds = (this - days - hours - minutes)
    return action(days, hours, minutes, seconds)
  }

  /**
   * Convert to [LongSeconds].
   */
  fun toLongSeconds() = LongSeconds(value.toLong())

  /**
   * Convert to a unit-less `Long` value.
   */
  fun toLong() = value.toLong()

  companion object {
    /**
     * The smallest supported value.
     */
    val MIN: IntSeconds = IntSeconds(Int.MIN_VALUE)

    /**
     * The largest supported value.
     */
    val MAX: IntSeconds = IntSeconds(Int.MAX_VALUE)
  }
}

/**
 * Convert to [IntSeconds].
 */
val Int.seconds: IntSeconds
  get() = IntSeconds(this)

/**
 * A number of seconds.
 */
@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS")
inline class LongSeconds(
  /**
   * The underlying value.
   */
  val value: Long
) : Comparable<LongSeconds> {
  /**
   * Get the absolute value.
   * @throws ArithmeticException if overflow occurs
   */
  val absoluteValue: LongSeconds
    get() = if (value < 0) LongSeconds(value.negateExact()) else this
  /**
   * Convert to nanoseconds.
   * @throws ArithmeticException if overflow occurs
   */
  val inNanoseconds: LongNanoseconds
    get() = (value timesExact NANOSECONDS_PER_SECOND).nanoseconds

  /**
   * Convert to nanoseconds without checking for overflow.
   */
  internal val inNanosecondsUnchecked: LongNanoseconds
    get() = (value * NANOSECONDS_PER_SECOND).nanoseconds

  /**
   * Convert to microseconds.
   * @throws ArithmeticException if overflow occurs
   */
  val inMicroseconds: LongMicroseconds
    get() = (value timesExact MICROSECONDS_PER_SECOND).microseconds

  /**
   * Convert to microseconds without checking for overflow.
   */
  internal val inMicrosecondsUnchecked: LongMicroseconds
    get() = (value * MICROSECONDS_PER_SECOND).microseconds

  /**
   * Convert to milliseconds.
   * @throws ArithmeticException if overflow occurs
   */
  val inMilliseconds: LongMilliseconds
    get() = (value timesExact MILLISECONDS_PER_SECOND).milliseconds

  /**
   * Convert to milliseconds without checking for overflow.
   */
  internal val inMillisecondsUnchecked: LongMilliseconds
    get() = (value * MILLISECONDS_PER_SECOND).milliseconds

  /**
   * Convert to whole minutes.
   */
  val inMinutes: LongMinutes
    get() = (value / SECONDS_PER_MINUTE).minutes

  /**
   * Convert to whole hours.
   */
  val inHours: LongHours
    get() = (value / SECONDS_PER_HOUR).hours

  /**
   * Convert to whole days.
   */
  val inDays: LongDays
    get() = (value / SECONDS_PER_DAY).days

  /**
   * Is this duration zero?
   */
  fun isZero(): Boolean = value == 0L

  /**
   * Is this duration negative?
   */
  fun isNegative(): Boolean = value < 0L

  /**
   * Is this duration positive?
   */
  fun isPositive(): Boolean = value > 0L

  override fun compareTo(other: LongSeconds): Int = value.compareTo(other.value)

  /**
   * Convert to an ISO-8601 time interval representation.
   */
  override fun toString(): String {
     return when {
       isZero() -> "PT0S"
       value == Long.MIN_VALUE -> "-PT9223372036854775808S"
       else -> buildString {
         if (isNegative()) { append('-') }
         append("PT")
         append(value.absoluteValue)
         append('S')
       }
     }
  }

  /**
   * Negate the value.
   * @throws ArithmeticException if overflow occurs
   */
  operator fun unaryMinus() = LongSeconds(value.negateExact())

  /**
   * Negate the value without checking for overflow.
   */
  internal fun negateUnchecked() = LongSeconds(-value)

  /**
   * Multiply by a scalar value.
   * @throws ArithmeticException if overflow occurs
   */
  operator fun times(scalar: Int) = LongSeconds(value timesExact scalar)

  /**
   * Multiply by a scalar value.
   * @throws ArithmeticException if overflow occurs
   */
  operator fun times(scalar: Long) = LongSeconds(value timesExact scalar)

  /**
   * Divide by a scalar value.
   * @throws ArithmeticException if overflow occurs or the scalar is zero
   */
  operator fun div(scalar: Int): LongSeconds {
     return if (scalar == -1) {
       -this
     } else {
       LongSeconds(value / scalar)
     }
  }

  /**
   * Divide by a scalar value.
   * @throws ArithmeticException if overflow occurs or the scalar is zero
   */
  operator fun div(scalar: Long): LongSeconds {
     return if (scalar == -1L) {
       -this
     } else {
       LongSeconds(value / scalar)
     }
  }

  operator fun rem(scalar: Int) = LongSeconds(value % scalar)

  operator fun rem(scalar: Long) = LongSeconds(value % scalar)

  operator fun plus(nanoseconds: IntNanoseconds) = this.inNanoseconds + nanoseconds

  operator fun minus(nanoseconds: IntNanoseconds) = this.inNanoseconds - nanoseconds

  operator fun plus(nanoseconds: LongNanoseconds) = this.inNanoseconds + nanoseconds

  operator fun minus(nanoseconds: LongNanoseconds) = this.inNanoseconds - nanoseconds

  operator fun plus(microseconds: IntMicroseconds) = this.inMicroseconds + microseconds

  operator fun minus(microseconds: IntMicroseconds) = this.inMicroseconds - microseconds

  operator fun plus(microseconds: LongMicroseconds) = this.inMicroseconds + microseconds

  operator fun minus(microseconds: LongMicroseconds) = this.inMicroseconds - microseconds

  operator fun plus(milliseconds: IntMilliseconds) = this.inMilliseconds + milliseconds

  operator fun minus(milliseconds: IntMilliseconds) = this.inMilliseconds - milliseconds

  operator fun plus(milliseconds: LongMilliseconds) = this.inMilliseconds + milliseconds

  operator fun minus(milliseconds: LongMilliseconds) = this.inMilliseconds - milliseconds

  operator fun plus(seconds: IntSeconds) = LongSeconds(value plusExact seconds.value)

  operator fun minus(seconds: IntSeconds) = LongSeconds(value minusExact seconds.value)

  operator fun plus(seconds: LongSeconds) = LongSeconds(value plusExact seconds.value)

  operator fun minus(seconds: LongSeconds) = LongSeconds(value minusExact seconds.value)

  operator fun plus(minutes: IntMinutes) = this + minutes.inSeconds

  operator fun minus(minutes: IntMinutes) = this - minutes.inSeconds

  operator fun plus(minutes: LongMinutes) = this + minutes.inSeconds

  operator fun minus(minutes: LongMinutes) = this - minutes.inSeconds

  operator fun plus(hours: IntHours) = this + hours.inSeconds

  operator fun minus(hours: IntHours) = this - hours.inSeconds

  operator fun plus(hours: LongHours) = this + hours.inSeconds

  operator fun minus(hours: LongHours) = this - hours.inSeconds

  operator fun plus(days: IntDays) = this + days.inSeconds

  operator fun minus(days: IntDays) = this - days.inSeconds

  operator fun plus(days: LongDays) = this + days.inSeconds

  operator fun minus(days: LongDays) = this - days.inSeconds

  inline fun <T> toComponents(action: (minutes: LongMinutes, seconds: IntSeconds) -> T): T {
    val minutes = this.inMinutes
    val seconds = (this - minutes).toIntSecondsUnchecked()
    return action(minutes, seconds)
  }

  inline fun <T> toComponents(action: (
    hours: LongHours,
    minutes: IntMinutes,
    seconds: IntSeconds
  ) -> T): T {
    val hours = this.inHours
    val minutes = (this - hours).toIntSecondsUnchecked().inMinutes
    val seconds = (this - hours - minutes).toIntSecondsUnchecked()
    return action(hours, minutes, seconds)
  }

  inline fun <T> toComponents(action: (
    days: LongDays,
    hours: IntHours,
    minutes: IntMinutes,
    seconds: IntSeconds
  ) -> T): T {
    val days = this.inDays
    val hours = (this - days).toIntSecondsUnchecked().inHours
    val minutes = (this - days - hours).toIntSecondsUnchecked().inMinutes
    val seconds = (this - days - hours - minutes).toIntSecondsUnchecked()
    return action(days, hours, minutes, seconds)
  }

  /**
   * Convert to [IntSeconds].
   * @throws ArithmeticException if overflow occurs
   */
  fun toIntSeconds() = IntSeconds(value.toIntExact())

  /**
   * Convert to [IntSeconds] without checking for overflow.
   */
  @PublishedApi
  internal fun toIntSecondsUnchecked() = IntSeconds(value.toInt())

  /**
   * Convert to a unit-less `Int` value.
   * @throws ArithmeticException if overflow occurs
   */
  fun toInt() = value.toIntExact()

  /**
   * Convert to a unit-less `Int` value without checking for overflow.
   */
  internal fun toIntUnchecked() = value.toInt()

  companion object {
    /**
     * The smallest supported value.
     */
    val MIN: LongSeconds = LongSeconds(Long.MIN_VALUE)

    /**
     * The largest supported value.
     */
    val MAX: LongSeconds = LongSeconds(Long.MAX_VALUE)
  }
}

/**
 * Convert to [LongSeconds].
 */
val Long.seconds: LongSeconds
  get() = LongSeconds(this)
