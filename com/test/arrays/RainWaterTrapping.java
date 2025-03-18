package com.test.arrays;

public class RainWaterTrapping {

    public int trap(int[] height) {
        int n = height.length;
        int[] maxL = new int[n];
        int[] maxR = new int[n];

        maxL[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxL[i] = Math.max(maxL[i], maxL[i - 1]);
        }

        maxR[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 1; i--) {
            maxR[i] = Math.max(maxR[i], maxR[i + 1]);
        }

        int water = 0;
        for (int i = 1; i < n - 1; i++) {
            int trapped = Math.min(maxL[i], maxR[i]) - height[i];

            if (trapped > 0) {
                water += trapped;
            }
        }

        return water;
    }

    public static void main(String[] args) {

        RainWaterTrapping rain = new RainWaterTrapping();
        int[] A = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped Rainwater = " + rain.trap(A));
    }
}
