public class App {
    // write the method for infix to postfix conversion
    public static String infixToPostfix(String infix) {
        // create a stack
        Stack<Character> stack = new Stack<Character>();
        // create a string builder
        StringBuilder postfix = new StringBuilder();
        // loop through the infix expression
        for (int i = 0; i < infix.length(); i++) {
            // get the character at the current index
            char c = infix.charAt(i);
            // check if the character is an operator
            if (isOperator(c)) {
                // check if the stack is empty
                if (stack.isEmpty()) {
                    // push the operator to the stack
                    stack.push(c);
                } else {
                    // check if the precedence of the current operator is greater than the operator
                    // at the top of the stack
                    if (precedence(c) > precedence(stack.peek())) {
                        // push the operator to the stack
                        stack.push(c);
                    } else {
                        // pop the operator from the stack and append it to the postfix expression
                        postfix.append(stack.pop());
                        // push the current operator to the stack
                        stack.push(c);
                    }
                }
            } else {
                // append the operand to the postfix expression
                postfix.append(c);
            }
        }
        // pop the remaining operators from the stack and append them to the postfix
        // expression
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        // return the postfix expression
        return postfix.toString();
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

    }
}
