/*
 * (c) 2015 - Jose A. Garcia Sanchez
 */
package org.jag.geca.web.convert;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author jose
 */
@RunWith(JUnitParamsRunner.class)
public class LocalDateConverterTest {
    private LocalDateConverter underTest = new LocalDateConverter();

    public Object[] conversionFechas() {
        // @formatter:off
        return new Object[][] {
                {LocalDate.of(1900, Calendar.JANUARY, 1), "01/ene/1900"},
                {LocalDate.of(1950, Calendar.FEBRUARY, 2), "02/feb/1950"},
                {LocalDate.of(1975, Calendar.MARCH, 3), "03/mar/1975"},
                {LocalDate.of(2000, Calendar.APRIL, 4), "04/abr/2000"},
                {LocalDate.of(2000, Calendar.FEBRUARY, 29), "29/feb/2000"},
                {LocalDate.of(2005, Calendar.MAY, 5), "05/may/2005"},
                {LocalDate.of(2006, Calendar.JUNE, 10), "10/jun/2006"},
                {LocalDate.of(2007, Calendar.JULY, 14), "14/jul/2007"},
                {LocalDate.of(2008, Calendar.AUGUST, 21), "21/ago/2008"},
                {LocalDate.of(2009, Calendar.SEPTEMBER, 23), "23/sep/2009"},
                {LocalDate.of(2010, Calendar.OCTOBER, 26), "26/oct/2010"},
                {LocalDate.of(2012, Calendar.NOVEMBER, 28), "28/nov/2012"},
                {LocalDate.of(2014, Calendar.DECEMBER, 31), "31/dic/2014"}
        };
        // @formatter:on
    }

    @Test
    @Parameters(method = "conversionFechas")
    @TestCaseName("For [{0}] is expected [{1}]")
    public void convertToString(final org.joda.time.LocalDate date, final String expectedFormattedDate) {
        assertEquals(expectedFormattedDate, underTest.convertToString(date, new Locale("es", "ES")));
    }

    private static class LocalDate {
        private final org.joda.time.LocalDate localDate;

        private LocalDate(final Calendar date) {
            localDate = org.joda.time.LocalDate.fromCalendarFields(date);
        }

        public static org.joda.time.LocalDate of(final int year, final int month, final int day) {
            final Calendar calendar = GregorianCalendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DATE, day);

            return new LocalDate(calendar).getLocalDate();
        }

        private org.joda.time.LocalDate getLocalDate() {
            return localDate;
        }
    }
}
