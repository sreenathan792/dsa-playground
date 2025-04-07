package com.leetcode.backtracking;

import java.util.*;

/**
 * <h4>90. Subsets II</h4>
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class SubsetsII {

    List<List<Integer>> subSets = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        generateSubsets(nums, 0, new ArrayList<Integer>());

        return subSets;
    }

    public void generateSubsets(int[] nums, int i, ArrayList<Integer> arr) {

        subSets.add(new ArrayList(arr));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            arr.add(nums[j]);
            generateSubsets(nums, j + 1, arr);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 5};
        SubsetsII sb2 = new SubsetsII();
        System.out.println("Subsets generated ->" + sb2.subsetsWithDup(nums).toString());
    }
}
