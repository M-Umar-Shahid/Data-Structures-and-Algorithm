public class CircularDLL {

    Node head;
    Node tail;
    int size;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public void display() {
        Node temp = head;
        if (head == null) {
            System.out.println("Cannot display list Because the list is empty");
            return;
        }
        while (temp.next != head) {
            System.out.print(temp.value);
            temp = temp.next;
            System.out.print("->");
        }
        System.out.println(temp.value);
    }

    public void addStart(int value) {
        Node temp = new Node(value);
        if (head == null) {
            head = temp;
            tail = temp;
        }
        tail.next = temp;
        temp.next = head;
        head.prev = temp;
        temp.prev = tail;
        head = temp;
        this.size++;
    }

    public void addEnd(int value) {
        Node temp = new Node(value);
        if (head == null) {
            head = temp;
            tail = temp;
        }
        tail.next = temp;
        temp.next = head;
        head.prev = temp;
        temp.prev = tail;
        tail = temp;
        this.size++;
    }

    public void removeStart() {
        if (head == null) {
            System.out.println("Cannot remove element from list because the list is already empty");
            return;
        }
        if (head.next == head) {
            head = null;
            tail = null;
            return;
        }
        tail.next = head.next;
        head = head.next;
        head.prev = tail;
        this.size--;
    }

    public void removeEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == head) {
            head = null;
            tail = null;
            return;
        }
        head.prev = tail.prev;
        tail = tail.prev;
        tail.next = head;
        this.size--;
    }

    public int size() {
        return size;
    }

    // Methods for Question 2

    public static void concatCDLLs(CircularDLL list1, CircularDLL list2) {
        list1.tail.next = list2.head;
        list2.head.prev = list1.tail;
        list2.tail.next = list1.head;
        list1.head.prev = list2.tail;
        System.out.println("Concatenated list");
        list2.display();
    }

    // Methods for Question 3

    public void sort() {
        Node temp = head;
        do {
            Node current = head;
            while (current.next != head) {
                if (current.value > temp.value) {
                    int swap = temp.value;
                    temp.value = current.value;
                    current.value = swap;
                }
                current = current.next;
            }
            temp = temp.next;
        } while (temp.next != head.next);
    }

    public static boolean isSorted(CircularDLL list) {
        Node temp = list.head;
        Node current = list.head.next;
        do {
            if (temp.value > current.value) {
                return false;
            }
            temp = temp.next;
            current = current.next;
        } while (temp.next != list.head);
        return true;
    }

    public static void mergeDLLs(CircularDLL list1, CircularDLL list2) {
        CircularDLL clonedCDLL = new CircularDLL();
        boolean listIsSortedOrNot1 = isSorted(list1);
        boolean listIsSortedOrNot2 = isSorted(list2);
        if (listIsSortedOrNot1 && listIsSortedOrNot2) {
            concatCDLLs(list1, list2);
            list1.sort();
            list1.display();
            Node temp = list1.head;
            System.out.println(list1.head.value);
            do {
                clonedCDLL.addEnd(temp.value);
                temp = temp.next;
            } while (temp.next != list1.head.next);
        } else {
            System.out.println("The CDLLs given in the input are not sorted");
        }
        System.out.println("The cloned merged list is : ");
        clonedCDLL.display();
    }

    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println("---------------Question 1 solution---------------");
        System.out.println();
        CircularDLL list = new CircularDLL();
        list.addStart(5);
        list.display();
        list.removeStart();
        list.display();
        list.addStart(245);
        list.addStart(345);
        list.addStart(55);
        list.addStart(15);
        list.display();
        list.removeStart();
        list.display();
        list.removeEnd();
        list.addStart(15);
        list.display();

        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();

        // Question 2

        System.out.println("---------------Question 2 solution---------------");
        System.out.println();

        CircularDLL list1 = new CircularDLL();
        list1.addStart(35);
        list1.addStart(875);
        list1.addStart(123);
        list1.addStart(23);
        list1.addStart(4);
        list1.addStart(15);
        System.out.println("List 1");
        list1.display();

        CircularDLL list2 = new CircularDLL();
        list2.addStart(5);
        list2.addStart(245);
        list2.addStart(55);
        list2.addStart(15);
        System.out.println("List 2");
        list2.display();

        concatCDLLs(list1, list2);
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();

        // Question 3

        // Sorting a linked list

        System.out.println("---------------Question 3 solution---------------");

        CircularDLL list3 = new CircularDLL();
        list3.addStart(3);
        list3.addStart(85);
        list3.addStart(13);
        list3.addStart(3);
        list3.addStart(4);
        list3.addStart(5);

        CircularDLL list4 = new CircularDLL();
        list4.addStart(5);
        list4.addStart(45);
        list4.addStart(5);
        list4.addStart(15);

        list3.sort();
        list4.sort();
        list3.display();
        list4.display();
        mergeDLLs(list3, list4);
        System.out.println("---------------------------------------------");

    }
}
