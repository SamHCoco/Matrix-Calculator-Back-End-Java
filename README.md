# Matrix Calculator: Overview of Capabilities
This matrix class back-end command line matrix calculator written in Java.

To create matrix objects, use the following syntax:

* new Matrix(name, rows, columns);
 * **name** - The name of the matrix.
 * **rows** - The number of rows in the matrix.
 * **columns** - The number of columns in the matrix.

```Java
  // creates matrix instance
  Matrix matrixA = new Matrix("A", 3, 3);
```

Outlined below are the methods of this matrix class that may be used to perform various calculations on matrices, along with an overview of their syntax.

* **ADDITION:** Two matrices, **A** and **B**, can be added once both matrices are created as objects and their values inputted by the user.

```Java
  Matrix matrixA = new Matrix("A", 3, 3);
  Matrix matrixB = new Matrix("B", 3, 3);
// adds matrix A to matrix B (A + B)
  matrixA.addMatrix(matrixB);
```

* **MULTIPLCATION:** Using the **Naïve Matrix Multiplication** algorithm of summing products. As such, this calculator is **not recommended for large matrices**. Any appropriately sized matrices can be multiplied together.

```Java
  Matrix matrixA = new Matrix("A", 3, 2);
  Matrix matrixB = new Matrix("B", 2, 4);
// multiplies matrix A by matrix B, (A * B)
  matrixA.multiply(matrixB);
```

* **SCALAR MULTIPLCATION:** Any matrix, **B**, may be multiplied by a scalar value, *a*, to return *a* * **B**.

```Java
  Matrix matrixB = new Matrix("B", 3, 3);
  int a = 6;
// multiplies matrix B by scalar value a
  matrixB.scalarMultiply(a);

```

* **DETERMINANT:** Determinants of **2x2** and **3x3 matrices** may be calculated.

```Java
  Matrix matrixA = new Matrix("A", 3, 3);
// calculates the determinant of matrix A
  matrixA.calculateDeterminant();
```

* **DOT PRODUCT:** The dot product of two vectors may be calculated.

```Java
  double[] vector1 = {12.5, 6.3, -4.5};
  double[] vector2 = {-34.5, 23, 31.41};
// calculates the dot product of these two vectors
  Matrix.dotProduct(vector1, vector2);
```

## Precision of Results:
All key results, for example determinants, are given to 3 decimal places (D.P) of accuracy, where necessary. No rounding is used during calculations of the final result (to maintain result accuracy). Only the final result itself is given to 3 D.P.
