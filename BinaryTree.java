import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class Operations {
    Node root = null;
    Scanner s = new Scanner(System.in);

    void insert() {
        System.out.print("Enter value you want to insert: ");
        int value = s.nextInt();
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            System.out.println("Inserted at root.");
            return;
        }

        Node current = root;
        while (true) {
            System.out.print("Exactly where do you want to insert the value? (Enter 0 for left or 1 for right): ");
            int choice = s.nextInt();

            if (choice == 0) {
                if (current.left == null) {
                    current.left = newNode;
                    System.out.println("Inserted to the left.");
                    break;
                } else {
                    current = current.left;
                }
            } else if (choice == 1) {
                if (current.right == null) {
                    current.right = newNode;
                    System.out.println("Inserted to the right.");
                    break;
                } else {
                    current = current.right;
                }
            } else {
                System.out.println("Invalid choice. Please enter 0 or 1.");
            }
        }
    }

    // Recursive search
    boolean search(Node node, int key) {
        if (node == null) return false;
        if (node.data == key) return true;
        return search(node.left, key) || search(node.right, key);
    }

    // Recursive height
    int height(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // In-order traversal (recursive)
    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    // In-order traversal (iterative)
    void inOrderIterative(Node node) {
        Stack<Node> stack = new Stack<>();
        Node current = node;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
    }

    // Pre-order traversal (recursive)
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Pre-order traversal (iterative)
    void preOrderIterative(Node node) {
        if (node == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.data + " ");

            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }

    // Post-order traversal (recursive)
    void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    // Post-order traversal (iterative)
    void postOrderIterative(Node node) {
        if (node == null) return;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(node);

        while (!stack1.isEmpty()) {
            Node curr = stack1.pop();
            stack2.push(curr);

            if (curr.left != null) stack1.push(curr.left);
            if (curr.right != null) stack1.push(curr.right);
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }

    void displayAllTraversals() {
        System.out.println("In-order (Recursive):");
        inOrder(root);
        System.out.println();

        System.out.println("In-order (Iterative):");
        inOrderIterative(root);
        System.out.println();

        System.out.println("Pre-order (Recursive):");
        preOrder(root);
        System.out.println();

        System.out.println("Pre-order (Iterative):");
        preOrderIterative(root);
        System.out.println();

        System.out.println("Post-order (Recursive):");
        postOrder(root);
        System.out.println();

        System.out.println("Post-order (Iterative):");
        postOrderIterative(root);
        System.out.println();
    }

    void searchValue() {
        System.out.print("Enter value to search: ");
        int key = s.nextInt();
        boolean found = search(root, key);
        System.out.println(found ? "Value found!" : "Value not found.");
    }

    void showHeight() {
        System.out.println("Tree height: " + height(root));
    }
}

public class BinaryTree {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        Operations o = new Operations();

        while (true) {
            System.out.println("\n1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Height");
            System.out.println("4. Display All Traversals");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    o.insert();
                    break;
                case 2:
                    o.searchValue();
                    break;
                case 3:
                    o.showHeight();
                    break;
                case 4:
                    o.displayAllTraversals();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
