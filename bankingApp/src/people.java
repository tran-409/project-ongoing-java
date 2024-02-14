
public class people {

	private int id;
	private String name;
	private String email;
	private double balance;
	private int phoneNumber;
	
	
	
	public people(int id, String name, String email, double balance, int phoneNumber) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.balance = balance;
		this.phoneNumber = phoneNumber;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
