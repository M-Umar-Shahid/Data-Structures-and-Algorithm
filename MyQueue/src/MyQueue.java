public class MyQueue {
    int size;
    int[] queue;
    int rear = -1;
    int front = -1;

    MyQueue(int size) {
        this.size = size;
        queue = new int[size];
    }

    public boolean isFull() {
        if (rear + 1 == size) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (front == -1 && rear == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void enQueue(int element) {
        if (isEmpty()) {
            front = 0;
            rear = 0;
            queue[rear] = element;
        } else if (!isFull()) {
            rear++;
            queue[rear] = element;
        } else {
            System.out.println("Queue is already full");
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is already empty");
            return 0;
        }
        int element = queue[front];
        front++;
        return element;
    }

    public void display() {
        for (int i = front; i <= rear; i++) {
            System.out.println(queue[i]);
        }
    }
}

class Main1 {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue(5);
        obj.enQueue(5);
        obj.enQueue(9);
        obj.enQueue(7);
        obj.enQueue(11);
        obj.enQueue(11);
        obj.enQueue(11);
        System.out.println(obj.deQueue());
        obj.display();
    }
}
