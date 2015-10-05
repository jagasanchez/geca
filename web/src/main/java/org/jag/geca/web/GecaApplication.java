/*
 * (c) 2015 - Jose A. Garcia Sanchez
 */
package org.jag.geca.web;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

import javax.money.MonetaryAmount;

import org.apache.wicket.ConverterLocator;
import org.apache.wicket.IConverterLocator;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;
import org.jag.geca.web.convert.LocalDateConverter;

/**
 * @author jose
 */
public class GecaApplication extends WebApplication {

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return Index.class;
    }

    @Override
    public Session newSession(final Request request, final Response response) {
        return new GecaSession(request);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.wicket.Application#newConverterLocator()
     */
    @Override
    protected IConverterLocator newConverterLocator() {
        final ConverterLocator converterLocator = new ConverterLocator();

        converterLocator.set(LocalDate.class, new LocalDateConverter());

        converterLocator.set(MonetaryAmount.class, new IConverter<MonetaryAmount>() {
            private static final long serialVersionUID = -4718680627765701501L;

            @Override
            public MonetaryAmount convertToObject(final String monetaryAmount, final Locale locale)
                    throws ConversionException {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String convertToString(final MonetaryAmount monetaryAmount, final Locale locale) {
                final NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
                return formatter.format(monetaryAmount.getNumber().doubleValue());
            }
        });

        return converterLocator;
    }
}
