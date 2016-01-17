/*
 * (c) 2016 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import org.jag.geca.model.taxdeclaration.Vacation;
import org.joda.time.LocalDate;

/**
 * @author jose
 *
 */
@Stateless
public class TaxDeclarationBean implements TaxDeclaration {

    /** @deprecated To be replace by database */
    private static final Map<Integer, List<Vacation>> allVacations = new HashMap<>();

    static {
        final List<Vacation> vacations2014 = new ArrayList<>();
        vacations2014.add(new Vacation()
                .withVacation(LocalDate.fromCalendarFields(new GregorianCalendar(2014, Calendar.NOVEMBER, 13))));
        vacations2014.add(new Vacation()
                .withVacation(LocalDate.fromCalendarFields(new GregorianCalendar(2014, Calendar.DECEMBER, 24))));
        vacations2014.add(new Vacation()
                .withVacation(LocalDate.fromCalendarFields(new GregorianCalendar(2014, Calendar.DECEMBER, 28))));
        vacations2014.add(new Vacation()
                .withVacation(LocalDate.fromCalendarFields(new GregorianCalendar(2014, Calendar.DECEMBER, 29))));
        vacations2014.add(new Vacation()
                .withVacation(LocalDate.fromCalendarFields(new GregorianCalendar(2014, Calendar.DECEMBER, 30))));
        vacations2014.add(new Vacation()
                .withVacation(LocalDate.fromCalendarFields(new GregorianCalendar(2014, Calendar.DECEMBER, 31))));

        allVacations.put(2014, vacations2014);
    }

    @Override
    public List<Vacation> getVacations(final int year) {
        final List<Vacation> vacations = allVacations.get(year);

        return vacations;
    }
}
