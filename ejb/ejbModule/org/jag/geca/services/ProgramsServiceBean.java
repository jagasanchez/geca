/*
 * (c) 2015 - Jose A. Garcia Sanchez
 */
package org.jag.geca.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.money.Monetary;

import org.jag.geca.model.Program;
import org.javamoney.moneta.Money;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jose
 */
@Stateless
public class ProgramsServiceBean implements ProgramsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProgramsServiceBean.class);

    /*
     * (non-Javadoc)
     *
     * @see org.jag.geca.services.ProgramsBean#getPrograms()
     */
    @Override
    public List<Program> getPrograms() {
        LOGGER.debug("getPrograms()");
        final List<Program> programs = new ArrayList<>();

        programs.add(new ProgramaBuilder().withFechaInicio(2015, Calendar.AUGUST, 28)
                .withFechaFin(2015, Calendar.AUGUST, 30).withNombre("Boda de Joan Ramón y Carolin")
                .withMoney(BigDecimal.valueOf(12.34), "EUR").newInstance());
        programs.add(new ProgramaBuilder().withFechaInicio(2015, Calendar.OCTOBER, 16)
                .withFechaFin(2015, Calendar.OCTOBER, 18).withNombre("Fin de semana en Viena")
                .withMoney(BigDecimal.valueOf(200), "EUR").newInstance());
        programs.add(new ProgramaBuilder().withFechaInicio(2015, Calendar.OCTOBER, 23)
                .withFechaFin(2015, Calendar.OCTOBER, 25).withNombre("Fin de semana en Madrid").withMoney(null)
                .newInstance());
        programs.add(new ProgramaBuilder().withFechaInicio(2015, Calendar.NOVEMBER, 13)
                .withFechaFin(2015, Calendar.NOVEMBER, 15).withNombre("Fin de semana en París")
                .withMoney(BigDecimal.valueOf(1234.56), "EUR").newInstance());

        return programs;
    }

    static class ProgramaBuilder {
        private final Program programa = new Program();

        public Program newInstance() {
            return programa;
        }

        public ProgramaBuilder withMoney(final Money money) {
            programa.setMoney(money);
            return this;
        }

        public ProgramaBuilder withMoney(final BigDecimal number, final String currency) {
            return withMoney(Money.of(number, Monetary.getCurrency(currency)));
        }

        public ProgramaBuilder withNombre(final String nombre) {
            programa.setName(nombre);
            return this;
        }

        public ProgramaBuilder withFechaInicio(final int year, final int month, final int dayOfMonth) {
            final LocalDate date = LocalDate.fromCalendarFields(new GregorianCalendar(year, month, dayOfMonth));
            programa.setBegin(date);
            return this;
        }

        public ProgramaBuilder withFechaFin(final int year, final int month, final int dayOfMonth) {
            final LocalDate date = LocalDate.fromCalendarFields(new GregorianCalendar(year, month, dayOfMonth));
            programa.setEnd(date);
            return this;
        }
    }
}
