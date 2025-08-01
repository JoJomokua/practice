//tree
package ADT;

public class BinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return;
        }

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                queue.add(current.left);
            }

            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public Node getRoot() {
        return root;
    }

    public int countNodes(Node node) {
        if (node == null)
            return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public boolean search(Node node, int key) {
        if (node == null)
            return false;
        if (node.data == key)
            return true;
        return search(node.left, key) || search(node.right, key);
    }

    public static void main(String[] args) {
        //create a binary tree
        BinaryTree tree = new BinaryTree();
//adding values to the tree
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
//show inorder traversal
        System.out.print("Inorder Traversal: ");
        tree.inorder(tree.getRoot());
//show preorder traversal
        System.out.print("\nPreorder Traversal: ");
        tree.preorder(tree.getRoot());
//show postorder traversal
        System.out.print("\nPostorder Traversal: ");
        tree.postorder(tree.getRoot());
//show root
        System.out.println("\nTotal Nodes: " + tree.countNodes(tree.getRoot()));
//search fn implementation
        int key = 30;
        System.out.println("Search " + key + ": " + tree.search(tree.getRoot(),key));
}

}
