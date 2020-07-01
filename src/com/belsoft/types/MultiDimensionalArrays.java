package com.belsoft.types;

import java.util.Arrays;

public class MultiDimensionalArrays {
    public static void main(String[] args) {

        int[][] numbers2D = new int[2][3];
        numbers2D[0][0] = 1;
        System.out.println(Arrays.deepToString(numbers2D));

        int[][][] numbers3D = new int[2][3][2];
        numbers3D[0][0][0] = 1;
        System.out.println(Arrays.deepToString(numbers3D));

        int[][] myTable2D = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(myTable2D));
    }
}
