import java.util.*;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Operations {
    Node head = null;

    void insertBegin(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    void insertPosition(int data, int position) {
        if (position == 0) {
            insertBegin(data);
            return;
        }
        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++)
            temp = temp.next;
        if (temp == null) {
            System.out.println("Position out of range...");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteBegin() {
        if (head == null) {
            System.out.println("Empty list!");
            return;
        }
        System.out.println("Deleted node is: " + head.data);
        head = head.next;
    }

    void deleteEnd() {
        if (head == null) {
            System.out.println("Empty list!");
            return;
        }
        if (head.next == null) {
            System.out.println("Deleted node is: " + head.data);
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null)
            temp = temp.next;
        System.out.println("Deleted node is: " + temp.next.data);
        temp.next = null;
    }

    void deletePosition(int position) {
        if (head == null) {
            System.out.println("Empty list!");
            return;
        }
        if (position == 0) {
            deleteBegin();
            return;
        }
        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++)
            temp = temp.next;
        if (temp == null || temp.next == null) {
            System.out.println("Position out of range");
            return;
        }
        System.out.println("Deleted node is: " + temp.next.data);
        temp.next = temp.next.next;
    }

    void Display() {
        if (head == null) {
            System.out.println("Current List: Empty");
            return;
        }
        Node temp = head;
        System.out.print("Current List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    void reverseDisplay(Node node) {
        if (node == null)
            return;
        reverseDisplay(node.next);
        System.out.print(node.data + " -> ");
    }

    void printReverse() {
        if (head == null) {
            System.out.println("Reverse List: Empty");
            return;
        }
        System.out.print("Reverse List: ");
        reverseDisplay(head);
        System.out.println("null");
    }

    int countNodes() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    void removeDuplicates() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node current = head;
        while (current != null) {
            Node prev = current;
            Node runner = current.next;
            while (runner != null) {
                if (current.data == runner.data) {
                    prev.next = runner.next;
                } else {
                    prev = runner;
                }
                runner = runner.next;
            }
            current = current.next;
        }
        System.out.println("Duplicates removed.");
    }

    void sortList() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node current = head;
        while (current != null) {
            Node index = current.next;
            while (index != null) {
                if (current.data > index.data) {
                    int temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
        System.out.println("List sorted.");
    }

    int Search(int target) {
        Node temp = head;
        int pos = 0;
        while (temp != null) {
            if (temp.data == target) {
                System.out.println("Element found at location: " + pos);
                return pos;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println("Not found");
        return -1;
    }

    Node getHead() {
        return head;
    }
}

public class SinglyLinkedListApp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Operations o = new Operations();
        int choice, data, position, target;

        do {
            System.out.println("\n===== SINGLY LINKED LIST MENU =====");
            o.Display();  // Show current list
            System.out.println("1. Insert at Begin");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete from Position");
            System.out.println("7. Display List");
            System.out.println("8. Reverse Display");
            System.out.println("9. Count Nodes");
            System.out.println("10. Search");
            System.out.println("11. Sort List");
            System.out.println("12. Remove Duplicates");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at beginning: ");
                    data = s.nextInt();
                    o.insertBegin(data);
                    break;
                case 2:
                    System.out.print("Enter value to insert at end: ");
                    data = s.nextInt();
                    o.insertEnd(data);
                    break;
                case 3:
                    System.out.print("Enter value to insert: ");
                    data = s.nextInt();
                    System.out.print("Enter position to insert at (0-based): ");
                    position = s.nextInt();
                    o.insertPosition(data, position);
                    break;
                case 4:
                    o.deleteBegin();
                    break;
                case 5:
                    o.deleteEnd();
                    break;
                case 6:
                    System.out.print("Enter position to delete (0-based): ");
                    position = s.nextInt();
                    o.deletePosition(position);
                    break;
                case 7:
                    o.Display();
                    break;
                case 8:
                    o.printReverse();
                    break;
                case 9:
                    System.out.println("Total nodes: " + o.countNodes());
                    break;
                case 10:
                    System.out.print("Enter value to search: ");
                    target = s.nextInt();
                    o.Search(target);
                    break;
                case 11:
                    o.sortList();
                    break;
                case 12:
                    o.removeDuplicates();
                    break;
                case 13:
                    System.out.println("Exiting...");
                    s.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (true);
    }
}
