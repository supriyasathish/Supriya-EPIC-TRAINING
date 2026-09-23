package controller;
import java.util.Scanner;

import java.util.*;

import model.Customer;
import services.CustomerService;
public class CustomerController implements CustomerService {
	ArrayList<Customer> cusArr = new ArrayList<>();
	int id = 0;
	
	public void createCustomer() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the cusName: ");
		String name = in.nextLine();
		System.out.println("Enter the cusPhone:");
		String Phno = in.nextLine();
	
		
		Customer c = new Customer(id,Phno,name);
		cusArr.add(c);
		System.out.println("Customer created Successfully");
		id++;
		
		
}
     public void displayCustomer() {
    	 for(Customer cc:cusArr) {
            System.out.println(cc.getName());
            System.out.println(cc.getPhno());
            System.out.println(cc.getId());
    	 }
     }
     
     public void changeName() {
    	 Scanner in=new Scanner(System.in);
    	 System.out.println("1.Name \n2.Phno");
    	 int n=in.nextInt();
    	 System.out.println("Enter the ID:");
    	 int id=in.nextInt();
    	 in.nextLine();
    	 switch(n) {
    	 case 1:
    	 {
        	 System.out.println("Enter name to change:");
        	 
        	 String name=in.nextLine();
        	 
        	 cusArr.get(id).setName(name);
        	 
        	 System.out.println("Name changed Successfully");
        	 break;
    	 }
    	 
    	 case 2:
    	 {
    		 System.out.println("Enter Phno to change:");
        	 
        	 String Phno=in.nextLine();
        	 
        	 cusArr.get(id).setPhno(Phno);
        	 
        	 System.out.println("Phno changed Successfully"); 
        	 break;
    	 }
    		 
    	 }	
     } 
    public void deleteCustomer() {
    	Scanner in=new Scanner(System.in);
    	System.out.println("Enter the ID:");
    	int id=in.nextInt();
    	int index=0;
    	for(Customer cus:cusArr) {
    		if(cus.getId()==id) {
    			cusArr.remove(index);
    			System.out.println("Customer removed successfully");
    			break;
    		}
    		index++;
    	}
    }
         
    	 
     
} 

