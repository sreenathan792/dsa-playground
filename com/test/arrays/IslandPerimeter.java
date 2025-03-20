package com.test.arrays;

/**
 * <h4>463. Island Perimeter</h4>
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 * Example 2:
 * <p>
 * Input: grid = [[1]]
 * Output: 4
 * Example 3:
 * <p>
 * Input: grid = [[1,0]]
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 100
 * grid[i][j] is 0 or 1.
 * There is exactly one island in grid.
 */
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int perimeter = 0;
        for(int i = 0; i<n; i++) {
             for(int j = 0; j<m; j++){
                if(grid[i][j] == 1) {
                    //Add 4 if island --> 4 sides
                    perimeter += 4;
                    //check if top exists
                    if(i-1>=0 && grid[i-1][j] == 1) {
                        perimeter -= 1;
                    }
                    //check if bottom exists
                    if(i+1<n && grid[i+1][j] == 1) {
                        perimeter -= 1;
                    }
                    //check if left exists
                    if(j-1>=0 && grid[i][j-1] == 1) {
                        perimeter -= 1;
                    }
                    //check if right exists
                    if(j+1<m && grid[i][j+1] == 1) {
                        perimeter -= 1;
                    }
                }
            }
        }

        return perimeter;
    }

    public static void main(String[] args) {
        IslandPerimeter ip = new IslandPerimeter();
        int[][] A = {{0,1,0,0}, {1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println("Perimeter of the Island = " + ip.islandPerimeter(A));
    }
}
