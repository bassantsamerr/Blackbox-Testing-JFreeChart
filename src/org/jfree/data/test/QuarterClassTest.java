package org.jfree.data.test;
import static org.junit.Assert.assertEquals;

import java.util.TimeZone;

import org.jfree.data.time.Quarter;
import org.jfree.data.time.Year;
import org.junit.Test;

public class QuarterClassTest {
    Quarter quarter;

    private void arrange(Integer quart, Integer year) {
        quarter = new Quarter(quart, year);
    }

    private void arrange() {
        quarter = new Quarter();
    }
    private void arrange(Integer quart, Year year) {
        quarter = new Quarter(quart, year);
    }
    private void arrange(java.util.Date time) {
        quarter = new Quarter(time);
    }
    private void arrange(java.util.Date time, java.util.TimeZone zone) {
        quarter = new Quarter(time,zone);
    }
    @Test
    public void testQuarterDefaultCtor() {
        arrange();
        assertEquals(2023, quarter.getYear().getYear());
        assertEquals(2, quarter.getQuarter());
    }
    //////////// 1st param Ctor int int ////////////
    @Test
    public void testQuarterParamCtorIntInt1() {
        //1900<=year<=9999 1<=quarter<=4
        //arrange
        arrange(2,2023);
        //assert
        assertEquals(2023, quarter.getYear().getYear());
        assertEquals(2, quarter.getQuarter());
    }
    @Test
    public void testQuarterParamCtorIntInt2() {
        //year = 1900
        //arrange
        arrange(2,1900);
        //assert
        assertEquals(1900, quarter.getYear().getYear());
    }
    @Test
    public void testQuarterParamCtorIntInt3() {
        //year = 9999
        //arrange
        arrange(2,9999);
        //assert
        assertEquals(9999, quarter.getYear().getYear());
    }
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testQuarterParamCtorIntInt4() {
        //year < 1900
        //arrange
        arrange(2,1899);
    }
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testQuarterParamCtorIntInt5() {
        //year > 9999
        //arrange
        arrange(2,10000);
    }
    @Test
    public void testQuarterParamCtorIntInt6() {
        //quarter = 1
        //arrange
        arrange(1,2002);
        assertEquals(1, quarter.getQuarter());
        
    }
    @Test
    public void testQuarterParamCtorIntInt7() {
        //quarter = 4
        //arrange
        arrange(4,2002);
        assertEquals(4, quarter.getQuarter());
        
    }
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testQuarterParamCtorIntInt8() {
        //quarter < 1
        //arrange
        arrange(0,2002);
        assertEquals(0, quarter.getQuarter());
    }
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testQuarterParamCtorIntInt9() {
        //quarter > 4
        //arrange
        arrange(5,2002);
        assertEquals(5, quarter.getQuarter());
    }
    //////////// 2nd param Ctor int Year ////////////
    @Test
    public void testQuarterParamCtorIntYear1() {
        //1900<=year<=9999 1<=quarter<=4
        //arrange
        Year year =new Year();//Creates a new Year, based on the current system date/time.
        arrange(2,year);
        //assert
        assertEquals(2023, quarter.getYear().getYear());
        assertEquals(2, quarter.getQuarter());
    }
    @Test
    public void testQuarterParamCtorIntYear2() {
        //year = 1900
        //arrange
        Year year =new Year(1999);
        arrange(2,year);
        //assert
        assertEquals(1999, quarter.getYear().getYear());
    }
    @Test
    public void testQuarterParamCtorIntYear3() {
        //year = 9999
        //arrange
        Year year =new Year(9999);
        arrange(2,year);
        //assert
        assertEquals(9999, quarter.getYear().getYear());
    }
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testQuarterParamCtorIntYear4() {
        //year < 1900
        //arrange
        Year year =new Year(1899);
        arrange(2,year);
        //assert
        assertEquals(1899, quarter.getYear().getYear());
    }
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testQuarterParamCtorIntYear5() {
        //year > 9999
        //arrange
        Year year =new Year(10000);
        arrange(2,year);
        //assert
        assertEquals(10000, quarter.getYear().getYear());
    }
    @Test
    public void testQuarterParamCtorIntYear6() {
        //quarter = 1
        //arrange
        Year year =new Year();
        arrange(1,year);
        //assert
        assertEquals(1, quarter.getQuarter());
    }
    @Test
    public void testQuarterParamCtorIntYear7() {
        //quarter = 4
        //arrange
        Year year =new Year();
        arrange(4,year);
        //assert
        assertEquals(4, quarter.getQuarter());
    }
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testQuarterParamCtorIntYear8() {
        //quarter < 1
        //arrange
        Year year =new Year();
        arrange(0,year);
        //assert
        assertEquals(0, quarter.getQuarter());
    }
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testQuarterParamCtorIntYear9() {
        //quarter > 4
        //arrange
        Year year =new Year();
        arrange(5,year);
        //assert
        assertEquals(5, quarter.getQuarter());
    }
    //////////// 2nd param Ctor java.util.Date time ////////////
    @Test
    public void testQuarterParamCtorDate1() {
        //current time
        //arrange
        java.util.Date time= new java.util.Date();
        arrange(time);
        //assert
        assertEquals(2023, quarter.getYear().getYear());
        assertEquals(2, quarter.getQuarter());
    }
    @Test
    public void testQuarterParamCtorDate2() {
        //year = 1900
        //arrange
        java.util.Date time= new java.util.Date(1900);
        arrange(time);
        //assert
        assertEquals(1900, quarter.getYear().getYear());
    }
    @Test
    public void testQuarterParamCtorDate3() {
        //year = 9999
        //arrange
        java.util.Date time= new java.util.Date(9999);
        arrange(time);
        //assert
        assertEquals(9999, quarter.getYear().getYear());
    }
    //////////// 3nd param Ctor java.util.Date time - java.util.TimeZone zone ////////////
    @Test
    public void testQuarterParamCtorDateZone1() {
        //current time
        //arrange
        java.util.Date time= new java.util.Date();
        TimeZone zone = TimeZone.getTimeZone("");
        arrange(time,zone);
        //assert
        assertEquals(2023, quarter.getYear().getYear());
        assertEquals(2, quarter.getQuarter());
    }
}