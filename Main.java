public class Main extends Object
{
  
  public static void main(String[] args) 
  {
    Matrix m1 = new Matrix(3, 5, 9.8);
    System.out.println("m1 = "+m1);

    Matrix m2 = new Matrix(2, 7);
    System.out.println("m2 = "+m2);

    Matrix A = new Matrix("A.txt");
    System.out.println("A = "+A);
    
    System.out.println(A.determinant(A.vals));
    
    Matrix D = new Matrix("D.txt");
    System.out.println("D = " +D);
    
    System.out.println((A.multiplicativeInverse()));
  
    
    }
}