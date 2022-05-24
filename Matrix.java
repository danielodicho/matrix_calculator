import java.util.Scanner;
import java.util.ArrayList;

public class Matrix extends Object
  {
    //add other instance variables as you see fit
    public double[][] vals;
    private int nr;
    int nc;
    // precondition: nr > 0, nc > 0
    public Matrix(int nr1, int nc1, double fillVal)
    {
      nr = nr1; 
        nc = nc1;
      vals = new double[nr][nc];
    }
    // r = y
    // c = x
    // [[x,x,x] 
    //  [y,y,y]    ]

    
    // precondition: x != null
    //postcondition: no values within x were changed
    //postcondition: vals does not refer to the memory referenced by x
    public Matrix(double[][] x)
    {
      vals = x;
    }

    
    public Matrix(String fileName)
    {
      Scanner in = new Scanner(Matrix.class.getResourceAsStream(fileName));
      this.nr = in.nextInt();
      this.nc = in.nextInt();
      
      Matrix m1 = new Matrix(nr, nc);
       for (int r = 0; r < nr; r++ ){
          for (int c = 0; c < nc; c++){
             m1.vals[r][c] = in.nextDouble();
            }
          }
      this.vals= m1.vals;
        }  
    



    // this method is complete, no need to do anything
    // precondition: nr > 0, nc > 0
    public Matrix(int nr, int nc)
    {
      this(nr, nc, 0.0);
    }

    
    // this method is complete, no need to do anything
    @Override 
    public String toString()
    {
      if (vals == null) return "reference refers to null";
      String s = "\n";
      for (double[] row : vals)
      {
        for (double val : row)
        {
          s += String.format("%8.2f  ", val);
        }
        s += "\n";
      }
      return s;
    }


    //postcondition: return the number of rows in vals
    public int numRows()
    {
      return this.nr;
    }

    
    //postcondition: return the number of columns in vals
    public int numColumns()
    {
      return this.nc;
    }

    
    // precondition: 0 <= r < numRows()  and  0 <= c < numColumns()
    //postcondition: return the value at row r and column c
    //postcondition: this.values has not been modified
    public double get(int r, int c)
    {
      return vals[c][r];
    }


    // precondition: 0 <= r < numRows()  and  0 <= c < numColumns()
    //postcondition: change the value at row r and column c to be val
    public void set(int r, int c, double val)
    {
      vals[c][r] = val;
    }


    @Override
    public boolean equals(Object obj)
    {
      if (obj instanceof Matrix)
      {
        Matrix m1 = (Matrix)obj;

        if (m1.nr != this.nr || m1.nc != this.nc) return false;
        for (int r = 0; r < this.nr; r++ ){
          for (int c = 0; c < this.nc; c++){
            if (this.vals[r][c] != m1.vals[r][c]){
              return false;
            }
          }
        }  
        return true;
      }
      return false;
    }
    
    //postcondition: this.values has not been modified
    //postcondition: return a new matrix identical to this one, but with each element multiplied by a
    public Matrix scalarMultiple(double a)
    {
      Matrix m3 = new Matrix(this.nr, this.nc);
       for (int r = 0; r < this.nr; r++ ){
          for (int c = 0; c < this.nc; c++){
           m3.vals[r][c] = this.vals[r][c] * a;
            }
          }
      
      return m3;  
      }  
    

    
    // precondition: other != null
    // precondition: this.numRows() == other.numRows()  and  this.numColumns() == other.numColumns()
    //postcondition: this.values and other.values have not been modified
    //postcondition: return a new matrix which is the sum of this and other
    public Matrix add(Matrix other)
    {
      Matrix m1 = new Matrix(this.nr, this.nc);
       for (int r = 0; r < this.nr; r++ ){
          for (int c = 0; c < this.nc; c++){
            m1.vals[c][r] =  this.vals[c][r] + other.vals[c][r];
            
            }
          }
          
      return m1;
    }

    
    // precondition: other != null
    // precondition: this.numRows() == other.numRows()  and  this.numColumns() == other.numColumns()
    //postcondition: this.values and other.values have not been modified
    //postcondition: return a new matrix which is the difference of this and other
    public Matrix subtract(Matrix other)
    {
       Matrix m1 = new Matrix(this.nr, this.nc);
       for (int r = 0; r < this.nr; r++ ){
          for (int c = 0; c < this.nc; c++){
            m1.vals[c][r] =  this.vals[c][r] - other.vals[c][r];
            
            }
          }
          
      return m1;
    }

    
    // precondition: other != null  and   this.numColumns() == other.numRows()
    //postcondition: this.values and other.values have not been modified
    //postcondition: return a new matrix which is the product of this and other
    public Matrix multiply(Matrix other)
    {
      Matrix m1 = new Matrix(this.nr, other.nc);
      for (int y = 0; y<this.nr; y++){
        
      for (int x = 0; x<this.nc; x++ ){
      m1.vals[x][y]  = this.vals[x][y]*other.vals[x][y];
  }
        }
     
  return m1;
    }

    
    //postcondition: return a new matrix which is the transpose of this matrix
    public Matrix checkerboard()
    {
      Matrix mat = new Matrix(this.nr, this.nc);
     for (int r = 0; r<this.nr; r++){
      
    for (int c =0; c<this.nc; c++){
      if (r%2==1){
        if (c%2==0){
          mat.vals[r][c] = this.vals[r][c]*-1; 
        }
        else{
          mat.vals[r][c] = this.vals[r][c];
        }
      }
      else if (r%2==0){
      if (c%2==1){
      mat.vals[r][c] = this.vals[r][c]*-1;  
   
      }
        else{
          mat.vals[r][c] = this.vals[r][c];
        }
           }
      
      }
       }

      return mat;
    }

     public Matrix transpose(){
       Matrix mat = new Matrix(this.nr, this.nc);

      for (int c =0; c<this.nc; c++){

  
        for (int r = 0; r<this.nr; r++){
      mat.vals[r][c] = this.vals[c][r];
    

      }
          }
       
       return mat;
     }
    
    // precondition: this.numRows() == this.numColumns()
    //postcondition: this.values has not been modified
    //postcondition: return the determinant of this matrix



 public double[][] subMatrix(double[][] mat, int remRow, int remCol)
  {
 
    int nR = mat.length;
    int nC = mat[0].length;
    double[][] subMat = new double[nR-1][nC-1];
    //Algorithm 1: use mr, mc indexes to traverse mat and sr, sc indexes to traverse subMat
    //Algorithm 2: add only necessary elements from mat to an array list.  Then move
    //             those elements from the arraylist to subMat in the proper order
  ArrayList<Double> hold = new ArrayList<Double>();
  for (int r = 0; r<nR; r++){

    for (int c =0; c<nC; c++){

    if (r != remRow)
    {
      if(c != remCol)
      {hold.add(mat[r][c]);
    }}   
    }
  }
    int counter = 0;
    for (int r =0; r<nR-1; r++){
      for (int c = 0; c<nC-1; c++){
        subMat[r][c] = hold.get(r*(nC-1)+c);
        counter++;
        }
    }
    return subMat;
  }
  //  preconditions: mat != null
  //                 mat.length == mat[0].length (mat is a square matrix)
  //
  //  postcondition: recursively calculate the determinant by row 0 expansion

   // minors matrix == the determinant of each matrix/ 

  
  public double determinant(double[][] mat)
  {
       if (mat.length == 1) return mat[0][0];
    int det = 0;
    for (int c = 0; c< mat[0].length; c++){
      double subDet = determinant(subMatrix(mat, 0,c));
      double product = subDet * mat[0][c];
      if (c%2 == 1){
        product *= -1;
      }
        det += product;
      
    
  }
    return det;
    }
    
    // public double determinant()
    // {
    //   return Double.NaN;
    // }

    

public Matrix minorsMatrix(){
    Matrix mat = new Matrix(this.nr, this.nc);
    for (int c = 0; c< this.vals[0].length; c++){
      for (int r = 0; r< this.vals[0].length; r++){
      double subDet = determinant(subMatrix(this.vals, r,c));
      mat.vals[r][c] = subDet;
      }

    
  }  
  return mat;
  
  }
    
    public Matrix multiplicativeInverse()
    {
      Matrix mat = new Matrix(this.nr, this.nc);
      // System.out.println(mat);
      double determinant = determinant(this.vals);
      // System.out.println(determinant);
      mat = this.minorsMatrix();
      // System.out.println(mat);
      mat = mat.checkerboard();
      mat = mat.transpose();
      mat = mat.scalarMultiple((1/determinant));
    return mat;
      }


    // precondition: 0 <= remRow < numRows()  and  0 <= remCol < numColumns()
    //postcondition: return a new matrix identical to this matrix, but with 
    //               remRow and remCol removed
    //postcondition: this.values has not been modified
    private Matrix copyRemovingRC(int remRow, int removeCol)
    {
      return null;
    }


    
    // preconditionL 0 <= r < numRows()
    //postcondition: return a **copy** of the row indexed at r
    private double[] getRow(int r)
    {
      return null;
    }


    // precondition: 0 <=  c < numColumns()
    //postcondition: return a **copy** of the column indexed at c
    //               Note that you are converting the column into a row
    private double[] getColumn(int c)
    {
      return null;
    }

    
    // precondition: 0 <= row < a.numRows()  and  0 <= col < b.numColumns()
    // precondition: a.numColumns() == b.numRows()
    //postcondition: matrices a and b have not been modified
    //postcondition: return the dot product of the indicated row from a and 
    //               the indicated column of b
    private static double dotProduct(Matrix a, int row, Matrix b, int col)
    {
      return 0.0;
    }
    
  }