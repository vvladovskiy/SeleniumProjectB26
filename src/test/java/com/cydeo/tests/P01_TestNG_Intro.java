package com.cydeo.tests;

import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class P01_TestNG_Intro {

    @Test (priority = 2)
    public void testOnePlusFive() {
        System.out.println("testOnePlusFive is running!");
        assertEquals(1 + 5, 6);
    }

    @Test (priority = 1)
    public void testTenMinusFour() {
        System.out.println("testTenMinusFour is running!");
        assertEquals(10 - 4, 6);
    }

    @BeforeClass
    public void setUp() {
        System.out.println("-----> BeforeClass is running!");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("-----> AfterClass is running!");
    }

    @BeforeMethod
    public void setUpethod() {
        System.out.println("-----> BeforeMethod is running!");
    }

    @AfterMethod
    public void tearDownMethod() {
        System.out.println("-----> AfterMethod is running!");
}
}
