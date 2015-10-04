package ua.yandex.shad.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0,-5.0,-1.0, 5.0, 2.045, 8.095, 5.01};
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 2.45;
        double actualResult = seriesAnalysis.average();
        assertEquals(expResult, actualResult, 0.00001);
        
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverage_Exception() {
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis();
        seriesAnalysis.average();
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {2.0, -2.0, 1.0, -1.5, 0.5,};
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.51657;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviation_Exception() {
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis();
        seriesAnalysis.deviation();
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {2.0, -2.0, 1.0, -1.5, 0.3, -3.5, 8};
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -3.5;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMin_Exception() {
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis();
        seriesAnalysis.min();
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {2.0, -2.0, 1.0, -1.5, 0.3, -3.5, 8};
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 8;
        double actualResult = seriesAnalysis.max();
        
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMax_Exception() {
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis();
        seriesAnalysis.max();
    }

    @Test
    public void testFindTempClosestToZero() {
        double[] temperatureSeries = {4.0, -12.0, 1.0, -1.56, 0.3, -3.5, 8};
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.3;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }
    
    @Test
    public void testFindTempClosestToZero_WithTheSameAbsValue() {
        double[] temperatureSeries = {7.3, -0.2, 12.0, -1.56, 0.2, -2.8, 4};
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.2;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZero_WithTheSameValue() {
        double[] temperatureSeries = {4.3, 0.1, 11.7, -3.92, 0.1, -1.9, 8};
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.1;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroWithZero_Element() {
        double[] temperatureSeries = {2.1, 5.5, -3.6, 0.0, 2, 13.521};
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals (expResult, actualResult, 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZero_Exception() {
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis();
        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToValue() {
        double[] temperatureSeries = {4.0, 4.2, 1.0, -1.56, 5.4, -3.5, 8.1};
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.4;
        double actualResult = seriesAnalysis.findTempClosestToValue(5);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValue_WithSameValueElements() {
        double[] temperatureSeries = {11.1, 9.0, 1.0, -3.96, 2.7, -1.7, 5.2};
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 9.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(9.0);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValue_WithTheSameTwoAbsValue() {
        double[] temperatureSeries = {7.48, -0.2, 7.32, -1.56, 0.2, 7.48, -2.8, 6.5};
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 7.48;
        double actualResult = seriesAnalysis.findTempClosestToValue(7.4);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValue_Exception() {
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis();
        seriesAnalysis.findTempClosestToValue(7);
    }

    @Test
    public void testFindTempsLessThen() {
        double[] temperatureSeries = {1.3, 5, 6.2, - 4.5, 2.99, 0.123, 4};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {1.3, -4.5, 2.99, 0.123};
        double[] actualResult = seriesAnalysis.findTempsLessThen(3.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThenException() {
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis();
        seriesAnalysis.findTempsLessThen(4.0);
    }

    @Test
    public void testFindTempsGreaterThen() {
        double[] temperatureSeries = {1.3, 5, 6.2, -4.5, 2.99, 0.123, 4, 12.7};
        TemperatureSeriesAnalysis seriesAnalysis =
        new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {5, 6.2, 4, 12.7};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(3.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThen_Exception() {
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis();
        seriesAnalysis.findTempsGreaterThen(4.0);
    }

    @Test
    public void testSummaryStatistics_Value() {
        double[] temperatureSeries = {1.0, -10.0, -1.0, 5.0, 60};
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics statistics = seriesAnalysis.summaryStatistics();
        double[] expResult = {11.0, Math.sqrt(624.4), -10.0, 60.0};
        double[] actualResult = {statistics.getAvgTemp(), 
        statistics.getDevTemp(), statistics.getMinTemp(), 
        statistics.getMaxTemp()};
        assertArrayEquals(expResult, actualResult, 0.0001);
    }

    @Test
    public void testAddTemps_EmptyArray(){
        double[] newTempSeries = {9.2, 5.8, -20.1};
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis();
        seriesAnalysis.addTemps(newTempSeries);
        double[] actualResult = seriesAnalysis.getTemperatureSeries();
        double[] expResult = {9.2, 5.8, -20.1};
        assertArrayEquals(expResult,actualResult,0.00001);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddTemps_WithAbsolutlyZero() {
        double[] newTempSeries = {2.5, -4.8, -276, 8.6};
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis();
        seriesAnalysis.addTemps(newTempSeries);
    }

    @Test
    public void testAddTemps_ExpendArray() {
        double[] newTempSeries = {1.0, -10.0, -1.0, 5.0, 60};
        double[] temperatureSeries = {9.2, 5.8, -20.1};
        TemperatureSeriesAnalysis seriesAnalysis = 
        new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.addTemps(newTempSeries);
        double[] actualResult = seriesAnalysis.getTemperatureSeries();
        double[] expResult = {9.2, 5.8, -20.1, 1.0, -10.0, -1.0, 5.0, 60, 0, 0, 0, 0};
        assertArrayEquals(expResult,actualResult,0.00001);
    }
}
