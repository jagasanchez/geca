/*
 * (c) 2015 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.web;

import java.util.Locale;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

/**
 * @author jose
 */
public class GecaSession extends WebSession {

    private static final long serialVersionUID = 4364169528468823902L;

    public GecaSession(final Request request) {
        super(request);
        setLocale(new Locale("es", "ES"));
    }
}
