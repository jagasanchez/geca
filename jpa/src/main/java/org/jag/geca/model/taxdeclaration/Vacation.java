/*
 * (c) 2016 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.model.taxdeclaration;

import java.io.Serializable;

import javax.persistence.Entity;

import org.joda.time.LocalDate;

/**
 * @author jose
 */
@Entity
public class Vacation implements Serializable {

    private LocalDate date;

    public LocalDate getVacation() {
        return date;
    }

    public void setVacation(final LocalDate date) {
        this.date = date;
    }

    public Vacation withVacation(final LocalDate date) {
        setVacation(date);
        return this;
    }
}
