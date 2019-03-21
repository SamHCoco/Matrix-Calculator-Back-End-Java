package com.matrix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
    private Matrix testMatrix3x3;
    private Matrix testMatrix2x2;

    @Before
    public void setup(){
        testMatrix3x3 = new Matrix("T3 (3x3 testing matrix)", 3, 3, true);
        testMatrix2x2 = new Matrix("T3 (2x2 testing matrix)", 2, 2, true);
        double[][] values3x3 = {{1.11, 2.22,  -3.338},
                                 {4.44, 5.55,  -6},
                                 {0,    7.77,  -8.88}};
        double[][] values2x2 = {{1.1111, 2.2222},
                                {3.3333, -4.4444}};
        testMatrix3x3.setMatrix(values3x3);
        testMatrix2x2.setMatrix(values2x2);
    }

    @Test
    public void addMatrices() {
        double[][] expectedResult = {{2.220, 4.440, -6.676},
                                     {8.880, 11.100, -12.000},
                                      {0.000, 15.540, -17.760}};
        assertArrayEquals(testMatrix3x3.addMatrices(testMatrix3x3), expectedResult);
    }

    @Test
    public void subtractMatrices() {
        double[][] expectedResult = {{0.000, 0.000, 0.000},
                                     {0.000, 0.000, 0.000},
                                     {0.000, 0.000, 0.000}};
        assertArrayEquals(testMatrix3x3.subtractMatrices(testMatrix3x3), expectedResult);
    }

    @Test
    public void scalarMultiply() {
        double[][] expectedResult = {{2.220, 4.440, -6.676},
                                     {8.880, 11.100, -12.000},
                                     {0.000, 15.540, -17.760}};
        assertArrayEquals(testMatrix3x3.scalarMultiply(2), expectedResult);
    }

    @Test
    public void dotProduct(){
        double[] vector = {1.1111, 2.2222, 3.3333};
        double expectedResult = 17.284;
        assertEquals(Matrix.dotProduct(vector, vector), expectedResult, 0);
    }

    @Test
    public void calculateDeterminant() {
        assertEquals(testMatrix3x3.calculateDeterminant(), -30.586, 0);
    }

    @Test
    public void calculate2x2Det() {
        assertEquals(testMatrix2x2.calculate2x2Det(true), -12.343, 0);
    }
    @Test
    public void calculate3x3Det() {
    }

    @Test
    public void extract2x2Matrix() {
    }
}
