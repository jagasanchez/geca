/*
 * (c) 2016 - Jose A. Garcia Sanchez 
 */
package org.jag.geca.web.tax;

import static org.junit.Assert.fail;

import org.apache.wicket.util.tester.WicketTester;
import org.jag.geca.web.GecaApplication;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author jose
 *
 */
public class VacationsPanelTest {
    private static WicketTester tester;
    private VacationsPanel underTest;

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        tester = new WicketTester(new GecaApplication());
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        underTest = new VacationsPanel("panel");
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void render() {
        tester.startComponentInPage(underTest);
        fail("Not yet implemented");
    }

}
