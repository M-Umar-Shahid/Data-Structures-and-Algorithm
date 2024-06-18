public class LinkList {
    private final Node head = new Node();
    private final Node tail = new Node();
    private int size;

    LinkList() {

    }

    public void addStart(int val) {
        Node node = new Node();
        if (this.head.next == null) {
            InsertFirstElementCDDLE(val, node);
        } else {
            node.prv = head;
            node.next = head.next;
            head.next = node;
            node.next.prv = node;
            node.value = val;
            size++;
        }
    }

    private void InsertFirstElementCDDLE(int val, Node node) {
        node.prv = head;
        node.next = tail;
        head.next = node;
        head.prv = tail;
        tail.next = head;
        tail.prv = node;
        node.value = val;
        size++;
    }

    public void DisplayLinkList() {
        if (head.next == tail) {
            if (tail.next == head) {
                if (tail.prv == head) {
                    if (head.prv == tail) {
                        System.out.println("List is Empty :(");
                    }
                }
            }

        } else if (head.next == null) {
            System.out.println("List is Empty :(");

        } else {
            Node temp = head.next;
            for (int i = 0; i < this.size; i++) {
                System.out.print(temp.value + " ");
                temp = temp.next;
            }
            System.out.println();
        }

    }

    private static class Node {
        private Node next;
        private Node prv;
        Integer value;
    }

    public void addEnd(int val) {
        Node node = new Node();
        if (this.head.next == null) {
            InsertFirstElementCDDLE(val, node);
        } else {
            node.next = tail;
            node.prv = tail.prv;
            tail.prv.next = node;
            tail.prv = node;
            node.value = val;
            size++;
        }

    }

    public void DisplaySize() {
        System.out.println("Size is " + size);

    }

    public void RemoveStart() {
        head.next = head.next.next;
        head.next.prv = head;
        size--;
    }

    public void RemoveEnd() {
        tail.prv = tail.prv.prv;
        tail.prv.next = tail;
        size--;
    }

    public void ConcatCDDL(LinkList l2) {
        if (this.head.next == null && l2.head.next == null) {
            System.out.println("Both lists are empty :( Please add elements for concatenation ");
        } else if (l2.head.next == null) {
            System.out.println("Second list is empty :( Please add elements for concatenation");
        } else if (this.head.next == null) {
            System.out.println("First list is empty :( Please add elements for concatenation");
        } else {
            this.tail.prv.next = l2.head.next;
            l2.head.next.prv = this.tail.prv;
            this.tail.prv = null;
            this.tail.next = null;
            l2.tail.next = this.head;
            l2.head.prv = null;
            this.head.prv = l2.tail;
            this.size = this.size + l2.size;
            l2.size = this.size;
            l2.head.next = this.head.next;
            System.out.println("Lists concatenated........");
            this.DisplayLinkList();
        }
    }

    // public static void mergeCDLLS(LinkList l1, LinkList l2){
    // if (l1.IsSorted()){}else l1.Sort();
    // if (l2.IsSorted()){}else l2.Sort();
    //
    //
    //
    //
    //
    //
    //
    // }
    public boolean IsSorted() {
        {
            if (this.head.next == tail) {
                if (this.tail.next == head) {
                    if (this.tail.prv == head) {
                        if (this.head.prv == tail) {
                            System.out.println("List is Empty ");
                            return true;

                        }
                    }
                }

            } else if (this.head.next == null) {
                System.out.println("List is Empty ");
                return true;

            } else {
                Node temp = this.head.next;

                for (int i = 0; i < this.size - 1; i++) {
                    if (temp.value > temp.next.value) {
                        return false;
                    }
                    temp = temp.next;
                }
                return true;

            }

        }

        return true;
    }

    // public void Sort(){
    // Node temp=new Node();
    // temp=this.head.next;
    // for (int i = 0; i <size ; i++) {
    // if (temp.value>temp.next.value){
    //
    // }
    //
    // }
    //
    // }

}