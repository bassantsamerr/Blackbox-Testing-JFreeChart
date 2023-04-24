package org.jfree.data.test;
import static org.junit.Assert.assertEquals;
import org.jfree.data.time.Quarter;
import org.junit.Test;

public class QuarterClassTest {
    Quarter quarter;

    private void arrange(Integer quart, Integer year) {
        quarter = new Quarter(quart, year);
    }

    private void arrange() {
        quarter = new Quarter();
    }
    @Test
    public void testQuarterDefaultCtor() {
        arrange();
        assertEquals(2023, quarter.getYear().getYear());
        assertEquals(2, quarter.getQuarter());
    }
    @Test
    public void testQuarterParamCtor1() {
        //arrange
        //int int
        arrange(2,2023);
        //assert
        assertEquals(2023, quarter.getYear().getYear());
        assertEquals(2, quarter.getQuarter());
    }
    @Test
    public void testQuarterParamCtor2() {
        //arrange
        //int int
        //year = 1900
        arrange(2,1900);
        //assert
        assertEquals(1900, quarter.getYear().getYear());
    }
    @Test
    public void testQuarterParamCtor3() {
        //arrange
        //int int
        //year = 9999
        arrange(2,9999);
        //assert
        assertEquals(9999, quarter.getYear().getYear());
    }
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testQuarterParamCtor4() {
        //arrange
        //int int
        //year < 1900
        arrange(2,1899);
    }
    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testQuarterParamCtor5() {
        //arrange
        //int int
        //year > 9999
        arrange(2,10000);
    }
    


}
