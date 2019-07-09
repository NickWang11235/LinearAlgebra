public class Main {
    public static void main(String[] args) {

        //construct new matrices with 2d double array
        double[][] arrA = {{2,1,0},{0,1,-1},{-2,1,1}};
        double[][] arrB = {{1},{2},{-2}};
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

        System.out.println(new Fraction((double)333/999));

        System.out.println(A.augment(B).reduce(Matrix.Reduction.RREF,true));
    }

}
