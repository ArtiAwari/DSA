class Node {
    char ch;
    int freq;
    Node left, right;

    // Constructor for leaf nodes
    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    // Constructor for internal nodes
    Node(int freq, Node left, Node right) {
        this.ch = '-'; // Indicates internal node
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}

public class SimpleHuffmanProg {

    // Function to print Huffman codes from the root node
    static void printCodes(Node root, String code) {
        if (root == null) return;

        // If leaf node, print character and code
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + ": " + code);
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    // Function to find index of the unused node with the smallest frequency
    static int findMinIndex(Node[] arr, boolean[] used, int size) {
        int minIndex = -1;
        for (int i = 0; i < size; i++) { // Only look at filled elements
            if (!used[i] && (minIndex == -1 || arr[i].freq < arr[minIndex].freq)) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freqs = {5, 9, 12, 13, 16, 45};

        int n = chars.length;
        Node[] arr = new Node[2 * n - 1]; // Total possible nodes
        boolean[] used = new boolean[2 * n - 1];

        // Step 1: Create leaf nodes
        for (int i = 0; i < n; i++) {
            arr[i] = new Node(chars[i], freqs[i]);
        }
        int size = n;

        // Step 2: Build Huffman tree without priority queue
        for (int i = 0; i < n - 1; i++) {
            int min1 = findMinIndex(arr, used, size);
            used[min1] = true;
            int min2 = findMinIndex(arr, used, size);
            used[min2] = true;

            // Create new parent node
            arr[size] = new Node(
                arr[min1].freq + arr[min2].freq,
                arr[min1],
                arr[min2]
            );
            size++;
        }

        // The last created node is the root
        Node root = arr[size - 1];

        // Step 3: Print Huffman codes
        System.out.println("Huffman codes:");
        printCodes(root, "");
    }
}
