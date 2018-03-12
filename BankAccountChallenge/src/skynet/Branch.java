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

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	public void addCustomer(Customer customer, Double initial) {
		getCustomers().add(customer);
		getCustomers().get(findCustomer(customer)).addTransaction(initial);
	}
	
	public void listCustomers() {
		if(getCustomers().size() > 0) {
			for (int i = 0; i < getCustomers().size(); i++) {
				System.out.println((i + 1) + ". " + getCustomers().get(i).getName());
			}
			System.out.println(getCustomers().size() + " customers");			
		} else {
			System.out.println(getName() + 
					" has no customers. It will be terminated shortly.");
		}
	}
	
	public Customer openCustomer(int position) {
		return getCustomers().get(position);
	}
	
	public void updateCustomer(String name, String newName) {
		int position = findCustomer(name);
		
		String oldname = getCustomers().get(position).getName();
		getCustomers().get(position).setName(newName);

		System.out.println("Customer " + oldname
				+ " is now " + 
				getCustomers().get(position).getName());
	}
	
	public void deleteCustomer(int index) {
		String name = getCustomers().get(index).getName();
		getCustomers().remove(index);
		System.out.println(name + " removed");
	}
	
	public int findCustomer(String name) {
		for (Customer customer : getCustomers()) {
			String lowered = customer.getName().toLowerCase();
			if(lowered.equals(name.toLowerCase())) {
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
