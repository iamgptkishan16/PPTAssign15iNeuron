/*

💡 **Question 6**

Given string **S** representing a postfix expression, the task is to evaluate the expression and find the final value. Operators will only include the basic arithmetic operators like ***, /, + and -**.

**Example 1:**

Input: S = "231*+9-"
Output: -4
Explanation:
After solving the given expression,
we have -4 as result.


*/

package Java_DSA.Stack.Assignment15;

import java.util.Stack;

public class PostfixExpressionEvaluator {
    public static int evaluatePostfixExpression(String postfixExpression) {
        // Create a stack to store operands
        Stack<Integer> stack = new Stack<>();

        // Traverse the postfix expression character by character
        for (char ch : postfixExpression.toCharArray()) {
            // If the character is an operand, push it onto the stack
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // Convert char to integer value
            }
            // If the character is an operator, perform the operation
            else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(ch, operand1, operand2);
                stack.push(result);
            }
        }

        // The final result will be the only element left on the stack
        return stack.pop();
    }

    public static int performOperation(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
        }
        throw new IllegalArgumentException("Invalid operator: " + operator);
    }

    public static void main(String[] args) {
        // Example usage
        String postfixExpression = "82+3-9*";
        int result = evaluatePostfixExpression(postfixExpression);
        System.out.println("Postfix Evaluation Result: " + result);
    }
}
