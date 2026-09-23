package model;

public  class Customer {
    private int id;
  private String Phno;
    private String name;
	 public Customer(int id, String phno, String name) {
		super();
		this.id = id;
		Phno = phno;
		this.name = name;
	 }
	 public int getId() {
		 return id;
	 }
	 public void setId(int id) {
		 this.id = id;
	 }
	 public String getPhno() {
		 return Phno;
	 }
	 public void setPhno(String phno) {
		 Phno = phno;
	 }
	 public String getName() {
		 return name;
	 }
	 public void setName(String name) {
		 this.name = name;
	 }
	 
	 }
     

