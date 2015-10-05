/*
 * (c) 2015 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.web.convert;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;

/**
 * @author jose
 */
@RunWith(JUnitParamsRunner.class)
public class LocalDateConverterTest {
    private LocalDateConverter underTest = new LocalDateConverter();

    public Object[] conversionFechas() {
        // @formatter:off
        return new Object[][] {
            {LocalDate.of(1900, 1, 1), "01/ene/1900"},
            {LocalDate.of(1950, 2, 2), "02/feb/1950"},
            {LocalDate.of(1975, 3, 3), "03/mar/1975"},
            {LocalDate.of(2000, 4, 4), "04/abr/2000"},
            {LocalDate.of(2000, 2, 29), "29/feb/2000"},
            {LocalDate.of(2005, 5, 5), "05/may/2005"},
            {LocalDate.of(2006, 6, 10), "10/jun/2006"},
            {LocalDate.of(2007, 7, 14), "14/jul/2007"},
            {LocalDate.of(2008, 8, 21), "21/ago/2008"},
            {LocalDate.of(2009, 9, 23), "23/sep/2009"},
            {LocalDate.of(2010, 10, 26), "26/oct/2010"},
            {LocalDate.of(2012, 11, 28), "28/nov/2012"},
            {LocalDate.of(2014, 12, 31), "31/dic/2014"}
        };
        // @formatter:on
    }

    @Test
    @Parameters(method = "conversionFechas")
    @TestCaseName("For [{0}] is expected [{1}]")
    public void convertToString(final LocalDate date, final String expectedFormattedDate) {
        assertEquals(expectedFormattedDate, underTest.convertToString(date, new Locale("es", "ES")));
    }

}
