/*
💡 **Question 8**

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

**Example 1:**
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.


*/
package Java_DSA.Stack.Assignment15;

public class TrapRainWater {
    public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            waterTrapped += minHeight - height[i];
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        // Example usage
        int[] height = {0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2};
        int waterTrapped = trap(height);
        System.out.println("Amount of water trapped: " + waterTrapped);  // Output: 6
    }
}
