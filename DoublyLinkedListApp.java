import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedListOperations {
    Node head = null;

    void insertBegin(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
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
        newNode.prev = temp;
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
            System.out.println("Position out of range.");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null)
            temp.next.prev = newNode;
        temp.next = newNode;
    }

    void deleteBegin() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.println("Deleted: " + head.data);
        head = head.next;
        if (head != null)
            head.prev = null;
    }

    void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            System.out.println("Deleted: " + head.data);
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        System.out.println("Deleted: " + temp.data);
        temp.prev.next = null;
    }

    void deletePosition(int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (position == 0) {
            deleteBegin();
            return;
        }
        Node temp = head;
        for (int i = 0; i < position && temp != null; i++)
            temp = temp.next;
        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }
        System.out.println("Deleted: " + temp.data);
        if (temp.prev != null)
            temp.prev.next = temp.next;
        if (temp.next != null)
            temp.next.prev = temp.prev;
    }

    void display() {
        if (head == null) {
            System.out.println("Current List: Empty");
            return;
        }
        Node temp = head;
        System.out.print("Current List: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    void reverseDisplay() {
        if (head == null) {
            System.out.println("Reverse List: Empty");
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        System.out.print("Reverse List: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
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

    void sortList() {
        if (head == null) return;
        for (Node i = head; i.next != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.data > j.data) {
                    int temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
        System.out.println("List sorted.");
    }

    void removeDuplicates() {
        if (head == null) return;
        Node current = head;
        while (current != null) {
            Node runner = current.next;
            while (runner != null) {
                if (runner.data == current.data) {
                    Node next = runner.next;
                    if (runner.prev != null)
                        runner.prev.next = runner.next;
                    if (runner.next != null)
                        runner.next.prev = runner.prev;
                    runner = next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        System.out.println("Duplicates removed.");
    }

    void search(int data) {
        Node temp = head;
        int pos = 0;
        while (temp != null) {
            if (temp.data == data) {
                System.out.println("Element found at position: " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println("Element not found.");
    }
}

public class DoublyLinkedListApp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DoublyLinkedListOperations dll = new DoublyLinkedListOperations();
        int ch, data, position;

        do {
            System.out.println("\n====== DOUBLY LINKED LIST MENU ======");
            dll.display();  // show current list
            System.out.println("1. Insert at Begin");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete from Position");
            System.out.println("7. Display");
            System.out.println("8. Reverse Display");
            System.out.println("9. Count Nodes");
            System.out.println("10. Search");
            System.out.println("11. Sort List");
            System.out.println("12. Remove Duplicates");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value to insert at beginning: ");
                    data = s.nextInt();
                    dll.insertBegin(data);
                    break;
                case 2:
                    System.out.print("Enter value to insert at end: ");
                    data = s.nextInt();
                    dll.insertEnd(data);
                    break;
                case 3:
                    System.out.print("Enter value to insert: ");
                    data = s.nextInt();
                    System.out.print("Enter position (0-based): ");
                    position = s.nextInt();
                    dll.insertPosition(data, position);
                    break;
                case 4:
                    dll.deleteBegin();
                    break;
                case 5:
                    dll.deleteEnd();
                    break;
                case 6:
                    System.out.print("Enter position (0-based): ");
                    position = s.nextInt();
                    dll.deletePosition(position);
                    break;
                case 7:
                    dll.display();
                    break;
                case 8:
                    dll.reverseDisplay();
                    break;
                case 9:
                    System.out.println("Total nodes: " + dll.countNodes());
                    break;
                case 10:
                    System.out.print("Enter value to search: ");
                    data = s.nextInt();
                    dll.search(data);
                    break;
                case 11:
                    dll.sortList();
                    break;
                case 12:
                    dll.removeDuplicates();
                    break;
                case 13:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (ch != 13);
    }
}
