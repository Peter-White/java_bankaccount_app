package skynet;

import java.util.ArrayList;

public class Branch {
	private String name;
	private ArrayList<Customer> customers;
	
	public Branch(String name) {
		this.name = name;
		this.customers = new ArrayList<Customer>();
	}

	public String getName() {
		return name;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	public void addCustomer(Customer customer) {
		getCustomers().add(customer);
	}
	
	public void listCustomers() {
		for (int i = 0; i < getCustomers().size(); i++) {
			System.out.println(i + ". " + getCustomers().get(i).getName());
		}
	}
	
	public int findCustomer(String name) {
		for (Customer customer : getCustomers()) {
			if(customer.getName().equals(name)) {
				return getCustomers().indexOf(customer);
			}
		}
		return -1;
	}
	public int findCustomer(Customer customer) {
		for (Customer customerInList : getCustomers()) {
			if(customerInList.equals(customer)) {
				return getCustomers().indexOf(customer);
			}
		}
		return -1;
	}
}
