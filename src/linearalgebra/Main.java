package linearalgebra;

public class Main {
    public static void main(String[] args) {

        //construct new matrices with 2d double array
        double[][] arrA = {{1,-1,1},{2,-100,1},{1,-2,3}};
        double[][] arrB = {{-1,0,0},{0,2,0},{0,0,3}};
        //call methods on Matrix object, ex m.inverse(true)
        Matrix A = new Matrix(arrA);
        Matrix B = new Matrix(arrB);


        /*
        Supported operations:
            -addition
            -multiplication
            -reduce to reduced row echelon or upper triangular form with work
            -determinants with work
            -inverses with work
            -writing matrix as product of elementary matrices
            -transpose
            -different basic row operations
        Answers are given in reduced fraction form.
         */

        long starttime = System.currentTimeMillis();
        MatrixCalc c = new MatrixCalc();
        A.det(c);
        System.out.println(c.getDescription());
                
        
        long endtime = System.currentTimeMillis();
        System.out.println("That took: " + (endtime-starttime) + "milliseconds");

    }

}
