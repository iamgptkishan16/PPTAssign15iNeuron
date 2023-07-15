/*
💡 **Question 5**

You are given a string **S**, the task is to reverse the string using stack.

**Example 1:**
Input: S="GeeksforGeeks"
Output: skeeGrofskeeG

*/

package Java_DSA.Stack.Assignment15;

import java.util.Stack;

public class ReverseStringUsingStack {
    public static String reverseString(String str) {
        // Create a stack to store the characters
        Stack<Character> stack = new Stack<>();

        // Push each character of the string onto the stack
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        // Pop each character from the stack to form the reversed string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        // Return the reversed string
        return reversed.toString();
    }

    public static void main(String[] args) {
        // Example usage
        String input = "GeeksforGeeks";
        String reversed = reverseString(input);
        System.out.println("Reversed string: " + reversed);
    }
}
