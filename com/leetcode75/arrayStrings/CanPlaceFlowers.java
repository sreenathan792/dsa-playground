package com.leetcode75.arrayStrings;

import com.leetcode.arrays2D.KClosestToOrigin;

import java.util.Arrays;

/**
 * <h4>605. Can Place Flowers</h4>
 * <p>
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 * <p>
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int m = flowerbed.length;
        if (m == 1 && flowerbed[0] == 0)
            return true;

        int count = 0;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0) {
                    if (flowerbed[i + 1] == 0) {
                        flowerbed[i] = 1;
                        count++;
                    }
                } else if (i == m - 1) {
                    if (flowerbed[i - 1] == 0) {
                        flowerbed[i] = 1;
                        count++;
                    }
                } else {
                    if (flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
                        flowerbed[i] = 1;
                        count++;
                    }
                }
            }
        }

        if (count >= n) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        CanPlaceFlowers cpf = new CanPlaceFlowers();
        int[] A = {1, 0, 0, 0, 1};
        int B = 2;
        System.out.println("Result -> " + cpf.canPlaceFlowers(A, B));
    }
}


