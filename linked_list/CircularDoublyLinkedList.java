import java.util.Scanner;

class Node {
    int data;
    Node prev, next;

    Node head = null, tail = null;

    public Node(Node prev, int data, Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    Node() {

    }

    
    public void insertNode(Scanner in) {
        System.out.println("Enter the no of data:");
        int n = in.nextInt();

        if (n < 1) {
            System.out.println("Invalid number of data");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the val:");
            int val = in.nextInt();

            Node obj = new Node(null, val, null);

            if (head == null) {
                head = obj;
            } else {
                tail.next = obj;
                obj.prev = tail;
            }

            tail = obj;
            head.prev = obj;
            obj.next = head;
        }

        System.out.println("Inserted successfully");
    }

    
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    
    void displayReverse() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = tail;

        do {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        } while (temp != tail);

        System.out.println();
    }

    
    void insertMiddle(Scanner in) {
        System.out.println("Enter the data:");
        int data = in.nextInt();

        System.out.println("Enter the position:");
        int pos = in.nextInt();

        if (pos < 1) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(null, data, null);

       
        if (head == null) {
            if (pos != 1) {
                System.out.println("Invalid position");
                return;
            }

            head = newNode;
            tail = newNode;
            newNode.prev = newNode;
            newNode.next = newNode;
        }

        
        else if (pos == 1) {
            newNode.prev = tail;
            newNode.next = head;

            head.prev = newNode;
            head = newNode;
            tail.next = head;
        }

        else {
            Node temp = head;

            for (int i = 0; i < pos - 2; i++) {
                if (temp == tail) {
                    System.out.println("Invalid position");
                    return;
                }

                temp = temp.next;
            }

            
            if (temp == tail) {
                newNode.prev = tail;
                newNode.next = head;

                tail.next = newNode;
                tail = newNode;
                head.prev = tail;
            }

            
            else {
                newNode.next = temp.next;
                newNode.prev = temp;

                temp.next.prev = newNode;
                temp.next = newNode;
            }
        }

        System.out.println("Inserted successfully");
    }

    
    void deleteNode(Scanner in) {
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

        Node temp = head;

        for (int i = 1; i < pos; i++) {
            temp = temp.next;

            if (temp == head) {
                System.out.println("Invalid position");
                return;
            }
        }

        
        if (head == tail) {
            head = null;
            tail = null;
        }

       
        else if (temp == head) {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }

        
        else if (temp == tail) {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }

        
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Deleted successfully");
    }
}

public class CircularDoublyLinkedList {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Node in = new Node();

        while (true) {
            System.out.println("1. Insert a node");
            System.out.println("2. Insert at any position");
            System.out.println("3. Delete a node");
            System.out.println("4. Display");
            System.out.println("5. Reverse Display");
            System.out.println("6. Exit");

            System.out.println("Enter your choice:");
            int ch = s.nextInt();

            switch (ch) {
                case 1: {
                    in.insertNode(s);
                    break;
                }

                case 2: {
                    in.insertMiddle(s);
                    break;
                }

                case 3: {
                    in.deleteNode(s);
                    break;
                }

                case 4: {
                    in.display();
                    break;
                }

                case 5: {
                    in.displayReverse();
                    break;
                }

            

                default: {
                    System.out.println("Invalid choice");
                }
            }
        }
    }
}