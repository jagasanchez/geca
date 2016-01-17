/*
 * (c) 2015 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.web;

import javax.ejb.EJB;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.jag.geca.model.Program;
import org.jag.geca.model.taxdeclaration.Vacation;
import org.jag.geca.services.ProgramsService;
import org.jag.geca.services.TaxDeclaration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jose
 */
public class Index extends WebPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(Index.class);
    @EJB
    private ProgramsService programsService;
    @EJB
    private TaxDeclaration taxDeclaration;

    public void setProgramsService(final ProgramsService programsService) {
        this.programsService = programsService;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.wicket.markup.html.WebPage#onRender()
     */
    @Override
    protected void onRender() {
        LOGGER.debug("onRender()");
        super.onRender();
        // final List<Program> programas = programsService.getPrograms();
        // add(new ListView<Program>("programas", programas) {
        // private static final long serialVersionUID = -3614296798789961770L;
        //
        // @Override
        // protected void populateItem(final ListItem<Program> item) {
        // LOGGER.info("Money: [{}]", item.getModelObject().getMoney());
        // System.out.println(String.format("Money: [%s]", item.getModelObject().getMoney()));
        // item.setModel(new CompoundPropertyModel<>(item.getModel()));
        // item.add(new Label("begin"));
        // item.add(new Label("end"));
        // item.add(new Label("name"));
        // item.add(new Label("money"));
        // }
        // });
    }

    @Override
    protected void onInitialize() {
        LOGGER.debug("onInitialize()");
        super.onInitialize();

        add(new ListView<Program>("programas", Model.ofList(programsService.getPrograms())) {

            @Override
            protected void populateItem(final ListItem<Program> item) {
                final IModel<Program> program = item.getModel();
                item.add(new Label("begin", new PropertyModel<>(program, "begin")));
                item.add(new Label("end", new PropertyModel<>(program, "end")));
                item.add(new Label("name", new PropertyModel<>(program, "name")));
                item.add(new Label("money", new PropertyModel<>(program, "money")));
            }
        });

        add(new ListView<Vacation>("vacations", Model.ofList(taxDeclaration.getVacations(2014))) {

            @Override
            protected void populateItem(final ListItem<Vacation> item) {
                item.setModel(new CompoundPropertyModel<>(item.getModelObject()));
                item.add(new Label("date"));
            }

        });
    }
}
