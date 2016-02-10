/*
 * (c) 2015 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.web;

import javax.ejb.EJB;

import org.jag.geca.services.ProgramsService;
import org.jag.geca.services.TaxDeclaration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jose
 */
public class Index extends BasePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(Index.class);
    @EJB
    private ProgramsService programsService;
    @EJB
    private TaxDeclaration taxDeclaration;

    public void setProgramsService(final ProgramsService programsService) {
        this.programsService = programsService;
    }

    @Override
    protected void onRender() {
        super.onRender();
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        // add(new ProgramsPanel("programsPanel"));
        // add(new VacationsPanel("vacationsPanel"));
    }
}
