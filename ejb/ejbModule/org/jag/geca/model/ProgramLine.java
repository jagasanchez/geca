/*
 * (c) 2015 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.money.MonetaryAmount;
import javax.persistence.Entity;

/**
 * @author jose
 */
@Entity
public class ProgramLine implements Serializable {
    private static final long serialVersionUID = 8624144506616336091L;

    private LocalDate date;
    private String detail;
    private MonetaryAmount amount;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(final String detail) {
        this.detail = detail;
    }

    public MonetaryAmount getAmount() {
        return amount;
    }

    public void setAmount(final MonetaryAmount amount) {
        this.amount = amount;
    }
}
