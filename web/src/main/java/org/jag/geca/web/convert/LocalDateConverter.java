/*
 * (c) 2015 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.web.convert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;

/**
 * @author jose
 *
 */
public class LocalDateConverter implements IConverter<LocalDate> {
    private static final long serialVersionUID = -1063631053526819974L;

    @Override
    public LocalDate convertToObject(final String value, final Locale locale) throws ConversionException {
        return null;
    }

    @Override
    public String convertToString(final LocalDate date, final Locale locale) {
        return date.format(DateTimeFormatter.ofPattern("dd/MMM/yyyy", locale));
    }
}