public class stackWithLinkedList {

    Node head;
    Node tail;

    stackWithLinkedList() {
        head = null;
        tail = null;
    }

    class Node {
        Node next;
        int value;

        Node(int value) {
            this.value = value;
            next = null;
        }

    }

    public void push(int value) {
        Node addingNode = new Node(value);
        if (head == null) {
            head = addingNode;
            tail = addingNode;
        }
        tail.next = addingNode;
        tail = addingNode;
    }

    public int pop() {
        Integer value = null;
        if (head == null) {
            System.out.println("The list is empty");
        } else {
            value = tail.value;
            Node current = head;
            while (current != tail) {
                if (current.next == tail) {
                    current.next = null;
                    tail = current.next;
                    break;
                }
                current = current.next;
            }
        }
        return value;
    }

    public void display() {
        Node current = head;
        if (head == tail) {
            System.out.print(head.value);
        } else {
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

class Main {
    public static void main(String[] args) {
        stackWithLinkedList linkedStack = new stackWithLinkedList();
        linkedStack.push(45);
        linkedStack.push(12);
        linkedStack.push(16);
        linkedStack.display();
        System.out.println(linkedStack.pop());
        linkedStack.display();
    }
}