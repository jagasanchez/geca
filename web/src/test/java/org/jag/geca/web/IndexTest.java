/*
 * (c) 2015 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.web;

import static org.junit.Assert.fail;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author jose
 *
 */
public class IndexTest {

    private static WicketTester tester;

    @BeforeClass
    public static void setUpFirst() {
        tester = new WicketTester();
    }

    @AfterClass
    public static void tearDownClass() {
        tester.destroy();
    }

    @Test
    public void render() {
        tester.startComponentInPage(new Index());
        tester.dumpPage();
        fail("Not yet implemented");
    }

}
