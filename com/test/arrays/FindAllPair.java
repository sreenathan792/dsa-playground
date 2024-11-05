package com.test.arrays;

public class FindAllPair {

    public int solve(int[] A, int[] B, int[] C) {

        int n = A.length;
        int count = 0;

        for (int i = 0; i<n; i++) {
            int x = A[i];
            int temp = C[i];
            if(temp < n) {
                int y = B[temp];

                if(x == y)
                    count++;
            }
        }

        return count;

    }

    public static void main (String[] args) {

        int[] A = {1,2};
        int[] B = {2,1};
        int[] C = {2,2};
        FindAllPair fp = new FindAllPair();

        System.out.println("Result->"+fp.solve(A,B,C));
    }
}
