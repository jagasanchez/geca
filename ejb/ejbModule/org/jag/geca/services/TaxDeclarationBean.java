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

        allVacations.put(2015, vacations2015());
        allVacations.put(2016, vacations2016());
    }

    private static List<Vacation> vacations2015() {
        final int year = 2015;
        final List<Vacation> vacations = new ArrayList<>();
        vacations.add(new Vacation()
                .withVacation(LocalDate.fromCalendarFields(new GregorianCalendar(year, Calendar.NOVEMBER, 13))));
        vacations.add(new Vacation()
                .withVacation(LocalDate.fromCalendarFields(new GregorianCalendar(year, Calendar.DECEMBER, 24))));
        vacations.add(new Vacation()
                .withVacation(LocalDate.fromCalendarFields(new GregorianCalendar(year, Calendar.DECEMBER, 28))));
        vacations.add(new Vacation()
                .withVacation(LocalDate.fromCalendarFields(new GregorianCalendar(year, Calendar.DECEMBER, 29))));
        vacations.add(new Vacation()
                .withVacation(LocalDate.fromCalendarFields(new GregorianCalendar(year, Calendar.DECEMBER, 30))));
        vacations.add(new Vacation()
                .withVacation(LocalDate.fromCalendarFields(new GregorianCalendar(year, Calendar.DECEMBER, 31))));

        return vacations;
    }

    private static List<Vacation> vacations2016() {
        final int year = 2016;
        final List<Vacation> vacations = new ArrayList<>();

        vacations.add(new Vacation()
                .withVacation(LocalDate.fromCalendarFields(new GregorianCalendar(year, Calendar.JANUARY, 4))));
        vacations.add(new Vacation()
                .withVacation(LocalDate.fromCalendarFields(new GregorianCalendar(year, Calendar.JANUARY, 5))));
        vacations.add(new Vacation()
                .withVacation(LocalDate.fromCalendarFields(new GregorianCalendar(year, Calendar.JANUARY, 7))));
        vacations.add(new Vacation()
                .withVacation(LocalDate.fromCalendarFields(new GregorianCalendar(year, Calendar.FEBRUARY, 1))));
        vacations.add(new Vacation()
                .withVacation(LocalDate.fromCalendarFields(new GregorianCalendar(year, Calendar.FEBRUARY, 2))));
        vacations.add(new Vacation()
                .withVacation(LocalDate.fromCalendarFields(new GregorianCalendar(year, Calendar.FEBRUARY, 3))));

        return vacations;
    }

    @Override
    public List<Vacation> getVacations(final int year) {
        final List<Vacation> vacations = allVacations.get(year);

        return vacations;
    }
}
