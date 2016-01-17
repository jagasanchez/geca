/*
 * (c) 2015 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.services;

import java.util.List;

import javax.ejb.Remote;

import org.jag.geca.model.Program;

/**
 * @author jose
 */
@Remote
public interface ProgramsService {

    /**
     * @return List of programs
     */
    List<Program> getPrograms();

}
