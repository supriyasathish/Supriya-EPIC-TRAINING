package main;
import java.util.Scanner;


import controller.CustomerController;
public class BillingMain {
	public static void main(String[] args) {
		CustomerController cc = new CustomerController();
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.println("1.Create Customer \n 2.Display Customer \n 3.Change Name \n 4.Delete Name");
			int n=in.nextInt();
			switch(n) {
			case 1:{
				cc.createCustomer();
				break;
			}
			case 2:{
				cc.displayCustomer();
				break;
			}
			case 3:{
				cc.changeName();
				break;
			}
			case 4:{
				cc.deleteCustomer();
				break;
			}
		}
		}
	}
}




