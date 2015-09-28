/*
 * (c) 2015 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author jose
 */

@Entity
public class Programa implements Serializable {
    private static final long serialVersionUID = -731725373003891201L;

    @Id
    private long id;
    private String name;
    private LocalDate begin;
    private LocalDate end;

    @ElementCollection
    @CollectionTable
    private List<LineaPrograma> lineas = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(final LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(final LocalDate end) {
        this.end = end;
    }
}
