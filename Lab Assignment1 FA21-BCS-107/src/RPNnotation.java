import java.util.Scanner;
import java.util.Stack;

public class RPNnotation {

    public boolean isOperator(char readCharacter) {
        if (readCharacter == '+') {
            return true;
        } else if (readCharacter == '-') {
            return true;
        } else if (readCharacter == '*') {
            return true;
        } else if (readCharacter == '/') {
            return true;
        } else {
            return false;
        }
    }

    public int calculate(int var1, int var2, char readCharacter) {
        if (readCharacter == '+') {
            return var1 + var2;
        } else if (readCharacter == '-') {
            return var1 - var2;
        } else if (readCharacter == '*') {
            return var1 * var2;
        } else {
            return var1 / var2;
        }
    }
}

class Main {
    public static void main(String[] args) {
        RPNnotation rpnNotation = new RPNnotation();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a RPN notation : ");
        String notation = sc.nextLine();
        sc.close();

        Stack<Integer> stack = new Stack<>();
        char[] notationArray = notation.toCharArray();

        for (int i = 0; i < notationArray.length; i++) {
            char readCharacter = notationArray[i];
            if (rpnNotation.isOperator(readCharacter)) {
                int var2 = (stack.pop());
                int var1 = (stack.pop());
                int result = rpnNotation.calculate(var1, var2, readCharacter);
                stack.push(result);
            } else {
                stack.push(readCharacter - '0');
            }
        }
        System.out.println(stack.pop());
    }

}
