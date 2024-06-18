import java.util.Scanner;
import java.util.Stack;

public class Conversions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> output = new Stack<>();
        System.out.println("Enter a decimal number : ");
        int num = sc.nextInt();
        System.out.println("Enter a base you want to find : ");
        int base = sc.nextInt();
        do {
            output.push(Integer.toString(num%base));
            num = (int)num/base;
        }while(num!=0);
        System.out.println();
        while (output.size()!=0)
            System.out.print(output.pop());
        }
    }

