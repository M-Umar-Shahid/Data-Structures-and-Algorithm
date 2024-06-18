
import java.util.Scanner;

//Using Non-recursive method

// class Node {
//     Node right;
//     Node left;
//     int value;

//     Node(int value) {
//         this.value = value;
//         left = right = null;
//     }
// }

// public class Tree {
//     Node root;

//     public void traverseTree(Node node) {
//         if (node != null) {
//             traverseTree(node.left);
//             System.out.println(" " + node.value);
//             traverseTree(node.right);
//         }
//     }

//     public static void main(String[] args) {
//         Tree tree = new Tree();
//         tree.root = new Node(1);
//         tree.root.left = new Node(2);
//         tree.root.right = new Node(3);
//         tree.root.left.left = new Node(4);
//         tree.traverseTree(tree.root);
//     }
// }

//Using Arrays

class Tree {
    int[] treeArray;

    public TreeNode createTree(int index) {
        TreeNode temp = null;
        if (treeArray[index] != 0) {
            temp.data = treeArray[index];
            temp.left = createTree(2 * index + 1);
            temp.right = createTree(2 * index + 2);
        }
        return temp;
    }
}

class TreeNode {
    int data;
    TreeNode right;
    TreeNode left;

    TreeNode(int data) {
        this.data = data;
    }
}

class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the height of the tree : ");
        int height = sc.nextInt();
        int arraySize = (int) Math.pow(2, height + 1) - 1;
        tree.treeArray = new int[arraySize];
        for (int i = 0; i < tree.treeArray.length; i++) {
            System.out.println("Enter the values in the tree : ");
            tree.treeArray[i] = sc.nextInt();
        }
        tree.createTree(0);
        sc.close();
    }
}