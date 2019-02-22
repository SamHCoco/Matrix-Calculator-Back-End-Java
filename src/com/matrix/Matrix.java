package com.matrix;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Matrix {
    private int rows; // user input for number of rows
    private int columns; // user input for number of columns
    private double[][] matrix; // the addedMatrix to be created from user input values
    private String name; // The name of the addedMatrix e.g 'A', 'B' etc
    private double determinant;

    // Constructor
    public Matrix(String name, int rows, int columns){
        this.name = name;
        this.rows = rows;
        this.columns = columns;
        setMatrix(this.rows, this.columns);
        getMatrix();
    }

    // CREATES MATRIX FROM USER INPUT
    public void setMatrix(int rows, int columns){
        Scanner scanner = new Scanner(System.in);
        this.matrix = new double[rows][columns];
        System.out.println("Enter values of Matrix " + this.name + " row by row:");
        if(scanner.hasNextInt()){
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j< matrix[rows - 1].length; j++){
                    matrix[i][j] = scanner.nextInt();
                }
            }
        }
    }

    // DISPLAY USER SPECIFIED MATRIX TO USER
    public void getMatrix(){
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("Matrix " + name + ": ");
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[rows - 1].length; j++){ // [rows - 1] since index starts at 0
                String element = df.format(matrix[i][j]);
                System.out.printf("%8.3f",matrix[i][j]);
            }
            System.out.println();
        }
    }

    //                            MATRIX ADDITION METHOD
    public static void addMatrices(Matrix a, Matrix b){
        double[][] addedMatrix; // stores the result of addedMatrix addition
        if(a.rows == b.rows && a.columns == b.columns){
            addedMatrix = new double[a.matrix.length][b.matrix.length]; // Will contain final result of calculation
            for(int i = 0; i < a.matrix.length; i++){
                for(int j = 0; j < a.matrix.length; j++){
                    addedMatrix[i][j] = a.matrix[i][j] + b.matrix[i][j];
                }
            }
            System.out.println("ADDED MATRIX");
            displayResult(addedMatrix);
        } else {
            System.out.println("ADDITION ERROR: Matrix " + a.name + " and " + b.name + " must have same the dimensions.");
        }
    }

    //                                MATRIX SUBTRACTION
    public static void subtractMatrices(Matrix a, Matrix b){
        if(a.rows == b.rows && a.columns == b.columns){
            double[][] subtractedMatrix  = new double[a.matrix.length][b.matrix.length];

            for(int i = 0; i < a.matrix.length; i++){
                for(int j = 0; j < a.matrix.length; j++){
                    subtractedMatrix[i][j] = a.matrix[i][j] - b.matrix[i][j];
                }
            }
            System.out.println("SUBTRACTION RESULT: " + a.name + " - " + b.name);
            displayResult(subtractedMatrix);
        } else {
            System.out.println("SUBTRACTION ERROR: Matrix " + a.name +
                    " and " + b.name + " must have same the dimensions.");
        }
    }

    public static void displayResult(double[][] matrix){
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
        int size = findMatrixSize();
        switch(size){
            case 2:
                determinant = calculate2x2Det();
                System.out.println("\nMatrix " + name + " Determinant = " + determinant);
                break;
            case 3:
                determinant = calculate3x3Det();
                System.out.println("\nMatrix " + name + " Determinant = " + determinant);
                break;
        }
    }

    // this method will return a double (this return will be needed for 3x3 determinants)
    public double calculate2x2Det(){
        return matrix[1][1] * matrix[0][0] - matrix[1][0] * matrix[0][1];
    }

    public double calculate3x3Det(){
        double determinant = 0;
        ArrayList<Double[][]> minorMatrices = extract2x2Matrix();
        int element = 0;
        double[][] minorMatrix = new double[2][2];
        double[][] userMatrix = matrix;
        while(element < 3){
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 2; j++){
                    minorMatrix[i][j] = minorMatrices.get(element)[i][j];
                }
            }
            matrix = minorMatrix;
            determinant +=  Math.pow(-1, element + 2) * userMatrix[0][element] * calculate2x2Det();
            element++;
        }
        matrix = userMatrix;
        return determinant;
    }

    public int findMatrixSize(){
        if(rows == 2 && columns == 2){
            return 2;
        } else if(rows == 3 && columns == 3){
            return 3;
        }
        else {
            return -1;
        }
    }

    public ArrayList<Double[][]> extract2x2Matrix(){
        int iteration = 1;
        ArrayList<Double[][]> cofactorMatrices = new ArrayList<Double[][]>();
        do{
            Double[][] extractedMatrix = new Double[2][2];
            for(int i = 0; i < matrix.length - 1; i++ ){
                for(int j = 0; j < matrix.length - 1; j++){
                    if(iteration == 1){
                       extractedMatrix[i][j] = matrix[i+1][j+1];
                    }else if(iteration == 2){
                        if(j == 1){
                            extractedMatrix[i][j] = matrix[i+1][j+1];
                        } else {
                            extractedMatrix[i][j] = matrix[i+1][j];
                        }
                    } else if(iteration == 3){
                        extractedMatrix[i][j] = matrix[i+1][j];
                    }
                }
            }
            cofactorMatrices.add(extractedMatrix);
            iteration++;
        } while(iteration <= 3 );
    return cofactorMatrices;
    }

}

