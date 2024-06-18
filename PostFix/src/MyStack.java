public class MyStack {
    int[] array;
    int top = -1;
    int size;

    MyStack(int size) {
        this.size = size;
        array = new int[size];
    }

    public boolean isFull() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack is already full");
        } else {
            top++;
            array[top] = element;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is already empty");
            return 0;
        } else {
            int element = array[top];
            top--;
            return element;
        }
    }

    public int totalSize() {
        return top + 1;
    }

    public void display() {
        for (int i = 0; i <= top; i++) {
            System.out.println(array[i]);
        }
    }
}

class Main {
    public static void main(String[] args) {
        MyStack obj = new MyStack(10);
        obj.push(5);
        obj.push(10);
        obj.push(6);
        obj.pop();
        System.out.println();
        System.out.println();
        System.out.println();
        obj.display();
        System.out.println(obj.totalSize());
    }
}
