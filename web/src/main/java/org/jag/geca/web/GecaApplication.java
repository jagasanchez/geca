/*
 * (c) 2015 - Jose A. Garcia Sanchez
 */
package org.jag.geca.web;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

/**
 * @author jose
 */
public class GecaApplication extends WebApplication {

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return Index.class;
    }

    @Override
    public Session newSession(final Request request, final Response response) {
        return new GecaSession(request);
    }
}
