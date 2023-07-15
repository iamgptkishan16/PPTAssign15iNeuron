/*
💡 **Question 3**

Implement a Stack using two queues **q1** and **q2**.

**Example 1:**
Input:
push(2)
push(3)
pop()
push(4)
pop()
Output:3 4
Explanation:
push(2) the stack will be {2}
push(3) the stack will be {2 3}
pop()   poped element will be 3 the
        stack will be {2}
push(4) the stack will be {2 4}
pop()   poped element will be 4

*/
package Java_DSA.Stack.Assignment15;


import java.util.*;

public class StackUsingQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public StackUsingQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return q1.remove();
    }

    public int top() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top: " + stack.top());  // Output: Top: 3
        System.out.println("Pop: " + stack.pop());  // Output: Pop: 3
        System.out.println("Pop: " + stack.pop());  // Output: Pop: 2
        System.out.println("Top: " + stack.top());  // Output: Top: 1
        System.out.println("IsEmpty: " + stack.isEmpty());  // Output: IsEmpty: false
    }
}
