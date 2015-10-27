/*
 * (c) 2015 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.web.convert;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import javax.money.MonetaryAmount;

import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;

/**
 * @author jose
 *
 */
public class MonetaryAmountConverter implements IConverter<MonetaryAmount> {
    private static final long serialVersionUID = -4718680627765701501L;

    @Override
    public MonetaryAmount convertToObject(final String monetaryAmount, final Locale locale) throws ConversionException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String convertToString(final MonetaryAmount monetaryAmount, final Locale locale) {
        return new NumberFormatter().convertToString(monetaryAmount, locale);
    }

    private interface Formatter {
        String convertToString(final MonetaryAmount monetaryAmount, final Locale locale);
    }

    private static class NumberFormatter implements Formatter {

        @Override
        public String convertToString(final MonetaryAmount monetaryAmount, final Locale locale) {
            final NumberFormat formatter = NumberFormat.getNumberInstance(locale);
            formatter.setMaximumFractionDigits(2);
            formatter.setMinimumFractionDigits(2);
            formatter.setCurrency(Currency.getInstance(monetaryAmount.getCurrency().getCurrencyCode()));

            return String.format("%s %s", formatter.format(monetaryAmount.getNumber()),
                    monetaryAmount.getCurrency().getCurrencyCode());
        }

    }

    @SuppressWarnings("unused")
    private static class CurrencyFormatter implements Formatter {

        @Override
        public String convertToString(final MonetaryAmount monetaryAmount, final Locale locale) {
            final NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
            formatter.setMaximumFractionDigits(2);
            formatter.setMinimumFractionDigits(2);
            formatter.setCurrency(Currency.getInstance(monetaryAmount.getCurrency().getCurrencyCode()));

            return formatter.format(monetaryAmount);
        }
    }
}