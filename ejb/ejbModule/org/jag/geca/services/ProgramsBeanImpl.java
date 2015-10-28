/*
 * (c) 2015 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.money.Monetary;
import javax.persistence.Entity;

import org.jag.geca.model.Program;
import org.javamoney.moneta.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jose
 *
 */
@Entity
public class ProgramsBeanImpl implements ProgramsBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProgramsBeanImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see org.jag.geca.services.ProgramsBean#getPrograms()
     */
    @Override
    public List<Program> getPrograms() {
        LOGGER.info("getPrograms()");
        final List<Program> programs = new ArrayList<>();

        programs.add(new ProgramaBuilder().withFechaInicio(LocalDate.of(2015, 8, 28))
                .withFechaFin(LocalDate.of(2015, 8, 30)).withNombre("Boda de Joan Ramón y Carolin")
                .withMoney(BigDecimal.valueOf(12.34), "EUR").newInstance());
        programs.add(new ProgramaBuilder().withFechaInicio(LocalDate.of(2015, 10, 16))
                .withFechaFin(LocalDate.of(2015, 10, 18)).withNombre("Fin de semana en Viena")
                .withMoney(BigDecimal.valueOf(200), "EUR").newInstance());
        programs.add(new ProgramaBuilder().withFechaInicio(LocalDate.of(2015, 10, 23))
                .withFechaFin(LocalDate.of(2015, 10, 25)).withNombre("Fin de semana en Madrid").withMoney(null)
                .newInstance());
        programs.add(new ProgramaBuilder().withFechaInicio(LocalDate.of(2015, 11, 13))
                .withFechaFin(LocalDate.of(2015, 11, 15)).withNombre("Fin de semana en París")
                .withMoney(BigDecimal.valueOf(1234.56), "EUR").newInstance());

        LOGGER.info("programs: [{}]", programs);
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

        public ProgramaBuilder withFechaInicio(final LocalDate date) {
            programa.setBegin(date);
            return this;
        }

        public ProgramaBuilder withFechaFin(final LocalDate date) {
            programa.setEnd(date);
            return this;
        }
    }
}
