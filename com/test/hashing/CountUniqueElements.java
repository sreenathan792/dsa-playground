package com.test.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountUniqueElements {

    public int solve(int[] A) {

        int n = A.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(mp.get(A[i]) != null) {
                mp.put(A[i], mp.get(A[i])+1);
            } else {
                mp.put(A[i], 1);
            }
        }

        int count = 0;
        for(Map.Entry<Integer, Integer> ent: mp.entrySet()) {
            if(ent.getValue() == 1)
                count++;
        }

        return count;
    }
}
