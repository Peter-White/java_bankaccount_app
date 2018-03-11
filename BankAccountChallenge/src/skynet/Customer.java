package skynet;

import java.util.ArrayList;

public class Customer {
	private String name;
	private ArrayList<Double> transactions;
	
	public Customer(String name) {
		this.name = name;
		this.transactions = new ArrayList<Double>();
	}

	public String getName() {
		return name;
	}

	public ArrayList<Double> getTransactions() {
		return transactions;
	}

	public void addTransaction(Double price) {
		getTransactions().add(price);
	}
	
	public void listTransaction() {
		for (int i = 0; i < getTransactions().size(); i++) {
			System.out.println(i + ". " + getTransactions().get(i));
		}
	}
}
