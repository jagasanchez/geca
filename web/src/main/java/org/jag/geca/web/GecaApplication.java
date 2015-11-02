/*
 * (c) 2015 - Jose A. Garcia Sanchez
 */
package org.jag.geca.web;

import org.apache.wicket.ConverterLocator;
import org.apache.wicket.IConverterLocator;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.jag.geca.web.convert.LocalDateConverter;
import org.jag.geca.web.convert.MonetaryAmountConverter;
import org.javamoney.moneta.Money;
import org.joda.time.LocalDate;

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
        converterLocator.set(Money.class, new MonetaryAmountConverter());

        return converterLocator;
    }
}
