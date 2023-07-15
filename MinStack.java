/*
💡 **Question 7**

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the `MinStack` class:

- `MinStack()` initializes the stack object.
- `void push(int val)` pushes the element `val` onto the stack.
- `void pop()` removes the element on the top of the stack.
- `int top()` gets the top element of the stack.
- `int getMin()` retrieves the minimum element in the stack.

You must implement a solution with `O(1)` time complexity for each function.

**Example 1:**
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2

*/

package Java_DSA.Stack.Assignment15;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int val = stack.pop();
            if (val == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        throw new RuntimeException("Stack is empty.");
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        throw new RuntimeException("Stack is empty.");
    }

    public static void main(String[] args) {
        // Example usage
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(2);
        minStack.push(7);
        minStack.push(1);
        minStack.push(8);

        System.out.println("Top element: " + minStack.top());  // Output: 8
        System.out.println("Minimum element: " + minStack.getMin());  // Output: 1

        minStack.pop();
        minStack.pop();

        System.out.println("Top element: " + minStack.top());  // Output: 7
        System.out.println("Minimum element: " + minStack.getMin());  // Output: 2
    }
}
