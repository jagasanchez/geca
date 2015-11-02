/*
 * (c) 2015 - Jose A. Garcia Sanchez
 */
package org.jag.geca.web.convert;

import java.util.Locale;

import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

/**
 * @author jose
 */
public class LocalDateConverter implements IConverter<LocalDate> {
    private static final long serialVersionUID = -1063631053526819974L;

    @Override
    public LocalDate convertToObject(final String value, final Locale locale) throws ConversionException {
        return null;
    }

    @Override
    public String convertToString(final LocalDate date, final Locale locale) {
        return DateTimeFormat.forPattern("dd/MMM/yyyy").withLocale(locale).print(date);
    }
}