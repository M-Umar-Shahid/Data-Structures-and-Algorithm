import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Tree1 {
    TreeNode root;

    // for Binary tree

    // public void insert(int val) {
    // root = insertNode(root, val);
    // }

    // private TreeNode insertNode(TreeNode currentNode, int val) {
    // if (currentNode == null) {
    // return new TreeNode(val);
    // }

    // if (currentNode.left == null) {
    // currentNode.left = insertNode(currentNode.left, val);
    // } else {
    // currentNode.right = insertNode(currentNode.right, val);
    // }

    // return currentNode;
    // }

    // for BST

    public void insert(int val) {
        root = insertNode(root, val);
    }

    private TreeNode insertNode(TreeNode currentNode, int val) {
        if (currentNode == null) {
            return new TreeNode(val);
        }

        if (val < currentNode.val) {
            currentNode.left = insertNode(currentNode.left, val);
        } else {
            currentNode.right = insertNode(currentNode.right, val);
        }

        return currentNode;
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(TreeNode currentNode) {
        if (currentNode != null) {
            traverseInOrder(currentNode.left);
            System.out.print(currentNode.val + " ");
            traverseInOrder(currentNode.right);
        }
    }

    public TreeNode BSTsearch(TreeNode root, int val) {
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return BSTsearch(root.left, val);
        } else {
            return BSTsearch(root.right, val);
        }
    }

    public static void main(String[] args) {
        Tree1 tree = new Tree1();
        Scanner sc = new Scanner(System.in);
        tree.insert(5);
        tree.insert(3);
        tree.insert(6);
        tree.insert(2);
        tree.insert(4);
        tree.insert(8);
        tree.insert(7);

        System.out.print("In-order traversal: ");
        tree.traverseInOrder();
        int val = sc.nextInt();
        System.out.println(tree.BSTsearch(tree.root, val).val);
        sc.close();
    }
}
