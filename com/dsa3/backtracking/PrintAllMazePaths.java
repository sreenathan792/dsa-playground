package com.dsa3.backtracking;

import java.util.ArrayList;

/**
 * You are given the dimensions of a rectangular board of size A x B. You need to print all the possible paths from top-left corner to bottom-right corner of the board.
 * <p>
 * You can only move down (denoted by 'D') or right (denoted by 'R') at any point in time.
 * <p>
 * NOTE : You need to return all the paths in Lexicographically sorted order. A lexicographic order is an arrangement of characters in alphabetical order.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A, B <= 8
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First Argument is an Integer A, which denotes the Row Index.
 * Second Argument is an Integer B, which denotes the Column Index.
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return a String Array, which denotes all the possible paths in separate lines. The paths should be returned in the Lexicographical order.
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1 :
 * A = 3 , B = 2
 * Input 2 :
 * A = 1 , B = 2
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1 :
 * DDR DRD RDD
 * Output 2 :
 * R
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * For Input 1 :
 * The size of the matrix is 3x2.
 * You are currently standing at (0, 0), the possible paths to bottom right cell (2, 1) are :
 * - (0, 0) -> (1, 0) -> (2, 0) -> (2, 1)  which corresponds to DDR
 * - (0, 0) -> (1, 0) -> (1, 1) -> (2, 1)  which corresponds to DRD
 * - (0, 0) -> (0, 1) -> (1, 1) -> (2, 1)  which corresponds to RDD
 * <p>
 * NOTE: Printing DRD, RDD before DDR would be incorrect as the output should be given in Lexicographical order.
 * For Input 2 :
 * The size of the matrix is 1x2.
 * You are currently standing at (0, 0), the possible paths to bottom right cell (0, 1) are :
 * - (0, 0) -> (0, 1)  which corresponds to R
 * <p>
 * This is the only possible path.
 */
public class PrintAllMazePaths {

    ArrayList<String> list  = new ArrayList<>();
    public ArrayList<String> PrintAllPaths(int A, int B) {


        generatePaths(0, 0, A, B, "");

        return list;
    }

    private void generatePaths(int rows, int column, int A, int B, String sb) {

        if(rows == A-1 && column == B-1) {

            list.add(new String(sb));
            return;
        }

        if(rows< A-1) {
            generatePaths(rows+1, column, A, B, sb.concat("D"));
        }

        if(column< B-1) {
            generatePaths(rows, column + 1, A, B, sb.concat("R"));
        }

    }

    public static void main(String[] args) {
        PrintAllMazePaths paths = new PrintAllMazePaths();
        System.out.println("Paths -> " + paths.PrintAllPaths(3,2));
    }

}
