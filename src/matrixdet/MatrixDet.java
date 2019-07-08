/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixdet;

import java.lang.Math;
import java.util.ArrayList;
/**
 *
 * @author boo13
 */
public class MatrixDet {
    
    double[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    
    public static double[][] copyArray(double[][] inputArray){
        double[][] copyOfInput = new double[inputArray.length][];
        for(int i = 0; i < inputArray.length; i++)
            copyOfInput[i] = inputArray[i].clone();
        return copyOfInput;
    }
    
    public static double[][] findSubMatrix(double[][] bigMatrix, int col){
        int numBigRows = bigMatrix.length;
        int numBigCols = bigMatrix[0].length;
        //constructs a matrix with dimensions n-1 x n-1
        double[][] subMatrix = new double[numBigRows - 1][numBigCols - 1];
        //fills in new matrix
        for(int i = 0; i < numBigRows; i++)
            for(int j = 0; j < numBigCols; j++)
                if(i != 0 && j != col){
                    int subArrayRow = i - 1;
                    int subArrayCol = j;
                    if(j > col) subArrayCol--;
                    subMatrix[subArrayRow][subArrayCol] = bigMatrix[i][j];
                }
        return subMatrix;
    }
    
    public static double findDetHelper(double[][] matrix, int col, double determinant, double outerTerm, ArrayList<Double> multTerms){
        System.out.println("Current Subarray: ");
        printArray(matrix);
        System.out.println();
        //base case
        if(matrix.length == 1) {return matrix[0][0];}
        //recursive case
        else {
            double finalDet = 0;
            for(int i = 0; i < matrix[0].length; i++){
                multTerms.add(Math.pow(-1, i) * matrix[0][i]);
                System.out.println("ArrayList of things to multiply with");
                printArrayList(multTerms);
                double all = 1;
                for(int j = 0; j < multTerms.size(); j++) {all *= multTerms.get(j);}
                System.out.println("Multiplying by: " + all + "\n");
                determinant += all * findDetHelper(findSubMatrix(matrix, i), i, determinant, Math.pow(-1, i) * matrix[0][i], multTerms);
                System.out.println("Current determinant: " + determinant + "\n");
                multTerms.remove(multTerms.size()-1);
                System.out.println("ArrayList to Multiply By");
                printArrayList(multTerms);
                finalDet = determinant;
            }
            return finalDet;
        }
        
    }
 
    //distributes the first term
    public static double findDet(double[][] givenMatrix){
        //copy array
        double[][] inputMatrix = copyArray(givenMatrix);
        
        //given matrix nxn
        double term = 0;
        System.out.println("Value of term is: " + term);
        ArrayList<Double> multTerms = new ArrayList();
        for(int i = 0; i < inputMatrix[0].length; i++){
           multTerms.add(Math.pow(-1, i) * givenMatrix[0][i]);
           term = findDetHelper(findSubMatrix(inputMatrix, i), i, term, Math.pow(-1, i) * inputMatrix[0][i], multTerms);
           System.out.println("Value of term is: " + term);
           multTerms.remove(multTerms.size()-1);
           System.out.println("ArrayList to Multiply By");
           printArrayList(multTerms);
        }
        return term;
    }
    
    public static void printArrayList(ArrayList<Double> list){
        System.out.println();
        if(list.size() == 0){
            System.out.print("Empty");
        }
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println();
    }
    
    public static void printArray(double[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long starttime = System.currentTimeMillis();
        
        double[][] array1 = {{1,8,9,2},{3,7,3,6},{8,7,4,2},{2,4,2,2}}; 
        System.out.println(findDet(array1));
        
        long endtime = System.currentTimeMillis();
        System.out.println("That took: " + (endtime-starttime) + "milliseconds");
        
    }
    
}
