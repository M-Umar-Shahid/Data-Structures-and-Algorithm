
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}

class BST {
    Node root;

    // insertion method
    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node tempNode, int value) {
        if (tempNode == null) {
            return new Node(value);
        }

        if (value < tempNode.value) {
            tempNode.left = insertNode(tempNode.left, value);
        } else {
            tempNode.right = insertNode(tempNode.right, value);
        }

        return tempNode;
    }

    // searching for the specified value

    public boolean search(int value) {
        return search(root, value);
    }

    public boolean search(Node tempNode, int value) {
        if (tempNode == null) {
            return false;
        }
        if (tempNode.value == value) {
            return true;
        } else if (tempNode.value > value) {
            return search(tempNode.left, value);
        } else {
            return search(tempNode.right, value);
        }
    }

    // deletion for the specified value

    public void delete(int key) {
        root = deleteNode(root, key);
    }

    private Node deleteNode(Node tempNode, int key) {
        if (tempNode == null)
            return tempNode;

        if (key < tempNode.value)
            tempNode.left = deleteNode(tempNode.left, key);
        else if (key > tempNode.value)
            tempNode.right = deleteNode(tempNode.right, key);
        else {
            if (tempNode.left == null)
                return tempNode.right;
            else if (tempNode.right == null)
                return tempNode.left;

            tempNode.value = minValue(tempNode.right);

            tempNode.right = deleteNode(tempNode.right, tempNode.value);
        }
        return tempNode;
    }

    // finding the minimum value in the tree

    public int findMin() {
        return minValue(root);
    }

    private int minValue(Node root) {
        if (root.left != null) {
            return minValue(root.left);
        }
        return root.value;
    }

    public int findMax() {
        return maxValue(root);
    }
    // finding the maximum value in the tree

    private int maxValue(Node root) {
        int maxValue = root.value;
        while (root.right != null) {
            maxValue = root.right.value;
            root = root.right;
        }
        return maxValue;
    }

    // Traversal

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node tempNode) {
        if (tempNode != null) {
            traverseInOrder(tempNode.left);
            System.out.print(tempNode.value + " -> ");
            traverseInOrder(tempNode.right);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(8);
        tree.insert(12);
        tree.insert(18);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        tree.insert(9);
        tree.insert(11);
        tree.insert(14);
        tree.insert(16);
        tree.insert(20);

        System.out.print("In-order traversal: ");
        tree.traverseInOrder();
        System.out.println("null");
        int value1 = 9;
        int value2 = 13;
        System.out.println("For value = 9");
        System.out.println(tree.search(value1));
        System.out.println("For value = 13");
        System.out.println(tree.search(value2));

        tree.delete(5);
        System.out.println("After deleting 5");
        System.out.print("In-order traversal: ");
        tree.traverseInOrder();
        System.out.println("null");
        tree.delete(15);
        System.out.println("After deleting 15");
        System.out.print("In-order traversal: ");
        tree.traverseInOrder();
        System.out.println("null");
        System.out.println("Maximum value: " + tree.findMax());
        System.out.println("Minimum value: " + tree.findMin());

    }
}
