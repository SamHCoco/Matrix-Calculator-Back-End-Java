package com.matrix;

import java.util.Scanner;

public class Matrix {
    private int rowInput; // user input for number of rows
    private int columnInput; // user input for number of columns
    private int[][] createdMatrix; // the addedMatrix to be created from user input values
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
            this.createdMatrix = new int[rowInput][columnInput]; // size of addedMatrix based on user input
            System.out.println("Enter the values of Matrix " + this.name + " row by row:");
            for(int i = 0; i < createdMatrix.length; i++){
                for(int j = 0; j< createdMatrix[rowInput - 1].length; j++){
                        createdMatrix[i][j] = scanner.nextInt();
                }
            }
        }
        // displays result of user input
        getMatrix();
    }

    // DISPLAY USER SPECIFIED MATRIX TO USER
    public void getMatrix(){
        System.out.println("Matrix " + name + ": ");
        for(int i=0; i < createdMatrix.length; i++){
            for(int j=0; j < createdMatrix[rowInput - 1].length; j++){ // [rowInput - 1] since index starts at 0
                System.out.print(createdMatrix[i][j] + "\t");
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
            addedMatrix = new int[A.createdMatrix.length][B.createdMatrix.length]; // Will contain final result of calculation
            for(int i = 0; i < A.createdMatrix.length; i++){
                for(int j = 0; j < A.createdMatrix.length; j++){
                    addedMatrix[i][j] = A.createdMatrix[i][j] + B.createdMatrix[i][j];
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
            subtractedMatrix  = new int[a.createdMatrix.length][b.createdMatrix.length]; // Will contain final result of calculation
            for(int i = 0; i < a.createdMatrix.length; i++){
                for(int j = 0; j < a.createdMatrix.length; j++){
                    subtractedMatrix[i][j] = a.createdMatrix[i][j] - b.createdMatrix[i][j];
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
    public void calculateDeterminant(Matrix a){

    }

    // this method will return a double (this return will be needed for 3x3 determinants)
    public void calculate2x2Det(int[][] m){
        matrixDeterminant = m[1][1] * m[0][0] - m[1][0] * m[0][1];
    }


    public void calculate3x3Det(int[][] m){

    }

    public void extract2x2Matrix(){
        int iteration = 1;
        int[][] extractedMatrix = new int[2][2];
        System.out.println("\nEXTRACTED FROM MATRIX: " + name);
        do{
            for(int i = 0; i < createdMatrix.length - 1; i++ ){
                for(int j = 0; j < createdMatrix.length - 1; j++){
                    if(iteration == 1){
                        System.out.print(createdMatrix[i+1][j+1] + "\t");
                    }else if(iteration == 2){
                        if(j == 1){
                            System.out.print(createdMatrix[i+1][j+1] + "\t");
                        } else {
                            System.out.print(createdMatrix[i+1][j] + "\t");
                        }
                    } else if(iteration == 3){
                        System.out.print(createdMatrix[i+1][j] + "\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            iteration++;
        } while(iteration <= 3 );
    }

}

