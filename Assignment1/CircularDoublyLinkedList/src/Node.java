public class Node {
    Node next;
    Node prev;
    int data;

    Node(Integer data, Node prev, Node next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
