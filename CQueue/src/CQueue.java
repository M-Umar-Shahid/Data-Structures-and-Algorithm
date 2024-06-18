public class CQueue {
    int front = -1;
    int rear = -1;
    int[] Queue = new int[10];

    public boolean isFull() {
        if (front == 0 && rear == 9) {
            return true;
        } else
            return false;
    }

    public boolean isEmpty() {
        if (front == -1) {
            return true;
        } else
            return false;
    }

    public void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is already full");
        }
        rear = rear + 1;
        Queue[rear] = element;
        if (front == -1) {
            front = 0;
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is already empty");
            return -1;
        }
        int element = Queue[front];
        front = front + 1;
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        return element;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("The Queue is empty");
        } else {
            for (int i = front; i <= rear; i++)
                System.out.println(Queue[i] + "  ");
        }
    }

    public static void main(String[] args) throws Exception {
        CQueue obj = new CQueue();
        obj.enQueue(5);
        obj.deQueue();
        obj.deQueue();
        obj.display();
    }
}
