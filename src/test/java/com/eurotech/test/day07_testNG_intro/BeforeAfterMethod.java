package com.eurotech.test.day07_testNG_intro;

import org.testng.annotations.*;

public class BeforeAfterMethod {

   // run alfabetik siraya gore, numaralarda kucukten buyuge yapar
    @Test

    public void test1(){

        System.out.println("First Test Case");

    }
    //run once  before each @Test method
    @BeforeMethod

    public void setup(){

        System.out.println("opening the Browser");
    }
    //run once  after each @Test method
    @AfterMethod

    public void tearDown(){

        System.out.println("closing Browser");
    }

    @Test

    public void test2(){

        System.out.println("Test Case 2");
    }

    @Test
    public void test3(){
        System.out.println("Test Case 3");
    }

    @BeforeClass
    public  void SetupClass(){
        System.out.println("------BEFORE CLASS------");
        System.out.println("her class da bir defa calisir");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("------AFTER CLASS------");

    }

  //  @Test // @Ignore // yazdirmak istemedigimiz metodun onune yazilir.

    public void test4(){
        System.out.println("Ignore");
    }
}
