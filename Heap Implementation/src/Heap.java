class HeapNode {
    int value;
    HeapNode left;
    HeapNode right;

    public HeapNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class LinkedHeap {
    public HeapNode root;

    public LinkedHeap() {
        this.root = null;
    }

    public void insert(int value) {
        if (root == null) {
            root = new HeapNode(value);
        } else {
            insertHelper(root, value);
        }
    }

    private void insertHelper(HeapNode node, int value) {
        if (node.left == null) {
            node.left = new HeapNode(value);
        } else if (node.right == null) {
            node.right = new HeapNode(value);
        } else {
            // Traverse to the next level
            if (countNodes(node.left) <= countNodes(node.right)) {
                insertHelper(node.left, value);
            } else {
                insertHelper(node.right, value);
            }
        }

        // Perform heapify-up
        heapifyUp(node);
    }

    private void heapifyUp(HeapNode node) {
        if (node == root) {
            return;
        }

        HeapNode parent = findParent(root, node);
        if (parent.value < node.value) {
            swapValues(parent, node);
            heapifyUp(parent);
        }
    }

    private HeapNode findParent(HeapNode currentNode, HeapNode targetNode) {
        if (currentNode == null || currentNode.left == targetNode || currentNode.right == targetNode) {
            return currentNode;
        }

        HeapNode leftParent = findParent(currentNode.left, targetNode);
        if (leftParent != null) {
            return leftParent;
        }

        return findParent(currentNode.right, targetNode);
    }

    private void swapValues(HeapNode node1, HeapNode node2) {
        int temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }

    private int countNodes(HeapNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public void delete(int value) {
        deleteHelper(root, value);
    }

    private HeapNode deleteHelper(HeapNode node, int value) {
        if (node == null) {
            return null;
        }

        if (node.value == value) {
            if (node == root) {
                root = null;
                return null;
            }

            // Find the deepest and rightmost node in the heap
            HeapNode deepestNode = findDeepestNode(root);
            node.value = deepestNode.value;

            // Find the parent of the deepest node and remove it
            HeapNode parent = findParent(root, deepestNode);
            if (parent.left == deepestNode) {
                parent.left = null;
            } else {
                parent.right = null;
            }

            // Perform heapify-down
            heapifyDown(node);

            return node;
        }

        HeapNode leftResult = deleteHelper(node.left, value);
        if (leftResult != null) {
            return leftResult;
        }

        return deleteHelper(node.right, value);
    }

    private HeapNode findDeepestNode(HeapNode node) {
        if (node.left == null && node.right == null) {
            return node;
        }

        if (countNodes(node.left) >= countNodes(node.right)) {
            return findDeepestNode(node.left);
        } else {
            return findDeepestNode(node.right);
        }
    }

    private void heapifyDown(HeapNode node) {
        HeapNode largest = node;

        if (node.left != null && node.left.value > largest.value) {
            largest = node.left;
        }

        if (node.right != null && node.right.value > largest.value) {
            largest = node.right;
        }

        if (largest != node) {
            swapValues(node, largest);
            heapifyDown(largest);
        }
    }
}

class Main {
    public static void main(String[] args) {
        LinkedHeap heap = new LinkedHeap();

        heap.insert(10);
        heap.insert(340);
        heap.insert(15);
        heap.insert(56);
        heap.insert(5);
        heap.insert(100);
        heap.insert(23);

        System.out.println("Heap elements after insertion:");
        printHeap(heap);

        // Delete an element from the heap
        heap.delete(20);

        System.out.println("Heap elements after deletion:");
        printHeap(heap);
    }

    private static void printHeap(LinkedHeap heap) {
        printHeapHelper(heap.root);
    }

    private static void printHeapHelper(HeapNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        printHeapHelper(node.left);
        printHeapHelper(node.right);
    }
}
