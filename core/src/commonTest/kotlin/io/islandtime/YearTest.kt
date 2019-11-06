package io.islandtime

import io.islandtime.ranges.DateRange
import io.islandtime.measures.days
import io.islandtime.measures.years
import io.islandtime.parser.DateTimeParseException
import io.islandtime.parser.dateTimeParser
import io.islandtime.parser.monthNumber
import io.islandtime.test.AbstractIslandTimeTest
import kotlin.test.*

class YearTest : AbstractIslandTimeTest() {
    @Test
    fun `isValid can be used to check if the Year was initialized with an invalid value`() {
        assertFalse { Year(0).isValid }
        assertFalse { Year(10_000).isValid }
    }

    @Test
    fun `validated() throws an exception if the current value is invalid`() {
        assertFailsWith<DateTimeException> { Year(0).validated() }
        assertFailsWith<DateTimeException> { Year(10_000).validated() }
    }

    @Test
    fun `isLeap property returns false for common years`() {
        assertFalse { Year(2001).isLeap }
        assertFalse { Year(1900).isLeap }
        assertFalse { Year(1965).isLeap }
    }

    @Test
    fun `isLeap property returns true for leap years`() {
        assertTrue { Year(2000).isLeap }
        assertTrue { Year(1964).isLeap }
    }

    @Test
    fun `length property returns days in year`() {
        assertEquals(366.days, Year(2000).length)
        assertEquals(365.days, Year(2001).length)
    }

    @Test
    fun `lastDay property returns the last day of the year`() {
        assertEquals(366, Year(2000).lastDay)
        assertEquals(365, Year(2001).lastDay)
    }

    @Test
    fun `dayRange property returns the range of days in the year`() {
        assertEquals(IntRange(1, 366), Year(2000).dayRange)
        assertEquals(IntRange(1, 365), Year(2001).dayRange)
    }

    @Test
    fun `dateRange property returns the range of dates in the year`() {
        assertEquals(
            DateRange(Date(2000, Month.JANUARY, 1), Date(2000, Month.DECEMBER, 31)),
            Year(2000).dateRange
        )
    }

    @Test
    fun `startDate property returns the first date of the year`() {
        assertEquals(Date(2000, Month.JANUARY, 1), Year(2000).startDate)
    }

    @Test
    fun `endDate property returns the last date of the year`() {
        assertEquals(Date(2000, Month.DECEMBER, 31), Year(2000).endDate)
    }

    @Test
    fun `adding zero years has no effect`() {
        assertEquals(Year(2009), Year(2009) + 0.years)
        assertEquals(Year(2009), Year(2009) + 0L.years)
    }

    @Test
    fun `add positive years`() {
        assertEquals(Year(1970), Year(1969) + 1.years)
        assertEquals(Year(2009), Year(2000) + 9.years)
        assertEquals(Year(2009), Year(2000) + 9L.years)
        assertEquals(Year(9999), Year(1) + 9998.years)
    }

    @Test
    fun `add negative years`() {
        assertEquals(Year(2000), Year(2010) + (-10).years)
        assertEquals(Year(1), Year(2) + (-1L).years)
        assertEquals(Year(1000), Year(9999) + (-8999).years)
    }

    @Test
    fun `throws an exception when adding years puts the year outside the supported range`() {
        assertFailsWith<DateTimeException> { Year(9999) + 1.years }
        assertFailsWith<DateTimeException> { Year(1) + (-1).years }
    }

    @Test
    fun `subtracting zero years has no effect`() {
        assertEquals(Year(2009), Year(2009) - 0.years)
        assertEquals(Year(2009), Year(2009) - 0L.years)
    }

    @Test
    fun `subtract positive years`() {
        assertEquals(Year(2000), Year(2010) - 10.years)
        assertEquals(Year(1), Year(2) - 1L.years)
        assertEquals(Year(1000), Year(9999) - 8999.years)
    }

    @Test
    fun `subtract negative years`() {
        assertEquals(Year(1970), Year(1969) - (-1).years)
        assertEquals(Year(2009), Year(2000) - (-9).years)
        assertEquals(Year(2009), Year(2000) - (-9L).years)
        assertEquals(Year(9999), Year(1) - (-9998).years)
    }

    @Test
    fun `throws an exception when subtracting years puts the year outside the supported range`() {
        assertFailsWith<DateTimeException> { Year(9999) - (-1).years }
        assertFailsWith<DateTimeException> { Year(1) - 1.years }
    }

    @Test
    fun `contains YearMonth`() {
        assertTrue { YearMonth(2019, Month.JANUARY) in Year(2019) }
        assertTrue { YearMonth(2019, Month.DECEMBER) in Year(2019) }
        assertFalse { YearMonth(2020, Month.JANUARY) in Year(2019) }
        assertFalse { YearMonth(2018, Month.DECEMBER) in Year(2019) }
    }

    @Test
    fun `contains Date`() {
        assertTrue { Date(2019, Month.JANUARY, 1) in Year(2019) }
        assertTrue { Date(2019, Month.DECEMBER, 31) in Year(2019) }
        assertFalse { Date(2020, Month.JANUARY, 1) in Year(2019) }
        assertFalse { Date(2018, Month.DECEMBER, 31) in Year(2019) }
    }

    @Test
    fun `toString() returns the year with a minimum of 4 digits as required by ISO-8601`() {
        assertEquals("2008", Year(2008).toString())
        assertEquals("0001", Year(1).toString())
    }

    @Test
    fun `String_toYear() throws an exception when the string is empty`() {
        assertFailsWith<DateTimeParseException> { "".toYear() }
    }

    @Test
    fun `String_toYear() throws an exception when parsing an improperly formatted string`() {
        assertFailsWith<DateTimeParseException> { "1".toYear() }
        assertFailsWith<DateTimeParseException> { "01".toYear() }
        assertFailsWith<DateTimeParseException> { "001".toYear() }
        assertFailsWith<DateTimeParseException> { " 2008".toYear() }
        assertFailsWith<DateTimeParseException> { "+2008".toYear() }
        assertFailsWith<DateTimeParseException> { "2008-".toYear() }
    }

    @Test
    fun `String_toYear() throws an exception when the year is outside the supported range`() {
        assertFailsWith<DateTimeException> { "0000".toYear() }
    }

    @Test
    fun `String_toYear() converts an ISO-8601 year string to a Year`() {
        assertEquals(Year(1), "0001".toYear())
        assertEquals(Year(2010), "2010".toYear())
    }

    @Test
    fun `String_toYear() throws an exception when the parser fails to supply the YEAR field`() {
        val customParser = dateTimeParser { monthNumber(2) }
        assertFailsWith<DateTimeParseException> { "12".toYear(customParser) }
    }
}