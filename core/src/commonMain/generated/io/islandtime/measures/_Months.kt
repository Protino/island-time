//
// This file is auto-generated by 'tools:code-generator'
//
@file:JvmMultifileClass
@file:JvmName("MonthsKt")

package io.islandtime.measures

import io.islandtime.internal.MONTHS_PER_CENTURY
import io.islandtime.internal.MONTHS_PER_DECADE
import io.islandtime.internal.MONTHS_PER_YEAR
import io.islandtime.internal.toIntExact
import kotlin.Boolean
import kotlin.Comparable
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import kotlin.math.absoluteValue

@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS")
inline class IntMonths(
  val value: Int
) : Comparable<IntMonths> {
  val absoluteValue: IntMonths
    get() = IntMonths(value.absoluteValue)
  val inYears: IntYears
    get() = (this.value / MONTHS_PER_YEAR).years

  val inDecades: IntDecades
    get() = (this.value / MONTHS_PER_DECADE).decades

  val inCenturies: IntCenturies
    get() = (this.value / MONTHS_PER_CENTURY).centuries

  fun isZero(): Boolean = value == 0

  fun isNegative(): Boolean = value < 0

  fun isPositive(): Boolean = value > 0

  override fun compareTo(other: IntMonths): Int = value.compareTo(other.value)

  override fun toString(): String = if (isZero()) {
      "P0M"
  } else {
      buildString {
          if (isNegative()) { append('-') }
          append("P")
          append(value.absoluteValue)
          append('M')
      }
  }
  operator fun unaryMinus() = IntMonths(-value)

  operator fun plus(months: IntMonths) = IntMonths(this.value + months.value)

  operator fun plus(months: LongMonths) = LongMonths(this.value.toLong() + months.value)

  operator fun plus(years: IntYears) = this + years.inMonths

  operator fun plus(years: LongYears) = this.toLong() + years.inMonths

  operator fun plus(decades: IntDecades) = this + decades.inMonths

  operator fun plus(decades: LongDecades) = this.toLong() + decades.inMonths

  operator fun plus(centuries: IntCenturies) = this + centuries.inMonths

  operator fun plus(centuries: LongCenturies) = this.toLong() + centuries.inMonths

  operator fun minus(months: IntMonths) = plus(-months)

  operator fun minus(months: LongMonths) = plus(-months)

  operator fun minus(years: IntYears) = plus(-years)

  operator fun minus(years: LongYears) = plus(-years)

  operator fun minus(decades: IntDecades) = plus(-decades)

  operator fun minus(decades: LongDecades) = plus(-decades)

  operator fun minus(centuries: IntCenturies) = plus(-centuries)

  operator fun minus(centuries: LongCenturies) = plus(-centuries)

  operator fun times(scalar: Int) = IntMonths(this.value * scalar)

  operator fun times(scalar: Long) = this.toLong() * scalar

  operator fun div(scalar: Int) = IntMonths(this.value / scalar)

  operator fun div(scalar: Long) = this.toLong() / scalar

  operator fun rem(scalar: Int) = IntMonths(this.value % scalar)

  operator fun rem(scalar: Long) = this.toLong() % scalar

  inline fun <T> toComponents(action: (years: IntYears, months: IntMonths) -> T): T {
    val years = this.inYears
    val months = (this - years)
    return action(years, months)
  }

  inline fun <T> toComponents(action: (
    decades: IntDecades,
    years: IntYears,
    months: IntMonths
  ) -> T): T {
    val decades = this.inDecades
    val years = (this - decades).inYears
    val months = (this - decades - years)
    return action(decades, years, months)
  }

  inline fun <T> toComponents(action: (
    centuries: IntCenturies,
    decades: IntDecades,
    years: IntYears,
    months: IntMonths
  ) -> T): T {
    val centuries = this.inCenturies
    val decades = (this - centuries).inDecades
    val years = (this - centuries - decades).inYears
    val months = (this - centuries - decades - years)
    return action(centuries, decades, years, months)
  }

  fun toLong() = LongMonths(this.value.toLong())

  companion object {
    val MIN: IntMonths = IntMonths(Int.MIN_VALUE)

    val MAX: IntMonths = IntMonths(Int.MAX_VALUE)
  }
}

@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS")
inline class LongMonths(
  val value: Long
) : Comparable<LongMonths> {
  val absoluteValue: LongMonths
    get() = LongMonths(value.absoluteValue)
  val inYears: LongYears
    get() = (this.value / MONTHS_PER_YEAR).years

  val inDecades: LongDecades
    get() = (this.value / MONTHS_PER_DECADE).decades

  val inCenturies: LongCenturies
    get() = (this.value / MONTHS_PER_CENTURY).centuries

  fun isZero(): Boolean = value == 0L

  fun isNegative(): Boolean = value < 0L

  fun isPositive(): Boolean = value > 0L

  override fun compareTo(other: LongMonths): Int = value.compareTo(other.value)

  override fun toString(): String = if (isZero()) {
      "P0M"
  } else {
      buildString {
          if (isNegative()) { append('-') }
          append("P")
          append(value.absoluteValue)
          append('M')
      }
  }
  operator fun unaryMinus() = LongMonths(-value)

  operator fun plus(months: IntMonths) = LongMonths(this.value + months.value)

  operator fun plus(months: LongMonths) = LongMonths(this.value + months.value)

  operator fun plus(years: IntYears) = this + years.inMonths

  operator fun plus(years: LongYears) = this + years.inMonths

  operator fun plus(decades: IntDecades) = this + decades.inMonths

  operator fun plus(decades: LongDecades) = this + decades.inMonths

  operator fun plus(centuries: IntCenturies) = this + centuries.inMonths

  operator fun plus(centuries: LongCenturies) = this + centuries.inMonths

  operator fun minus(months: IntMonths) = plus(-months)

  operator fun minus(months: LongMonths) = plus(-months)

  operator fun minus(years: IntYears) = plus(-years)

  operator fun minus(years: LongYears) = plus(-years)

  operator fun minus(decades: IntDecades) = plus(-decades)

  operator fun minus(decades: LongDecades) = plus(-decades)

  operator fun minus(centuries: IntCenturies) = plus(-centuries)

  operator fun minus(centuries: LongCenturies) = plus(-centuries)

  operator fun times(scalar: Int) = LongMonths(this.value * scalar)

  operator fun times(scalar: Long) = LongMonths(this.value * scalar)

  operator fun div(scalar: Int) = LongMonths(this.value / scalar)

  operator fun div(scalar: Long) = LongMonths(this.value / scalar)

  operator fun rem(scalar: Int) = LongMonths(this.value % scalar)

  operator fun rem(scalar: Long) = LongMonths(this.value % scalar)

  inline fun <T> toComponents(action: (years: LongYears, months: IntMonths) -> T): T {
    val years = this.inYears
    val months = (this - years).toInt()
    return action(years, months)
  }

  inline fun <T> toComponents(action: (
    decades: LongDecades,
    years: IntYears,
    months: IntMonths
  ) -> T): T {
    val decades = this.inDecades
    val years = (this - decades).toInt().inYears
    val months = (this - decades - years).toInt()
    return action(decades, years, months)
  }

  inline fun <T> toComponents(action: (
    centuries: LongCenturies,
    decades: IntDecades,
    years: IntYears,
    months: IntMonths
  ) -> T): T {
    val centuries = this.inCenturies
    val decades = (this - centuries).toInt().inDecades
    val years = (this - centuries - decades).toInt().inYears
    val months = (this - centuries - decades - years).toInt()
    return action(centuries, decades, years, months)
  }

  fun toInt() = IntMonths(this.value.toInt())

  fun toIntExact() = IntMonths(this.value.toIntExact())

  companion object {
    val MIN: LongMonths = LongMonths(Long.MIN_VALUE)

    val MAX: LongMonths = LongMonths(Long.MAX_VALUE)
  }
}

val Int.months: IntMonths
  get() = IntMonths(this)

val Long.months: LongMonths
  get() = LongMonths(this)