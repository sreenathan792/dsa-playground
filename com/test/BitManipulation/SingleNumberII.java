package com.test.BitManipulation;

public class SingleNumberII {

    public int singleNumber(final int[] A) {

        int n = A.length;
        int ans = 0;
        for(int i = 0; i<31; i++) {
            int count = 0;
            for(int j = 0; j<n; j++) {

                if((A[j]&(1<<i))>0) {
                    count++;
                }
            }

            if(count % 3>0) {
                ans = (ans | (1<<i));
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] A = {803, 306, 918, 918, 306, 81, 803, 849, 849, 918, 803, 849, 306};
        SingleNumberII sn2 = new SingleNumberII();
        System.out.println(sn2.singleNumber(A));
    }
}
