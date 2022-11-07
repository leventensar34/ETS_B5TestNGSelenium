package com.eurotech.test.day07_testNG_intro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationsDemo {


    /*
    Assert :this is the class in the TestNG, it has methods used to
    do assertion like when compare values.
     */
    @Test
    public void test1(){

        System.out.println("First Assertion");
        Assert.assertEquals("Title","Title"); // caseSensitive

        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");

    }

    @Test
    public void test3(){
        String expected="Euro";
        String actual="Eurotech";

        Assert.assertTrue(actual.startsWith(expected));
        Assert.assertTrue(actual.startsWith(expected),"verify that title starting Euro");
       // Assert.assertFalse(actual.startsWith(expected)); // false doner. Negatif testler icin kullanilir.

    }
    @Test
    public void test4(){

       String email="eurotech@gmail.com";

//        if (email.contains("@")){
//            System.out.println("Pass");
//        }else {
//            System.out.println("Filed");
//        }

        Assert.assertTrue(email.contains("@"));
    }

    @Test
    public void test5(){
        Assert.assertFalse(0<1,"verify that 0 is not greater than 1");

        // true --> actual (condition)
        // false --> expected (assertion)
        // test result FAILED

        Assert.assertFalse(0>1,"verify that 0 is not greater than 1");

        // false --> actual (condition)
        // true--> expected (assertion)
        // test result PASS
    }

    @Test
    public void test6(){

        Assert.assertNotEquals("two","two");
        // expected:false
        // actual : true
        //test : FAILED

        Assert.assertNotEquals("two","one");

        // expected:false
        // actual : false
        //test : PASS
    }
    @Test
    public  void test2(){

        Assert.assertEquals("test2","test2");
    }

    @BeforeMethod
    public void setup(){
        System.out.println("Open the Browser");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing Browser");
    }

}
