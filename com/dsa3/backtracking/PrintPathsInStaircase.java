package com.dsa3.backtracking;

import com.dsa3.twopointers.ContainerWithMostWater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are climbing a staircase and it takes A steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * You need to return all the distinct ways to climb to the top in lexicographical order.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 2 <= A <= 25
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first and the only argument contains an integer A, the number of steps.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an 2-D Integer Array, which denotes all the unique valid paths to reach the top.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 2
 * Input 2:
 * <p>
 * A = 3
 * <p>
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * [ [1, 1], [2] ]
 * Output 2:
 * <p>
 * [ [1, 1, 1], [1, 2], [2, 1] ]
 * <p>
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Distinct ways to reach top: 1 + 1, 2.
 * Explanation 2:
 * <p>
 * Distinct ways to reach top: 1 + 1 + 1, 1 + 2, 2 + 1.
 */
public class PrintPathsInStaircase {

    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> WaysToClimb(int A) {

        ArrayList<Integer> currentPath = new ArrayList<>();
        generateStairPaths(A,currentPath);

        return list;
    }

    private void generateStairPaths(int a, ArrayList<Integer> currentPath) {

        if(a==0) {
           list.add(currentPath);
           return;
        }

        if(a>=1) {
            ArrayList<Integer> currentPath1 = new ArrayList<>(currentPath);
            currentPath1.add(1);
            generateStairPaths(a-1, currentPath1);
        }

        if(a>=2) {
            ArrayList<Integer> currentPath2 = new ArrayList<>(currentPath);
            currentPath2.add(2);
            generateStairPaths(a-2, currentPath2);
        }
    }

    public static void main(String[] args) {
        PrintPathsInStaircase paths = new PrintPathsInStaircase();
        System.out.println("Paths -> " + paths.WaysToClimb(5).toString());
    }
}
