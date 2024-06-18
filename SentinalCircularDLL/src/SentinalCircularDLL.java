public class SentinalCircularDLL {
    Node head;
    Node tail;
    int size;

    class Node {
        Integer value;
        Node next;
        Node prev;

        Node(Integer value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    SentinalCircularDLL() {
        head = new Node(null, null, null);
        tail = new Node(null, head, head);
        head.next = tail;
        head.prev = tail;
    }

    public void addStart(int value) {
        Node temp = new Node(value, head.next, head);
        head.next.prev = temp;
        head.next = temp;
        this.size++;
    }

    public void addEnd(int value) {
        Node temp = new Node(value, tail, tail.prev);
        tail.prev.next = temp;
        tail.prev = temp;
        this.size++;
    }

    public void display() {
        Node temp = head;
        if (temp.next.value == null) {
            System.out.print(head.value + " -> " + tail.value);
            System.out.println(" (List is empty)");
            return;
        }
        while (temp.next != head) {
            System.out.print(temp.value);
            temp = temp.next;
            System.out.print(" -> ");
        }
        System.out.println(temp.value);
    }

    public void removeStart() {
        if (head.next.value == null) {
            System.out.println("List is already empty");
            return;
        }
        head.next.next.prev = head;
        head.next = head.next.next;
        this.size--;
    }

    public void removeEnd() {
        if (head.next.value == null) {
            System.out.println("List is already empty");
            return;
        }
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        this.size--;
    }

    public int size() {
        return size;
    }

    public static SentinalCircularDLL concatCDLLs(SentinalCircularDLL list1, SentinalCircularDLL list2) {
        list1.tail.prev.next = list2.head.next;
        list2.head.next.prev = list1.tail.prev;
        list2.tail.next = list1.head;
        list1.head.prev = list2.tail;
        list2.head = list1.head;
        list1.tail = list2.tail;
        System.out.print("Concatenated list : ");
        return list2;
    }

    public void sort() {
        Node temp = head.next;
        do {
            Node current = head.next;
            while (current.next != tail) {
                if (current.value > temp.value) {
                    int swap = temp.value;
                    temp.value = current.value;
                    current.value = swap;
                }
                current = current.next;
            }
            temp = temp.next;
        } while (temp.next != head);
    }
    
    public static boolean isSorted(SentinalCircularDLL list) {
        if (list.head.next.value == null) {
            System.out.println("List is empty");
            return false;
        }
        Node temp = list.head.next;
        Node current = list.head.next.next;
        do {
            if (temp.value > current.value) {
                return false;
            }
            temp = temp.next;
            current = current.next;
        } while (temp.next != list.tail);
        return true;
    }

    public static void mergeDLLs(SentinalCircularDLL list1, SentinalCircularDLL list2) {
        SentinalCircularDLL clonedCDLL = new SentinalCircularDLL();
        boolean listIsSortedOrNot1 = isSorted(list1);
        boolean listIsSortedOrNot2 = isSorted(list2);
        if (listIsSortedOrNot1 && listIsSortedOrNot2) {
            concatCDLLs(list1, list2);
            list1.sort();
            list1.display();
            Node temp = list1.head.next;
            // System.out.println(list1.head.value);
            do {
                clonedCDLL.addEnd(temp.value);
                temp = temp.next;
            } while (temp.next != list1.head);
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
        SentinalCircularDLL list = new SentinalCircularDLL();
        list.addStart(13);
        list.addStart(34);
        list.addEnd(33);
        list.addEnd(34);
        list.addEnd(12);
        list.addEnd(56);
        // list.addStart(11);
        // list.addStart(54);
        // list.removeStart();
        list.display();
        list.removeStart();
        list.removeEnd();
        list.removeEnd();
        list.display();
        System.out.println(list.size());

        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();

        // Question 2

        System.out.println("---------------Question 2 solution---------------");
        System.out.println();

        SentinalCircularDLL list1 = new SentinalCircularDLL();
        list1.addStart(35);
        list1.addStart(875);
        list1.addStart(123);
        list1.addStart(23);
        list1.addStart(4);
        list1.addStart(15);
        System.out.print("List 1 : ");
        list1.display();

        SentinalCircularDLL list2 = new SentinalCircularDLL();
        list2.addStart(5);
        list2.addStart(245);
        list2.addStart(55);
        list2.addStart(15);
        System.out.print("List 2 : ");
        list2.display();

        concatCDLLs(list1, list2).display();
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();

        System.out.println("---------------Question 3 solution---------------");

        SentinalCircularDLL list3 = new SentinalCircularDLL();
        list3.addStart(3);
        list3.addStart(85);
        list3.addStart(13);
        list3.addStart(3);
        list3.addStart(4);
        list3.addStart(5);

        SentinalCircularDLL list4 = new SentinalCircularDLL();
        list4.addStart(5);
        list4.addStart(45);
        list4.addStart(5);
        list4.addStart(15);
        System.out.print("List 3 : ");
        list3.display();
        System.out.print("List 4 : ");
        list4.display();

        list3.sort();
        list4.sort();
        System.out.print("Sorted List 3 : ");
        list3.display();
        System.out.print("Sorted List 4 : ");
        list4.display();

        // isSorted

        System.out.println(SentinalCircularDLL.isSorted(list3));
        System.out.println(SentinalCircularDLL.isSorted(list4));

        // Merge

        mergeDLLs(list3, list4);
        System.out.println("---------------------------------------------");

    }
}
