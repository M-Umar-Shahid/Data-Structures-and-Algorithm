class Node {
    int value, height;
    Node left, right;

    Node(int value) {
        this.value = value;
        height = 1;
    }
}

public class AVL {
    Node root;

    // height of a node
    public int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // Get the maximum of two integers
    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Perform a right rotation
    public Node rightRotate(Node y) {

        Node x = y.left;
        Node T2 = x.right;

        // rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Perform a left rotation
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // balance factor of a node
    int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    // insertion of Node
    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        // Perform the normal BST insertion
        if (node == null)
            return new Node(value);

        if (value < node.value)
            node.left = insert(node.left, value);
        else if (value > node.value)
            node.right = insert(node.right, value);
        else
            return node;

        // Update the height of the ancestor node
        node.height = 1 + max(height(node.left), height(node.right));

        // Check the balance factor and rebalance if necessary
        int balance = getBalance(node);

        // Left-Left
        if (balance > 1 && value < node.left.value)
            return rightRotate(node);

        // Right-Right
        if (balance < -1 && value > node.right.value)
            return leftRotate(node);

        // Left-Right
        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // Right-Left
        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
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

    // In-order traversal
    public void inOrderTraversal() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value + " -> ");
            inOrder(node.right);
        }
    }

    public void delete(int value) {
        root = deleteNode(root, value);
    }

    public Node minValueNode(Node node) {
        Node temp = node;

        while (temp.left != null)
            temp = temp.left;

        return temp;
    }

    private Node deleteNode(Node node, int value) {
        if (node == null)
            return node;

        if (value < node.value)
            node.left = deleteNode(node.left, value);
        else if (value > node.value)
            node.right = deleteNode(node.right, value);
        else {
            if (node.left == null || node.right == null) {
                Node temp = null;
                if (temp == node.left)
                    temp = node.right;
                else
                    temp = node.left;

                if (temp == null) {
                    temp = node;
                    node = null;
                } else
                    node = temp;
            } else {
                Node temp = minValueNode(node.right);
                node.value = temp.value;
                node.right = deleteNode(node.right, temp.value);
            }
        }

        if (node == null)
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);

        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);

        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public static void main(String[] args) {
        AVL tree = new AVL();

        /* Constructing the AVL tree */
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

        /* Print the in-order traversal of the AVL tree */
        System.out.print("In-order traversal: ");
        tree.inOrderTraversal();
        System.out.println("null");
        int value1 = 9;
        int value2 = 13;
        System.out.println("For value = 9");
        System.out.println(tree.search(value1));
        System.out.println("For value = 13");
        System.out.println(tree.search(value2));

    }
}
