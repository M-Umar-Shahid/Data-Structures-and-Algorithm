class BSTNode {
    int value;
    BSTNode left;
    BSTNode right;

    public BSTNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class Heap {
    public BSTNode[] heap;
    public int size;

    public Heap() {
        heap = new BSTNode[50];
        size = 0;
    }

    public void insert(BSTNode bst) {
        heap[size] = bst;
        heapifyUp(size);
        size++;
    }

    public BSTNode delete() {
        if (size == 0)
            return null;

        BSTNode minNode = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        heapifyDown(0);
        return minNode;
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        if (parentIndex >= 0 && heap[index].value < heap[parentIndex].value) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallest = index;

        if (leftChildIndex < size && heap[leftChildIndex].value < heap[smallest].value)
            smallest = leftChildIndex;

        if (rightChildIndex < size && heap[rightChildIndex].value < heap[smallest].value)
            smallest = rightChildIndex;

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        BSTNode temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}

class Main {
    public static void main(String[] args) {

        Heap heap = new Heap();

        // Create Binary Search Trees
        BSTNode bst1 = new BSTNode(345);
        bst1.left = new BSTNode(4);
        bst1.right = new BSTNode(3423);

        BSTNode bst2 = new BSTNode(1234);
        bst2.left = new BSTNode(2345);
        bst2.right = new BSTNode(654);

        BSTNode bst3 = new BSTNode(234);
        bst3.left = new BSTNode(645);
        bst3.right = new BSTNode(2341);

        heap.insert(bst1);
        heap.insert(bst2);
        heap.insert(bst3);

        while (heap.size > 0) {
            BSTNode minBst = heap.delete();
            System.out.println("Minimum value: " + minBst.value);
        }
    }
}
