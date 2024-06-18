import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class BracketsMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> bracketCounter = new Stack<>();
        System.out.println("Enter an infix expression : ");
        String str = sc.nextLine();
        int flag = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch=='('){
                bracketCounter.push(ch);
            }
            if (ch==')'){
                try{
                if (bracketCounter.peek()=='('){
                    bracketCounter.pop();
                }else{
                    System.out.println("The expression is incorrect");
                    flag=0;

                }
                }catch (EmptyStackException e){
                    flag=0;
                }
            }
        }
        if (bracketCounter.size()==0 && flag!=0){
            System.out.println("The expression is correct");
        }else{
            System.out.println("The expression is incorrect");
        }
    }
}
