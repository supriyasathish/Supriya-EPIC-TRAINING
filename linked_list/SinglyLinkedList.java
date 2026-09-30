import java.util.Scanner;

class Customer {
    String cusName;
    String cusEmail;
    int id = 0;
    Node li;
    Scanner in;

    Customer(Node li, Scanner in) {
        this.li = li;
        this.in = in;
    }

    Customer(String name, String email, int id) {
        this.cusName = name;
        this.cusEmail = email;
        this.id = id;
    }

    void createCustomer() {
        System.out.println("Enter the customer Name:");
        String name = in.nextLine();

        System.out.println("Enter the customer Email:");
        String email = in.nextLine();

        id++;

        Customer cus = new Customer(name, email, id);

        li.insertData(in, cus);
        System.out.println("Customer created successfully");
    }

    void displayCustomer() {
        li.displayData();
    }

    void deleteCustomer() {
        li.deleteANode(in);
    }
}

class Node {
    Customer data;
    Node next;
    Node head = null, tail = null;

    Node(Customer data, Node add) {
        this.data = data;
        this.next = add;
    }

    Node() {

    }

    
    void insertData(Scanner in, Customer cus) {
        Node obj = new Node(cus, null);

        if (head == null) {
            head = obj;
            tail = obj;
        } else {
            tail.next = obj;
            tail = obj;
        }
    }

    
    void displayData() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.println("Customer ID: " + temp.data.id);
            System.out.println("Customer Name: " + temp.data.cusName);
            System.out.println("Customer Email: " + temp.data.cusEmail);
            

            temp = temp.next;
        }
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

        Node temp = head;

       
        if (pos == 1) {
            head = head.next;

            if (head == null) {
                tail = null;
            }

            System.out.println("Customer deleted successfully");
            return;
        }

       
        for (int i = 0; i < pos - 2; i++) {
            if (temp.next == null) {
                System.out.println("Invalid position");
                return;
            }

            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Invalid position");
            return;
        }

        
        if (temp.next == tail) {
            tail = temp;
        }

        temp.next = temp.next.next;

        System.out.println("Customer deleted successfully");
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Node li = new Node();
        Customer cus = new Customer(li, in);

        while (true) {
            System.out.println("\n1) Create Customer");
            System.out.println("2) Display Customer");
            System.out.println("3) Delete Customer");
        System.out.println("Enter your choice:");

            int n = in.nextInt();
            in.nextLine();

            switch (n) {
                case 1: {
                    cus.createCustomer();
                    break;
                }

                case 2: {
                    cus.displayCustomer();
                    break;
                }

                case 3: {
                    cus.deleteCustomer();
                    break;
                }

            

                default: {
                    System.out.println("Invalid choice");
                }
            }
        }
    }
}