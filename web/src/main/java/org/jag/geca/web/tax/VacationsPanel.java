/*
 * (c) 2016 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.web.tax;

import javax.ejb.EJB;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.jag.geca.model.taxdeclaration.Vacation;
import org.jag.geca.services.TaxDeclaration;

/**
 * @author jose
 *
 */
public class VacationsPanel extends Panel {

    @EJB
    private TaxDeclaration taxDeclaration;

    public VacationsPanel(final String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new ListView<Vacation>("vacations", Model.ofList(taxDeclaration.getVacations(2015))) {

            @Override
            protected void populateItem(final ListItem<Vacation> item) {
                item.setModel(new CompoundPropertyModel<>(item.getModelObject()));
                item.add(new Label("date"));
            }
        });
    }
}
