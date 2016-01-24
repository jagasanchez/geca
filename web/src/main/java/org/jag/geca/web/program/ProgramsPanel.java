/*
 * (c) 2016 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.web.program;

import javax.ejb.EJB;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.jag.geca.model.Program;
import org.jag.geca.services.ProgramsService;

/**
 * @author jose
 *
 */
public class ProgramsPanel extends Panel {

    @EJB
    private ProgramsService programsService;

    public ProgramsPanel(final String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new ListView<Program>("programs", Model.ofList(programsService.getPrograms())) {

            @Override
            protected void populateItem(final ListItem<Program> item) {
                final IModel<Program> program = item.getModel();
                item.add(new Label("begin", new PropertyModel<>(program, "begin")));
                item.add(new Label("end", new PropertyModel<>(program, "end")));
                item.add(new Label("name", new PropertyModel<>(program, "name")));
                item.add(new Label("money", new PropertyModel<>(program, "money")));
            }
        });
    }
}
