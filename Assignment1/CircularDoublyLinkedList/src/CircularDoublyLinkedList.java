public class CircularDoublyLinkedList {

    Node header = new Node(null, null, null);
    Node trailer = new Node(null, header, header);

    CircularDoublyLinkedList() {
        header.next = trailer;
        header.prev = trailer;
        // trailer.next = header;
        // trailer.prev = header;
    }

    // class Node {
    // Node next;
    // Node prev;
    // int data;

    // Node(int data) {
    // this.data = data;
    // this.next = null;
    // this.prev = null;
    // }
    // }

    public void addStart(int data) {
        Node addingNode = new Node(data, header, header.next);
        addingNode.next = header.next;
        header.next.prev = addingNode;
        header.next = addingNode;
        addingNode.prev = header;
    }

    public static void main(String[] args) throws Exception {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.addStart(56);
    }
}
