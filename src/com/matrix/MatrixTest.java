package com.matrix;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MatrixTest {

    @org.junit.Test
    public void addMatrices() {
        Matrix A = new Matrix("A", 2, 2, false);
        Matrix B = new Matrix("B", 2, 2, false);

        double[][] a = new double[2][2];
        a[0][0] = 1 ;
        a[0][1] = 2;
        a[1][0] = 3;
        a[1][1] = 4;

        A.setMatrix(a);
        // B.setMatrix(a);

        // expected result
        double[][] exp = new double[2][2];
        exp[0][0] = 2.0;
        exp[0][1] = 4.0;
        exp[1][0] = 6.0;
        exp[1][1] = 8.0;
        double[][] result = Matrix.addMatrices(A, A);
        assertArrayEquals(result, exp);
    }

    @org.junit.Test
    public void subtractMatrices() {
    }

    @org.junit.Test
    public void scalarMultiply() {
    }

    @org.junit.Test
    public void calculateDeterminant() {
    }

    @org.junit.Test
    public void calculate2x2Det() {
    }

    @org.junit.Test
    public void calculate3x3Det() {
    }

    @org.junit.Test
    public void extract2x2Matrix() {
    }
}