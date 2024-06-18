import java.util.Scanner;
import java.util.Stack;

public class LinkedList {
    Node head;
    Node tail;

    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    LinkedList() {
        head = null;
        tail = null;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }


    public void display() {
        Node temp = head;
        System.out.print("List: ");
        while (temp != null) {
            if (temp.next == null) {
                System.out.print(temp.data);
                break;
            }
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int sum() {
        Node temp = head;
        int sum = 0;
        while (temp != null) {
            sum = sum + temp.data;
            temp = temp.next;
        }
        return sum;
    }

    public int product() {
        Node temp = head;
        int product = 1;
        while (temp != null) {
            product = product * temp.data;
            temp = temp.next;
        }
        return product;
    }

    public void average() {
        int sum = sum();
        int count = size();
        double average = sum / count;
        System.out.println(average);
    }

    public int size() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
        }
        return count;
    }

    public int min() {
        Node temp = head;
        int min = head.data;
        while (temp != null) {
            if (temp.data < min) {
                min = temp.data;
            }
            temp = temp.next;
        }
        return min;
    }

    public int max() {
        Node temp = head;
        int max = head.data;
        while (temp != null) {
            if (temp.data > max) {
                max = temp.data;
            }
            temp = temp.next;
        }
        return max;
    }

}


    class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(20);
        list.addFirst(30);
        list.addLast(40);
        list.addLast(200);
        list.display();
        System.out.println("Sum: " + list.sum());
        System.out.println("Product: " + list.product());
//        list.average();
        System.out.println(list.min());
        System.out.println(list.max());

        //Question 2

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String line = sc.nextLine();
        line = line.toLowerCase();
        Stack<Character> stack1 = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            stack1.push(line.charAt(i));
        }
        boolean flag = true;
        for (int i = 0; i < stack1.size(); i++) {
            char ch = stack1.pop();
            if (ch!=line.charAt(i)){
                flag = false;
                break;
            }
        }
        if (flag==false){
            System.out.println("String is not a palindrome");
        }else{
            System.out.println("String is a palindrome");
        }
    }
}