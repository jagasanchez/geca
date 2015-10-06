/*
 * (c) 2015 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.web.convert;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

import org.javamoney.moneta.Money;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

/**
 * @author jose
 */
@RunWith(JUnitParamsRunner.class)
public class MonetaryAmountConverterTest {
    private static final Locale ES = new Locale("es", "ES");
    private static final BigDecimal AMOUNT = BigDecimal.valueOf(1234.56);
    private static final BigDecimal AMOUNT_1DECIMAL = BigDecimal.valueOf(1234.5);
    private static final BigDecimal AMOUNT_4DECIMALS = BigDecimal.valueOf(1234.5678);
    private static final BigDecimal AMOUNT_4DECIMALS_NOROUND = BigDecimal.valueOf(1234.5643);
    private static final BigDecimal AMOUNT_MILLION = BigDecimal.valueOf(1234567.89);
    private static final CurrencyUnit EUR = Monetary.getCurrency("EUR");
    private static final CurrencyUnit USD = Monetary.getCurrency("USD");

    private MonetaryAmountConverter underTest = new MonetaryAmountConverter();

    // @formatter:off
    public Object[] inputDataAndExpectation() {
        return new Object[][] {
            // ES
            { AMOUNT, EUR, ES, "1.234,56 EUR" },
            { AMOUNT_1DECIMAL, EUR, ES, "1.234,50 EUR" },
            { AMOUNT_4DECIMALS, EUR, ES, "1.234,57 EUR" },
            { AMOUNT_4DECIMALS_NOROUND, EUR, ES, "1.234,56 EUR" },
            { AMOUNT_MILLION, EUR, ES, "1.234.567,89 EUR" },
            { AMOUNT, USD, ES, "1.234,56 USD" },
            { AMOUNT_1DECIMAL, USD, ES, "1.234,50 USD" },
            { AMOUNT_4DECIMALS, USD, ES, "1.234,57 USD" },
            { AMOUNT_4DECIMALS_NOROUND, USD, ES, "1.234,56 USD" },
            { AMOUNT_MILLION, USD, ES, "1.234.567,89 USD" },
            
            // US
            { AMOUNT, EUR, Locale.US, "1,234.56 EUR" },
            { AMOUNT_1DECIMAL, EUR, Locale.US, "1,234.50 EUR" },
            { AMOUNT_4DECIMALS, EUR, Locale.US, "1,234.57 EUR" },
            { AMOUNT_4DECIMALS_NOROUND, EUR, Locale.US, "1,234.56 EUR" },
            { AMOUNT_MILLION, EUR, Locale.US, "1,234,567.89 EUR" },
            { AMOUNT, USD, Locale.US, "1,234.56 USD" },
            { AMOUNT_1DECIMAL, USD, Locale.US, "1,234.50 USD" },
            { AMOUNT_4DECIMALS, USD, Locale.US, "1,234.57 USD" },
            { AMOUNT_4DECIMALS_NOROUND, USD, Locale.US, "1,234.56 USD" },
            { AMOUNT_MILLION, USD, Locale.US, "1,234,567.89 USD" }
        };
    }
    // @formatter:on

    @Test
    @Parameters(method = "inputDataAndExpectation")
    public void convertToString(final BigDecimal amount, final CurrencyUnit currency, final Locale locale,
            final String expected) {
        assertEquals(expected, underTest.convertToString(Money.of(amount, currency), locale));
    }
}
