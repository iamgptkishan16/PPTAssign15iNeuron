/*
💡 **Question 4**

You are given a stack **St**. You have to reverse the stack using recursion.

**Example 1:**
Input:St = {3,2,1,7,6}
Output:{6,7,1,2,3}

 */

package Java_DSA.Stack.Assignment15;

import java.util.*;

public class ReverseStackUsingRecursion {
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int element = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, element);
    }

    private static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        int top = stack.pop();
        insertAtBottom(stack, element);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Original Stack: " + stack);  // Output: Original Stack: [1, 2, 3]

        reverseStack(stack);

        System.out.println("Reversed Stack: " + stack);  // Output: Reversed Stack: [3, 2, 1]
    }
}
