import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node head = null, tail = null;

    public Node() {

    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    
    void insertData(Scanner in) {
        System.out.println("Enter the number of data:");
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the value:");
            int val = in.nextInt();

            insertInTail(val);
        }

        System.out.println("Successfully inserted");
    }

   
    public void insertInHead(int val) {
        Node newNode = new Node(val, head);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head = newNode;
        }

        tail.next = head;
    }

    
    public void insertInMiddle(int val, Node temp) {
        Node newNode = new Node(val, null);

        newNode.next = temp.next;
        temp.next = newNode;
    }

    
    public void insertInTail(int val) {
        Node newNode = new Node(val, head);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        tail.next = head;
    }

    
    void insertDataByPosition(Scanner in) {
        System.out.println("Enter the value:");
        int val = in.nextInt();

        System.out.println("Enter the position:");
        int pos = in.nextInt();

        if (pos < 1) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            insertInHead(val);
            System.out.println("Successfully inserted");
            return;
        }

        if (head == null) {
            System.out.println("Invalid position");
            return;
        }

        Node temp = head;

        for (int i = 0; i < pos - 2; i++) {
            if (temp == tail) {
                System.out.println("Invalid position");
                return;
            }

            temp = temp.next;
        }

        if (temp == tail) {
            insertInTail(val);
        } else {
            insertInMiddle(val, temp);
        }

        System.out.println("Successfully inserted");
    }

    
    void deleteANode(Scanner in) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Enter the position:");
        int pos = in.nextInt();

        if (pos < 1) {
            System.out.println("Invalid position");
            return;
        }

        
        if (pos == 1) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }

            System.out.println("Successfully deleted");
            return;
        }

        Node temp = head;

        
        for (int i = 0; i < pos - 2; i++) {
            if (temp == tail) {
                System.out.println("Invalid position");
                return;
            }

            temp = temp.next;
        }

        if (temp.next == head) {
            System.out.println("Invalid position");
            return;
        }

        
        if (temp.next == tail) {
            tail = temp;
        }

        
        temp.next = temp.next.next;

        System.out.println("Successfully deleted");
    }

    
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data );
            temp = temp.next;
        } while (temp != head);

        
    }
}

public class CircularSinglyLinkedList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Node li = new Node();

        while (true) {
            System.out.println("1. Insert Data");
            System.out.println("2. Insert at Any Position");
            System.out.println("3. Delete at Any Position");
            System.out.println("4. Display");
            

            System.out.println("Enter your choice:");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    li.insertData(in);
                    break;

                case 2:
                    li.insertDataByPosition(in);
                    break;

                case 3:
                    li.deleteANode(in);
                    break;

                case 4:
                    li.display();
                    break;

                

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}