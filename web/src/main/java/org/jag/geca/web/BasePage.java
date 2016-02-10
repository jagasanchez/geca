/*
 * (c) 2016 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.jag.geca.web.tax.VacationsPage;

/**
 * @author jose
 *
 */
public class BasePage extends WebPage {

    private static final Map<Class<? extends BasePage>, String> menuOptionsTaxDeclaration = new HashMap<>();

    static {
        menuOptionsTaxDeclaration.put(VacationsPage.class, "application.menu.taxDeclaration.vacations");
        // menuOptionsTaxDeclaration.put(null, "application.menu.taxDeclaration.publicTransport");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        final List<Class<? extends BasePage>> menuOptionKeys = new ArrayList<>(menuOptionsTaxDeclaration.keySet());

        final ListView<Class<? extends BasePage>> taxDeclarationMenu = new ListView<Class<? extends BasePage>>(
                "taxDeclarationMenu", Model.ofList(menuOptionKeys)) {

            @Override
            protected void populateItem(final ListItem<Class<? extends BasePage>> item) {
                final Class<? extends BasePage> menuOptionPageClass = item.getModelObject();
                final BookmarkablePageLink<String> bookmarkablePageLink = new BookmarkablePageLink<String>("link",
                        menuOptionPageClass);
                bookmarkablePageLink
                        .add(new Label("menuOption", getString(menuOptionsTaxDeclaration.get(menuOptionPageClass))));
                item.add(bookmarkablePageLink);
            }
        };
        add(taxDeclarationMenu);
    }
}
