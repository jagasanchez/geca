/*
 * (c) 2016 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.services;

import java.util.List;

import javax.ejb.Remote;

import org.jag.geca.model.taxdeclaration.Vacation;

/**
 * @author jose
 */
@Remote
public interface TaxDeclaration {
    List<Vacation> getVacations(int year);
}
