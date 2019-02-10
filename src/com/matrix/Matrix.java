package com.matrix;

import java.util.Scanner;

public class Matrix {
    private int rowInput; // user input for number of rows
    private int columnInput; // user input for number of columns
    private int[][] createdMatrix; // the matrix to be created from user input values
    private static int[][] addedMatrix; // stores the result of matrix addition
    private static int[][] subtractedMatrix; // stores the result of matrix subtraction
    private String name; // The name of the matrix e.g 'A', 'B' etc

    // Constructor
    public Matrix(String name){
        this.name = name;
    }

    // CREATES MATRIX FROM USER INPUT
    public void setMatrix(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter rows of matrix " + this.name + ": ");

        if(scanner.hasNextInt()) {
            rowInput = scanner.nextInt(); // User input for number of rows
            System.out.println("Enter columns of matrix " + this.name + ": ");
            columnInput = scanner.nextInt(); // Number of columns

            // Creates matrix and asks user to input values of matrix row by row
            this.createdMatrix = new int[rowInput][columnInput]; // size of matrix based on user input
            System.out.println("Enter the values of matrix " + this.name + " row by row:");
            for(int i = 0; i < this.createdMatrix.length; i++){
                for(int j = 0; j<this.createdMatrix[rowInput - 1].length; j++){
                    this.createdMatrix[i][j] = scanner.nextInt();
                }
            }
        }
        // displays result of user input
        this.getMatrix();
    }

    // DISPLAY USER SPECIFIED MATRIX TO USER
    public void getMatrix(){
        System.out.println("Matrix " + this.name + ": ");
        for(int i=0; i < this.createdMatrix.length; i++){
            for(int j=0; j < this.createdMatrix[rowInput - 1].length; j++){ // [rowInput - 1] since index starts at 0
                System.out.print(this.createdMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /*                            MATRIX ADDITION METHOD
           Matrices can only be added if they're the same size, which why the loop below is defined as it is.
           Matrix1 always has the same size as Matrix2
    */
    public static void addMatrices(Matrix A, Matrix B){
        if(A.rowInput == B.rowInput && A.columnInput == B.columnInput){
            addedMatrix  = new int[A.createdMatrix.length][B.createdMatrix.length]; // Will contain final result of calculation
            for(int i = 0; i < A.createdMatrix.length; i++){
                for(int j = 0; j < A.createdMatrix.length; j++){
                    addedMatrix[i][j] = A.createdMatrix[i][j] + B.createdMatrix[i][j];
                }
            }
            // DISPLAYS ADDED MATRICES TO THE USER
            System.out.println("ADDED MATRIX");
            for(int i=0; i < addedMatrix.length; i++){
                for(int j=0; j < addedMatrix.length; j++){
                    System.out.print(addedMatrix[i][j] + "\t");
                }
                System.out.println();
            }
        } else {
            System.out.println("ADDITION ERROR: Matrix " + A.name + " and " + B.name + " must have same the dimensions.");
        }
    }

    /*
                                    MATRIX SUBTRACTION
     */
    public static void subtractMatrices(Matrix A, Matrix B){
        if(A.rowInput == B.rowInput && A.columnInput == B.columnInput){
            subtractedMatrix  = new int[A.createdMatrix.length][B.createdMatrix.length]; // Will contain final result of calculation
            for(int i = 0; i < A.createdMatrix.length; i++){
                for(int j = 0; j < A.createdMatrix.length; j++){
                    subtractedMatrix[i][j] = A.createdMatrix[i][j] - B.createdMatrix[i][j];
                }
            }
            // DISPLAYS ADDED MATRIX TO THE USER
            System.out.println("SUBTRACTION RESULT: " + A.name + " - " + B.name);
            for(int i=0; i < subtractedMatrix.length; i++){
                for(int j=0; j < subtractedMatrix.length; j++){
                    System.out.print(subtractedMatrix[i][j] + "\t");
                }
                System.out.println();
            }
        } else {
            System.out.println("SUBTRACTION ERROR: Matrix " + A.name +
                    " and " + B.name + " must have same the dimensions.");
        }
    }
    /*
    Calculates the determinant of a matrix
     */
    public void calculateDeterminant(){

    }
}