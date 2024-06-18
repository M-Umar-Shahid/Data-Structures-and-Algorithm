
public class AVLTrees {
    Node root;

    class Node {
        int value;
        Node right;
        Node left;
        int height;

        Node(int value) {
            this.value = value;
            height = 1;
        }
    }

    public int max(Node left , Node right){
        return 
    }

    public int getHeight(Node root) {
        if (root == null) {
            return 0;
        } else {
            return root.left.height - root.right.height;
        }
    }

    public void insert(int val) {
        root = insertNode(root, val);
    }

    public Node insertNode(Node current, int val) {
        if (current == null) {
            return new Node(val);
        } else if (root.value > val) {
            current.left = insertNode(current.left, val);
        } else {
            current.right = insertNode(current.right, val);
        }
        current.height = 1 + max()
        if () {
            
        }




        return current;
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node currentNode) {
        if (currentNode != null) {
            traverseInOrder(currentNode.left);
            System.out.print(currentNode.value + " ");
            traverseInOrder(currentNode.right);
        }
    }

    public static void main(String[] args) throws Exception {

        AVLTrees tree = new AVLTrees();
        tree.insert(5);
        tree.insert(3);
        tree.insert(6);
        tree.insert(2);
        tree.insert(4);
        tree.insert(8);
        tree.insert(7);

        System.out.print("In-order traversal: ");
        tree.traverseInOrder();
    }
}
