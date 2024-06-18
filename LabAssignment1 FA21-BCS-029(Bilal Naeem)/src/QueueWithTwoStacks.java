import java.util.Stack;

class QueueWithTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueWithTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int item) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(item);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        return stack1.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}

class Main {
    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue(40);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
