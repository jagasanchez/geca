/*
 * (c) 2015 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.web;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.jag.geca.model.Program;
import org.jag.geca.services.ProgramsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jose
 */
public class Index extends WebPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(Index.class);
    @Inject
    private ProgramsService programsService;

    public Index() {
        final Model<? extends List<Program>> model = new Model<ArrayList<Program>>(new ArrayList<Program>());
        add(new ListView<Program>("programas", model) {

            @Override
            protected void populateItem(final ListItem<Program> item) {
                item.add(new Label("begin"));
                item.add(new Label("end"));
                item.add(new Label("name"));
                item.add(new Label("money"));
            }
        });
    }

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
        LOGGER.info("onRender(): programService: [{}]", programsService);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        LOGGER.info("onInitialize(): programService: [{}]", programsService);
        LOGGER.info("onInitialize(); programas: [{}]", programsService.getPrograms());
        LOGGER.info("[programas] = [{}]", programsService.getPrograms().size());
    }
}
