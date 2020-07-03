package com.guomz.OfferTest.kth_smallest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int matrix[][] = {
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}};

        System.out.println(kthSmallest(matrix, 8));
    }

    public static int kthSmallest(int[][] matrix, int k) {

        List<Integer> list = new ArrayList<>(matrix.length * matrix[0].length);
        for (int i = 0; i < matrix.length; i ++){
            for (int j = 0; j < matrix[0].length; j ++){
                list.add(matrix[i][j]);
            }
        }
        Collections.sort(list);
        return list.get(k - 1);
    }
}
