package com.example.demo;
import Jama.Matrix;

/***
 * Created by CaoXingYun on 2018/12/26
 **/
public class PCAMain {

    public static void main(String[] args) {

        PCA pca = new PCA();
        double[][] primaryArray = {{1.2, 2.3}, {1.3, 2.1}};
        System.out.println("--------------------------------------------");
        System.out.println("样本集");
        printArray(primaryArray);
        double[][] averageArray = pca.changeAverageToZero(primaryArray);
        System.out.println("--------------------------------------------");
        System.out.println("均值0化后的数据: ");
        System.out.println(averageArray.length + "行，"
                + averageArray[0].length + "列");
        printArray(averageArray);
        System.out.println("---------------------------------------------");
        double[][] varMatrix = pca.getVarianceMatrix(averageArray);
        System.out.println("协方差矩阵: ");
        printArray(varMatrix);
        System.out.println("--------------------------------------------");
        double[][] eigenvalueMatrix = pca.getEigenvalueMatrix(varMatrix);
        System.out.println("特征值矩阵: ");
        printArray(eigenvalueMatrix);
        System.out.println("--------------------------------------------");
        double[][] eigenVectorMatrix = pca.getEigenVectorMatrix(varMatrix);
        System.out.println("特征向量矩阵: ");
        printArray(eigenVectorMatrix);
        System.out.println("--------------------------------------------");
        Matrix principalMatrix = pca.getPrincipalComponent(primaryArray, eigenvalueMatrix, eigenVectorMatrix);
        System.out.println("主成分矩阵: ");
        System.out.println("行数" + principalMatrix.getRowDimension() + ",列数" + principalMatrix.getColumnDimension());
        principalMatrix.print(principalMatrix.getRowDimension(),principalMatrix.getColumnDimension());
        System.out.println("--------------------------------------------");
        Matrix resultMatrix = pca.getResult(primaryArray, principalMatrix);
        System.out.println("降维后的矩阵: ");
        System.out.println("行数" + resultMatrix.getRowDimension() + ",列数" + resultMatrix.getColumnDimension());
        resultMatrix.print(resultMatrix.getRowDimension(),resultMatrix.getColumnDimension());
    }

    private static void printArray(double[][] doubles){
        Matrix A = new Matrix(doubles);
        A.print(doubles.length,doubles[0].length);
    }
}