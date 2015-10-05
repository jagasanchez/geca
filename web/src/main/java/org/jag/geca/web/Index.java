/*
 * (c) 2015 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.web;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.money.Monetary;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.jag.geca.model.Programa;
import org.javamoney.moneta.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jose
 */
public class Index extends WebPage {

    private static final long serialVersionUID = -7372625702062773100L;
    private static final Logger LOGGER = LoggerFactory.getLogger(Index.class);

    public Index() {
        add(new ListView<Programa>("programas", getProgramas()) {
            private static final long serialVersionUID = -3614296798789961770L;

            @Override
            protected void populateItem(final ListItem<Programa> item) {
                LOGGER.info("Money: [{}]", item.getModelObject().getMoney());
                System.out.println(String.format("Money: [%s]", item.getModelObject().getMoney()));
                item.setModel(new CompoundPropertyModel<>(item.getModel()));
                item.add(new Label("begin"));
                item.add(new Label("end"));
                item.add(new Label("name"));
                item.add(new Label("money"));
            }
        });
    }

    private List<Programa> getProgramas() {
        final List<Programa> programas = new ArrayList<>();

        programas.add(new ProgramaBuilder().withFechaInicio(LocalDate.of(2015, 8, 28))
                .withFechaFin(LocalDate.of(2015, 8, 30)).withNombre("Boda de Joan Ramón y Carolin")
                .withMoney(BigDecimal.valueOf(12.34), "EUR").newInstance());
        programas.add(new ProgramaBuilder().withFechaInicio(LocalDate.of(2015, 10, 16))
                .withFechaFin(LocalDate.of(2015, 10, 18)).withNombre("Fin de semana en Viena")
                .withMoney(BigDecimal.valueOf(200), "EUR").newInstance());
        programas.add(new ProgramaBuilder().withFechaInicio(LocalDate.of(2015, 10, 23))
                .withFechaFin(LocalDate.of(2015, 10, 25)).withNombre("Fin de semana en Madrid")
                .withMoney(BigDecimal.valueOf(200.01), "EUR").newInstance());
        programas.add(new ProgramaBuilder().withFechaInicio(LocalDate.of(2015, 11, 13))
                .withFechaFin(LocalDate.of(2015, 11, 15)).withNombre("Fin de semana en París")
                .withMoney(BigDecimal.valueOf(1234.56), "EUR").newInstance());
        return programas;
    }

    static class ProgramaBuilder {
        private final Programa programa = new Programa();

        public Programa newInstance() {
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
