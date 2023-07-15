/*
💡 **Question 2**

Given an array **a** of integers of length **n**, find the nearest smaller number for every element such that the smaller element is on left side.If no small element present on the left print -1.

**Example 1:**

Input: n = 3
a = {1, 6, 2}
Output: -1 1 1
Explaination: There is no number at the
left of 1. Smaller number than 6 and 2 is 1.
*/



package Java_DSA.Stack.Assignment15;

import java.util.*;

public class nearestSmallEle {
    public static int[] nearestSmallerElement(int[] a) {
        int n = a.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= a[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(a[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 2, 10, 8};
        int[] result = nearestSmallerElement(a);
        System.out.println(Arrays.toString(result));
    }
}
