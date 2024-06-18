public class MyLinkedList {

    Node head;

    class Node {
        int value;
        Node next;

        Node(int d) {
            value = d;
            next = null;
        }
    }

    public void insertAtStart(int value) {
        Node newestNode = new Node(value);
        if (head == null) {
            head = newestNode;
        } else {
            // newestNode.next = head;
            // head = newestNode;
            newestNode = head;
            head.next = newestNode;
            newestNode.value = value;
        }
    }

    public void insertAtEnd(int value) {
        Node newestNode = new Node(value);
        if (head == null) {
            head = newestNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newestNode;
        }
    }

    public

    public void display() {
        Node current = head;
        if (current == null) {
            System.out.println("list is empty");
            return;
        } else {
            while (current != null) {
                System.out.println(current.value);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        // list.insertAtEnd(45);
        // list.insertAtEnd(34);
        // list.insertAtEnd(12);
        // list.insertAtEnd(9);
        list.insertAtStart(9);
        list.insertAtStart(9);
        list.insertAtStart(9);
        list.display();
    }
}
