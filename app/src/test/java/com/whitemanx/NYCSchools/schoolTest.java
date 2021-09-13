package com.whitemanx.NYCSchools;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class schoolTest {

    @Test
    public void test() throws Exception {
        school test = new school();
        //test getters

        //test setters
        assertEquals(test.city,"UNKOWN");
       // assert(test.city,"UNKOWN");
    }

    @Test
    public void test2() throws Exception {
        school test2 = new school();
        //test getters

        //testing the setter
        String str1 = "Bronx";
        test2.setCity(str1);
        test2.getCity();

        assertEquals(str1,test2.getCity());
        // assert(test.city,"UNKOWN");
    }
    @Test
    public void test3() throws Exception {
        school test3 = new school();
        //test getters

        //testing the setter
        String str1 = "Bronx High School";
        test3.setName(str1);
        test3.getName();

        assertEquals(str1,test3.getName());
        // assert(test.city,"UNKOWN");
    }


    @Test
    public void test4() throws Exception {
        school test4 = new school();
        //test getters

        //testing the setter
        String str1 = "333";
        test4.setMath(str1);
        test4.getMath();

        assertEquals(str1,test4.getMath());
        // assert(test.city,"UNKOWN");
    }

}
