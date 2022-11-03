package com.eurotech.test.day07_testNG_intro;

import org.testng.annotations.Test;

public class FirstTestNGTest {


    @Test //This is an annotation, it means the method after this @Test is TestNG method
    public void  test1(){

        System.out.println("open the  Browser");
        System.out.println("First Test Case");
        System.out.println("closing Browser");
    }

    @Test

    public void test2(){

        System.out.println("Test Case 2");
    }
}
