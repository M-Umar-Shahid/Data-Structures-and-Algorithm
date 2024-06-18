
class Node {
    Node next;
    Integer value;
    Node prev;

    Node(Integer value) {
        this.value = value;
        next = null;
        prev = null;
    }
}

class LinkedList {
    Node head;
    int size = 0;

    LinkedList() {
        head = null;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Unsuitable Index");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    public void insertAt(Integer item, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Unsuitable Index");
        }
        Node newNode = new Node(item);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            size++;
        } else if (index == size) {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
            size++;
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.prev.next = newNode;
            newNode.prev = temp.prev;
            newNode.next = temp;
            temp.prev = newNode;
            size++;
        }
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Unsuitable Index");
        }
        if (index == 0) {
            head = null;
            size--;
        } else if (index == 1) {
            head.next = null;
            size--;
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            size--;
        }
    }

    public void display() {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.value);
            System.out.print("->");
            temp = temp.next;
        }
        System.out.println("End");
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
        LinkedList list = new LinkedList();
        list.insertAt(34, 0);
        list.insertAt(3, 1);
        list.insertAt(12, 2);
        list.insertAt(15, 2);
        // list.insertAt(43, 3);
        list.display();
        list.removeAt(2);
        list.display();
        list.reverse();
        list.display();
    }
}
