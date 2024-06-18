public class LinkedList {
    private Node head;
    private int size;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int get(int n) {
        if (n < 0 || n >= size) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        Node current = head;
        for (int i = 0; i < n; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void insertAt(int x, int n) {
        if (n < 0 || n > size) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        Node newNode = new Node(x);
        if (n == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node prev = head;
            for (int i = 0; i < n - 1; i++) {
                prev = prev.next;
            }
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    public void removeAt(int n) {
        if (n < 0 || n >= size) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        if (n == 0) {
            head = head.next;
        } else {
            Node prev = head;
            for (int i = 0; i < n - 1; i++) {
                prev = prev.next;
            }
            Node current = prev.next;
            prev.next = current.next;
        }
        size--;
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        // Inserting elements
        linkedList.insertAt(10, 0);
        linkedList.insertAt(20, 1);
        linkedList.insertAt(30, 2);

        // Accessing elements
        System.out.println("Element at index 0: " + linkedList.get(0));
        System.out.println("Element at index 1: " + linkedList.get(1));
        System.out.println("Element at index 2: " + linkedList.get(2));

        linkedList.reverse();

        System.out.println("Element at index 0: " + linkedList.get(0));
        System.out.println("Element at index 1: " + linkedList.get(1));
        System.out.println("Element at index 2: " + linkedList.get(2));

        // Removing an element
        linkedList.removeAt(1); // Remove element at index 1

        // Accessing elements after removal
        System.out.println("Element at index 0: " + linkedList.get(0)); // Output: 30
        System.out.println("Element at index 1: " + linkedList.get(1)); // Output: 10
    }
}
