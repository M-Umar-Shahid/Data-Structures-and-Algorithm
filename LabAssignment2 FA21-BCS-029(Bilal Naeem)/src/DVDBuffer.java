class CircularQueue {
    private int[] buffer;
    private int front;
    private int rear;
    private int size;

    public CircularQueue(int bufferSize) {
        buffer = new int[bufferSize];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == buffer.length;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Buffer is full. Cannot enqueue data: " + data);
            return;
        }

        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % buffer.length;
        buffer[rear] = data;
        size++;

        System.out.println("Enqueued: " + data);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Buffer is empty. Cannot dequeue data.");
            return -1;
        }

        int data = buffer[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % buffer.length;
        }
        size--;

        System.out.println("Dequeued: " + data);
        return data;
    }

    public void displayBuffer() {
        if (isEmpty()) {
            System.out.println("Buffer is empty.");
            return;
        }

        System.out.println("Buffer (Front: " + front + ", Rear: " + rear + "):");
        if (front <= rear) {
            for (int i = front; i <= rear; i++) {
                System.out.print(buffer[i] + " ");
            }
        } else {
            for (int i = front; i < buffer.length; i++) {
                System.out.print(buffer[i] + " ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(buffer[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(10);

        circularQueue.enqueue(10);
        circularQueue.enqueue(20);
        circularQueue.enqueue(30);
        circularQueue.enqueue(40);
        circularQueue.enqueue(50);

        circularQueue.displayBuffer();

        circularQueue.dequeue();
        circularQueue.dequeue();

        circularQueue.displayBuffer();

        circularQueue.enqueue(60);
        circularQueue.enqueue(70);

        circularQueue.displayBuffer();

        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();

        circularQueue.displayBuffer();
    }
}
