import java.util.Stack;

public class QueueUsingStacks {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

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
        if (stack1.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stack1.pop();
    }

    public void display() {
        while (!stack1.empty()) {
            System.out.print(stack1.pop() + "  ");
        }
    }

    public static void main(String[] args) {
        QueueUsingStacks myQueueUsingStacks = new QueueUsingStacks();
        myQueueUsingStacks.enqueue(10);
        myQueueUsingStacks.enqueue(1);
        myQueueUsingStacks.enqueue(1);
        myQueueUsingStacks.enqueue(8);
        myQueueUsingStacks.dequeue();
        myQueueUsingStacks.dequeue();
        myQueueUsingStacks.enqueue(8);
        myQueueUsingStacks.display();
    }
}
