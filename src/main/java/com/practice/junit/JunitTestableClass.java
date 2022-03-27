package com.practice.junit;


public class JunitTestableClass {

    public static int findMax(int arr[]) {
        int max = Integer.MIN_VALUE;
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (max < arr[i])
                    max = arr[i];
            }
        }
        return max;
    }

}
