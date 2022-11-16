package com.eurotech.test.day14_propertiesSingleton;

public class Singleton {

    // singleton class will have private constructor
    //it means classes can NOT create an object of thtis class

    private  Singleton(){


    }

    private static String str;

    public static String getInstance(){

        if (str==null){
            System.out.println("str isi null, assigning a value to it");
            str="some value";
        }else {
            System.out.println("it has value, just returning it");
        }



        return str;
    }
}
