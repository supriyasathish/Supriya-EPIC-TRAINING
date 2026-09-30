import java.util.Scanner;

class Node {
    Node prev;
    int data;
    Node next;

    Node head = null, tail = null;

    Node(Node prev, int data, Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    Node() {

    }

    
    void insertData(Scanner in) {
        System.out.println("Enter the number of data:");
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter value:");
            int val = in.nextInt();

            Node obj = new Node(null, val, null);

            if (head == null) {
                head = obj;
                tail = obj;
            } else {
                obj.prev = tail;
                tail.next = obj;
                tail = obj;
            }
        }

        System.out.println("Successfully inserted");
    }


    void displayData() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    void insertANode(Scanner in) {
        System.out.println("Enter position:");
        int pos = in.nextInt();

        System.out.println("Enter value:");
        int val = in.nextInt();

        if (pos < 1) {
            System.out.println("Invalid position");
            return;
        }

        Node newnode = new Node(null, val, null);

    
        if (pos == 1) {
            newnode.next = head;

            if (head == null) {
                tail = newnode;
            } else {
                head.prev = newnode;
            }

            head = newnode;
        } else {
            Node temp = head;

            for (int i = 0; i < pos - 2; i++) {
                if (temp == null) {
                    System.out.println("Invalid position");
                    return;
                }

                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }

            newnode.prev = temp;
            newnode.next = temp.next;

            if (temp.next == null) {
                tail = newnode;
            } else {
                temp.next.prev = newnode;
            }

            temp.next = newnode;
        }

        System.out.println("Inserted successfully");
    }

    void deleteANode(Scanner in) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Enter position:");
        int pos = in.nextInt();

        if (pos < 1) {
            System.out.println("Invalid position");
            return;
        }

        Node temp = head;

        for (int i = 1; i < pos; i++) {
            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }

            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        
        if (temp.prev == null) {
            head = temp.next;
        } else {
            temp.prev.next = temp.next;
        }

        
        if (temp.next == null) {
            tail = temp.prev;
        } else {
            temp.next.prev = temp.prev;
        }

        System.out.println("Deleted successfully");
    }

    
    void reverseDisplay() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = tail;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }

        System.out.println();
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Node obj = new Node();

        while (true) {
            System.out.println("1. Insert Data");
            System.out.println("2. Display Data");
            System.out.println("3. Insert a Node at Any Position");
            System.out.println("4. Delete a Node at Any Position");
            System.out.println("5. Reverse Display");
            

            System.out.println("Enter your choice:");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    obj.insertData(in);
                    break;

                case 2:
                    obj.displayData();
                    break;

                case 3:
                    obj.insertANode(in);
                    break;

                case 4:
                    obj.deleteANode(in);
                    break;

                case 5:
                    obj.reverseDisplay();
                    break;

            

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}