/*
 * (c) 2015 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.web.convert;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Locale;

import org.junit.Test;

/**
 * @author jose
 *
 */
public class LocalDateConverterTest {
    private LocalDateConverter underTest = new LocalDateConverter();

    @Test
    public void convertToString() {
        assertEquals("02/feb/1976", underTest.convertToString(LocalDate.of(1976, 2, 2), new Locale("es", "ES")));
    }

}
