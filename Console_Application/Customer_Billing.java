import java.util.Scanner;

class Customer {

    int cusId;
    String cusName;
    String cusPhNo;
    int cusAge;

    Customer[] cusArr = new Customer[100];
    int index = 0;

    Customer() {
    }

    Customer(int id, String n, String p, int a) {
        this.cusId = id;
        this.cusName = n;
        this.cusPhNo = p;
        this.cusAge = a;
    }

    void createCustomer(Scanner in) {

        if (index >= 100) {
            System.out.println("Customer limit reached");
            return;
        }

        System.out.println("Enter the Cus id:");
        int id = in.nextInt();
        in.nextLine();

        System.out.println("Enter the Cus name:");
        String name = in.nextLine();

        System.out.println("Enter the Cus phno:");
        String phno = in.nextLine();

        System.out.println("Enter the Cus age:");
        int age = in.nextInt();

        Customer cus = new Customer(id, name, phno, age);

        cusArr[index] = cus;
        index++;

        System.out.println("Customer Created Successfully");
    }

    void displayCustomer() {

        if (index == 0) {
            System.out.println("No Customer Found");
            return;
        }

        for (int i = 0; i < index; i++) {

            System.out.println("Customer ID: " + cusArr[i].cusId);
            System.out.println("Name: " + cusArr[i].cusName);
            System.out.println("Ph no: " + cusArr[i].cusPhNo);
            System.out.println("Age: " + cusArr[i].cusAge);
            System.out.println("-------------------------");
        }
    }

    void getCusByID(Scanner in) {

        if (index == 0) {
            System.out.println("No Customer Found");
            return;
        }

        System.out.println("Enter Customer ID:");
        int id = in.nextInt();

        boolean found = false;

        for (int i = 0; i < index; i++) {

            if (cusArr[i].cusId == id) {

                System.out.println("Customer ID: " + cusArr[i].cusId);
                System.out.println("Name: " + cusArr[i].cusName);
                System.out.println("Ph No: " + cusArr[i].cusPhNo);
                System.out.println("Age: " + cusArr[i].cusAge);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Customer not Found");
        }
    }
}


class Product {

    int proId;
    String proName;
    String proBrand;
    int proPrice;

    Product[] proArr = new Product[100];
    int index = 0;

    Product() {
    }

    Product(int id, String n, String b, int p) {
        this.proId = id;
        this.proName = n;
        this.proBrand = b;
        this.proPrice = p;
    }

    void createProduct(Scanner in) {

        if (index >= 100) {
            System.out.println("Product limit reached");
            return;
        }

        System.out.println("Enter the Pro Id:");
        int id = in.nextInt();
        in.nextLine();

        System.out.println("Enter the Pro name:");
        String name = in.nextLine();

        System.out.println("Enter the Pro brand:");
        String brand = in.nextLine();

        System.out.println("Enter the Pro price:");
        int price = in.nextInt();

        Product pro = new Product(id, name, brand, price);

        proArr[index] = pro;
        index++;

        System.out.println("Product Created Successfully");
    }

    void displayProduct() {

        if (index == 0) {
            System.out.println("No Product Found");
            return;
        }

        for (int i = 0; i < index; i++) {

            System.out.println("Product ID: " + proArr[i].proId);
            System.out.println("Name: " + proArr[i].proName);
            System.out.println("Brand: " + proArr[i].proBrand);
            System.out.println("Price: " + proArr[i].proPrice);
            System.out.println("-------------------------");
        }
    }

    Product getProductById(int id) {

        for (int i = 0; i < index; i++) {

            if (proArr[i].proId == id) {
                return proArr[i];
            }
        }

        return null;
    }

    void getProByID(Scanner in) {

        if (index == 0) {
            System.out.println("No Product Found");
            return;
        }

        System.out.println("Enter Product ID:");
        int id = in.nextInt();

        Product pro = getProductById(id);

        if (pro != null) {

            System.out.println("Product ID: " + pro.proId);
            System.out.println("Name: " + pro.proName);
            System.out.println("Brand: " + pro.proBrand);
            System.out.println("Price: " + pro.proPrice);

        } else {
            System.out.println("Product not Found");
        }
    }
}


class BillProduct {

    int proId;
    int proQua;

    int count = 0;

    BillProduct[] billproArr = new BillProduct[100];

    BillProduct() {
    }

    BillProduct(int id, int qua) {
        this.proId = id;
        this.proQua = qua;
    }
}


class Bill {

    Product pro;

    int billId;
    int cusId;
    int GrandTotal;

    BillProduct bpObj;

    Bill[] billArr = new Bill[100];
    int index = 0;

    Bill() {
    }

    Bill(Product p) {
        this.pro = p;
    }

    Bill(int billId, int cusId, BillProduct obj) {
        this.billId = billId;
        this.cusId = cusId;
        this.bpObj = obj;
    }

    void createBill(Scanner in) {

        if (index >= 100) {
            System.out.println("Bill limit reached");
            return;
        }

        System.out.println("Enter the customer id:");
        int id = in.nextInt();

        System.out.println("Enter the no of products:");
        int n = in.nextInt();

        if (n <= 0 || n > 100) {
            System.out.println("Invalid number of products");
            return;
        }

        BillProduct bp = new BillProduct();

        int grandtotal = 0;

        for (int i = 0; i < n; i++) {

            System.out.println("Enter the Product Id:");
            int proId = in.nextInt();

            Product product = pro.getProductById(proId);

            if (product == null) {
                System.out.println("Product Not Found");
                i--;
                continue;
            }

            System.out.println("Product Name: " + product.proName);
            System.out.println("Product Price: " + product.proPrice);

            System.out.println("Enter the Product quantity:");
            int proQua = in.nextInt();

            int amount = proQua * product.proPrice;

            grandtotal = grandtotal + amount;

            BillProduct bplist = new BillProduct(proId, proQua);

            bp.billproArr[i] = bplist;
        }

        bp.count = n;

        Bill bill = new Bill(index + 1, id, bp);

        bill.GrandTotal = grandtotal;

        billArr[index] = bill;

        index++;

        System.out.println("Grand Total: " + grandtotal);
        System.out.println("Bill Created Successfully");
    }

    void displayBill() {

        if (index == 0) {
            System.out.println("No Bill Found");
            return;
        }

        for (int i = 0; i < index; i++) {

            Bill temp = billArr[i];

            System.out.println("-------------------------");
            System.out.println("Bill ID: " + temp.billId);
            System.out.println("Customer ID: " + temp.cusId);

            BillProduct temppro = temp.bpObj;

            System.out.println("No of Product: " + temppro.count);

            for (int j = 0; j < temppro.count; j++) {

                int pId = temppro.billproArr[j].proId;
                int qty = temppro.billproArr[j].proQua;

                Product product = pro.getProductById(pId);

                System.out.println("Product ID: " + pId);
                System.out.println("Quantity: " + qty);
                System.out.println("Product Name: " + product.proName);
                System.out.println("Product Price: " + product.proPrice);

                int amount = qty * product.proPrice;

                System.out.println("Amount: " + amount);
            }

            System.out.println("Grand Total: " + temp.GrandTotal);
            System.out.println("-------------------------");
        }
    }

    void getBillByID(Scanner in) {

        if (index == 0) {
            System.out.println("No Bill Found");
            return;
        }

        System.out.println("Enter Bill ID:");
        int id = in.nextInt();

        boolean found = false;

        for (int i = 0; i < index; i++) {

            if (billArr[i].billId == id) {

                found = true;

                Bill temp = billArr[i];

                System.out.println("Bill ID: " + temp.billId);
                System.out.println("Customer ID: " + temp.cusId);

                BillProduct temppro = temp.bpObj;

                System.out.println("No of Product: " + temppro.count);

                for (int j = 0; j < temppro.count; j++) {

                    int pId = temppro.billproArr[j].proId;
                    int qty = temppro.billproArr[j].proQua;

                    Product product = pro.getProductById(pId);

                    System.out.println("Product ID: " + pId);
                    System.out.println("Quantity: " + qty);
                    System.out.println("Product Name: " + product.proName);
                    System.out.println("Product Price: " + product.proPrice);

                    int amount = qty * product.proPrice;

                    System.out.println("Amount: " + amount);
                }

                System.out.println("Grand Total: " + temp.GrandTotal);

                break;
            }
        }

        if (!found) {
            System.out.println("Bill Not Found");
        }
    }
}


public class Customer_Billing {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Customer cus = new Customer();

        Product pro = new Product();

        Bill bill = new Bill(pro);

        while (true) {

            System.out.println("\n===== CUSTOMER BILLING SYSTEM =====");

            System.out.println(
                    "1) Create Customer\n" +
                    "2) Display Customer\n" +
                    "3) Get Customer by ID\n" +
                    "4) Create Product\n" +
                    "5) Display Product\n" +
                    "6) Get Product by ID\n" +
                    "7) Buy Product\n" +
                    "8) Display Bill\n" +
                    "9) Get Bill By ID\n" +
                    "10) Exit"
            );

            System.out.print("Enter your choice: ");
            int n = in.nextInt();

            switch (n) {

                case 1:
                    cus.createCustomer(in);
                    break;

                case 2:
                    cus.displayCustomer();
                    break;

                case 3:
                    cus.getCusByID(in);
                    break;

                case 4:
                    pro.createProduct(in);
                    break;

                case 5:
                    pro.displayProduct();
                    break;

                case 6:
                    pro.getProByID(in);
                    break;

                case 7:
                    bill.createBill(in);
                    break;

                case 8:
                    bill.displayBill();
                    break;

                case 9:
                    bill.getBillByID(in);
                    break;

                case 10:
                    System.out.println("Thank you!");
                    in.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}