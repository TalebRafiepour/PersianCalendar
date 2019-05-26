/**
 * Persian Calendar see: http://code.google.com/p/persian-calendar/
 * Copyright (C) 2012  Mortezaadi@gmail.com
 * PersianCalendar.java
 *
 * Persian Calendar is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version three of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http:></http:>//www.gnu.org/licenses/>.
 */
package com.taleb.jalalicalendar

import java.util.*

/**
 *
 * ** Persian(Shamsi) calendar **
 *
 *
 *
 *
 *
 * The calendar consists of 12 months, the first six of which are 31 days, the
 * next five 30 days, and the final month 29 days in a normal year and 30 days
 * in a leap year.
 *
 *
 *
 * As one of the few calendars designed in the era of accurate positional
 * astronomy, the Persian calendar uses a very complex leap year structure which
 * makes it the most accurate solar calendar in use today. Years are grouped
 * into cycles which begin with four normal years after which every fourth
 * subsequent year in the cycle is a leap year. Cycles are grouped into grand
 * cycles of either 128 years (composed of cycles of 29, 33, 33, and 33 years)
 * or 132 years, containing cycles of of 29, 33, 33, and 37 years. A great grand
 * cycle is composed of 21 consecutive 128 year grand cycles and a final 132
 * grand cycle, for a total of 2820 years. The pattern of normal and leap years
 * which began in 1925 will not repeat until the year 4745!
 *
 *  Each 2820 year great grand cycle contains 2137 normal years of 365 days
 * and 683 leap years of 366 days, with the average year length over the great
 * grand cycle of 365.24219852. So close is this to the actual solar tropical
 * year of 365.24219878 days that the Persian calendar accumulates an error of
 * one day only every three.8 million years. As a purely solar calendar, months are
 * not synchronized with the phases of the Moon.
 *
 *
 *
 *
 *
 *
 * **PersianCalendar** by extending Default GregorianCalendar
 * provides capabilities such as:
 *
 *
 *
 *
 *
 *  * you can set the date in Persian by setPersianDate(persianYear,
 * persianMonth, persianDay) and get the Gregorian date or vice versa
 *
 *
 *
 *  * determine is the current date is Leap year in persian calendar or not by
 * IsPersianLeapYear()
 *
 *
 *
 *  * getPersian short and long Date String getPersianShortDate() and
 * getPersianLongDate you also can set delimiter to assign delimiter of returned
 * dateString
 *
 *
 *
 *  * Parse string based on assigned delimiter
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * ** ThirdRateModel **
 *
 *
 *
 *
 *
 * <pre>
 * `PersianCalendar persianCal = new PersianCalendar();
 * System.out.println(persianCal.getPersianShortDate());
 *
 * persianCal.set(1982, Calendar.MAY, 22);
 * System.out.println(persianCal.getPersianShortDate());
 *
 * persianCal.setDelimiter(" , ");
 * persianCal.parse("1361 , 03 , 01");
 * System.out.println(persianCal.getPersianShortDate());
 *
 * persianCal.setPersianDate(1361, three, one);
 * System.out.println(persianCal.getPersianLongDate());
 * System.out.println(persianCal.getTime());
 *
 * persianCal.addPersianDate(Calendar.MONTH, 33);
 * persianCal.addPersianDate(Calendar.YEAR, 5);
 * persianCal.addPersianDate(Calendar.DATE, 50);
 *
` *
 *
 * <pre>
 * @author Morteza  contact: [Mortezaadi@gmail.com](mailto:Mortezaadi@gmail.com)
 * @version one.one
</pre></pre> */
class PersianCalendar : GregorianCalendar {

    // calculatePersianDate();
    var persianYear: Int = 0
        private set
    private var persianMonth: Int = 0
    /**
     *
     * @return int Persian day in month
     */
    // calculatePersianDate();
    var persianDay: Int = 0
        private set
    // use to seperate PersianDate's field and also Parse the DateString based
    // on this delimiter
    /**
     * assign delimiter to use as a separator of date fields.
     *
     * @param delimiter
     */
    var delimiter = "/"

    /**
     *
     * Determines if the given year is a leap year in persian calendar. Returns
     * true if the given year is a leap year.
     *
     * @return boolean
     */
    // calculatePersianDate();
    val isPersianLeapYear: Boolean
        get() = PersianCalendarUtils.isPersianLeapYear(this.persianYear)

    /**
     *
     * @return String persian month name
     */
    // calculatePersianDate();
    val persianMonthName: String
        get() = PersianCalendarConstants.persianMonthNames[this.persianMonth]

    /**
     *
     * @return String Name of the day in week
     */
    val persianWeekDayName: String
        get() {
            when (get(Calendar.DAY_OF_WEEK)) {
                Calendar.SATURDAY -> return PersianCalendarConstants.persianWeekDays[0]
                Calendar.SUNDAY -> return PersianCalendarConstants.persianWeekDays[1]
                Calendar.MONDAY -> return PersianCalendarConstants.persianWeekDays[2]
                Calendar.TUESDAY -> return PersianCalendarConstants.persianWeekDays[3]
                Calendar.WEDNESDAY -> return PersianCalendarConstants.persianWeekDays[4]
                Calendar.THURSDAY -> return PersianCalendarConstants.persianWeekDays[5]
                else -> return PersianCalendarConstants.persianWeekDays[6]
            }

        }

    /**
     *
     * @return String of Persian Date ex: شنبه 01 خرداد 1361
     */
    val persianLongDate: String
        get() = persianWeekDayName + "  " + this.persianDay + "  " + persianMonthName + "  " + this.persianYear

    val persianLongDateAndTime: String
        get() = persianLongDate + " ساعت " + get(Calendar.HOUR_OF_DAY) + ":" + get(Calendar.MINUTE) + ":" + get(Calendar.SECOND)

    /**
     *
     * @return String of persian date formatted by
     * 'YYYY[delimiter]mm[delimiter]dd' default delimiter is '/'
     */
    // calculatePersianDate();
    val persianShortDate: String
        get() = "" + formatToMilitary(this.persianYear) + delimiter + formatToMilitary(getPersianMonth()) + delimiter + formatToMilitary(this.persianDay)

    val persianShortDateTime: String
        get() = ("" + formatToMilitary(this.persianYear) + delimiter + formatToMilitary(getPersianMonth()) + delimiter + formatToMilitary(this.persianDay) + " " + formatToMilitary(this.get(Calendar.HOUR_OF_DAY)) + ":" + formatToMilitary(get(Calendar.MINUTE))
                + ":" + formatToMilitary(get(Calendar.SECOND)))

    private fun convertToMilis(julianDate: Long): Long {
        return (PersianCalendarConstants.MILLIS_JULIAN_EPOCH + julianDate * PersianCalendarConstants.MILLIS_OF_A_DAY
                + PersianCalendarUtils.ceil(
            (timeInMillis - PersianCalendarConstants.MILLIS_JULIAN_EPOCH).toDouble(),
            PersianCalendarConstants.MILLIS_OF_A_DAY.toDouble()
        ))
    }

    /**
     * default constructor
     *
     * most of the time we don't care about TimeZone when we persisting Date or
     * doing some calculation on date. ** Default TimeZone was set to
     * "GMT" ** in order to make developer to work more convenient with
     * the library; however you can change the TimeZone as you do in
     * GregorianCalendar by calling setTimeZone()
     */
    constructor(millis: Long) {
        timeInMillis = millis
    }

    /**
     * default constructor
     *
     * most of the time we don't care about TimeZone when we persisting Date or
     * doing some calculation on date. ** Default TimeZone was set to
     * "GMT" ** in order to make developer to work more convenient with
     * the library; however you can change the TimeZone as you do in
     * GregorianCalendar by calling setTimeZone()
     */
    constructor() {
        timeZone = TimeZone.getTimeZone("GMT")
    }

    /**
     *
     * @param timezone
     */
    constructor(timezone: TimeZone) {
        timeZone = timezone
    }

    /**
     * Calculate persian date from current Date and populates the corresponding
     * fields(persianYear, persianMonth, persianDay)
     */
    protected fun calculatePersianDate() {
        val julianDate = Math.floor((timeInMillis - PersianCalendarConstants.MILLIS_JULIAN_EPOCH).toDouble()).toLong() / PersianCalendarConstants.MILLIS_OF_A_DAY
        val PersianRowDate = PersianCalendarUtils.julianToPersian(julianDate)
        val year = PersianRowDate shr 16
        val month = (PersianRowDate and 0xff00).toInt() shr 8
        val day = (PersianRowDate and 0xff).toInt()
        this.persianYear = (if (year > 0) year else year - 1).toInt()
        this.persianMonth = month
        this.persianDay = day
    }

    /**
     * set the persian date it converts PersianDate to the Julian and assigned
     * equivalent milliseconds to the instance
     *
     * @param persianYear
     * @param persianMonth
     * @param persianDay
     */
    fun setPersianDate(persianYear: Int, persianMonth: Int, persianDay: Int) {
        this.persianYear = persianYear
        this.persianMonth = persianMonth
        this.persianDay = persianDay
        timeInMillis = convertToMilis(
            PersianCalendarUtils.persianToJulian(
                (if (this.persianYear > 0) this.persianYear else this.persianYear + 1).toLong(),
                this.persianMonth - 1,
                this.persianDay
            )
        )
    }

    /**
     *
     * @return int persian month number
     */
    fun getPersianMonth(): Int {
        // calculatePersianDate();
        return this.persianMonth + 1
    }

    private fun formatToMilitary(i: Int): String {
        return if (i < 9) "0$i" else i.toString()
    }

    /**
     * add specific amout of fields to the current date for now doesnt handle
     * before one farvardin hejri (before epoch)
     *
     * @param field
     * @param amount
     * <pre>
     * Usage:
     * `addPersianDate(Calendar.YEAR, two);
     * addPersianDate(Calendar.MONTH, three);
    ` *
    </pre> *
     *
     * u can also use Calendar.HOUR_OF_DAY,Calendar.MINUTE,
     * Calendar.SECOND, Calendar.MILLISECOND etc
     */
    //
    fun addPersianDate(field: Int, amount: Int) {
        if (amount == 0) {
            return  // Do nothing!
        }

        if (field < 0 || field >= Calendar.ZONE_OFFSET) {
            throw IllegalArgumentException()
        }

        if (field == Calendar.YEAR) {
            setPersianDate(this.persianYear + amount, getPersianMonth(), this.persianDay)
            return
        } else if (field == Calendar.MONTH) {
            setPersianDate(this.persianYear + (getPersianMonth() + amount) / 12, (getPersianMonth() + amount) % 12, this.persianDay)
            return
        }
        add(field, amount)
        calculatePersianDate()
    }

    /**
     * <pre>
     * use `[PersianDateParser]` to parse string
     * and get the Persian Date.
    </pre> *
     *
     * @see PersianDateParser
     *
     * @param dateString
     */
    fun parse(dateString: String) {
        val p = PersianDateParser(dateString, delimiter).persianDate
        setPersianDate(p.persianYear, p.persianMonth, p.persianDay)
    }

    override fun toString(): String {
        val str = super.toString()
        return str.substring(0, str.length - 1) + ",PersianDate=" + persianShortDate + "]"
    }

    override fun equals(obj: Any?): Boolean {
        return super.equals(obj)

    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun set(field: Int, value: Int) {
        super.set(field, value)
        calculatePersianDate()
    }

    override fun setTimeInMillis(millis: Long) {
        super.setTimeInMillis(millis)
        calculatePersianDate()
    }

    override fun setTimeZone(zone: TimeZone) {
        super.setTimeZone(zone)
        calculatePersianDate()
    }

    companion object {

        private val serialVersionUID = 5541422440580682494L
    }
}
