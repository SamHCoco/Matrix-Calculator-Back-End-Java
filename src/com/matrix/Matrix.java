package com.matrix;

import java.util.ArrayList;
import java.util.Scanner;

public class Matrix {
    private int rowInput; // user input for number of rows
    private int columnInput; // user input for number of columns
    private int[][] matrix; // the addedMatrix to be created from user input values
    private String name; // The name of the addedMatrix e.g 'A', 'B' etc
    private double matrixDeterminant;

    // Constructor
    public Matrix(String name){
        this.name = name;
    }

    // CREATES MATRIX FROM USER INPUT
    public void setMatrix(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter rows of Matrix " + this.name + ": ");

        if(scanner.hasNextInt()) {
            rowInput = scanner.nextInt(); // User input for number of rows
            System.out.println("Enter columns of Matrix " + this.name + ": ");
            columnInput = scanner.nextInt(); // Number of columns

            // Creates addedMatrix and asks user to input values of addedMatrix row by row
            this.matrix = new int[rowInput][columnInput]; // size of addedMatrix based on user input
            System.out.println("Enter the values of Matrix " + this.name + " row by row:");
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j< matrix[rowInput - 1].length; j++){
                        matrix[i][j] = scanner.nextInt();
                }
            }
        }
        // displays result of user input
        getMatrix();
    }

    // DISPLAY USER SPECIFIED MATRIX TO USER
    public void getMatrix(){
        System.out.println("Matrix " + name + ": ");
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[rowInput - 1].length; j++){ // [rowInput - 1] since index starts at 0
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /*                            MATRIX ADDITION METHOD
           Matrices can only be added if they're the same size, which why the loop below is defined as it is.
           Matrix1 always has the same size as Matrix2
    */
    public static void addMatrices(Matrix A, Matrix B){
        int[][] addedMatrix; // stores the result of addedMatrix addition
        if(A.rowInput == B.rowInput && A.columnInput == B.columnInput){
            addedMatrix = new int[A.matrix.length][B.matrix.length]; // Will contain final result of calculation
            for(int i = 0; i < A.matrix.length; i++){
                for(int j = 0; j < A.matrix.length; j++){
                    addedMatrix[i][j] = A.matrix[i][j] + B.matrix[i][j];
                }
            }
            System.out.println("ADDED MATRIX");
            displayResult(addedMatrix);
        } else {
            System.out.println("ADDITION ERROR: Matrix " + A.name + " and " + B.name + " must have same the dimensions.");
        }
    }

    /*
                                    MATRIX SUBTRACTION
     */
    public static void subtractMatrices(Matrix a, Matrix b){
        int[][] subtractedMatrix; // stores the result of addedMatrix subtraction
        if(a.rowInput == b.rowInput && a.columnInput == b.columnInput){
            subtractedMatrix  = new int[a.matrix.length][b.matrix.length]; // Will contain final result of calculation
            for(int i = 0; i < a.matrix.length; i++){
                for(int j = 0; j < a.matrix.length; j++){
                    subtractedMatrix[i][j] = a.matrix[i][j] - b.matrix[i][j];
                }
            }
            // DISPLAYS ADDED MATRIX TO THE USER
            System.out.println("SUBTRACTION RESULT: " + a.name + " - " + b.name);
            displayResult(subtractedMatrix);
        } else {
            System.out.println("SUBTRACTION ERROR: Matrix " + a.name +
                    " and " + b.name + " must have same the dimensions.");
        }
    }

    public static void displayResult(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    /*
    Calculates the determinant of a addedMatrix
     */
    public void calculateDeterminant(){
        int whichDeterminant = findMatrixSize();
        switch(whichDeterminant){
            case 2:
                calculate2x2Det();
                break;
        }

    }

    // this method will return a double (this return will be needed for 3x3 determinants)
    public void calculate2x2Det(){
        matrixDeterminant = matrix[1][1] * matrix[0][0] - matrix[1][0] * matrix[0][1];
    }


    public int findMatrixSize(){
        if(rowInput == 2 && columnInput == 2){
            return 2;
        } else if(rowInput == 3 && columnInput == 3){
            return 3;
        }
        else {
            return -1;
        }
    }

    public void extract2x2Matrix(){
        int iteration = 1;
        ArrayList<Integer[][]> cofactorMatrices = new ArrayList<Integer[][]>();
        System.out.println("\nEXTRACTED FROM MATRIX: " + name);
        do{
            Integer[][] extractedMatrix = new Integer[2][2];
            for(int i = 0; i < matrix.length - 1; i++ ){
                for(int j = 0; j < matrix.length - 1; j++){
                    if(iteration == 1){
                       extractedMatrix[i][j] = matrix[i+1][j+1];
                    }else if(iteration == 2){
                        if(j == 1){
                            System.out.print(matrix[i+1][j+1] + "\t");
                        } else {
                            System.out.print(matrix[i+1][j] + "\t");
                        }
                    } else if(iteration == 3){
                        System.out.print(matrix[i+1][j] + "\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            cofactorMatrices.add(extractedMatrix);
            iteration++;
        } while(iteration <= 3 );
    }

}

