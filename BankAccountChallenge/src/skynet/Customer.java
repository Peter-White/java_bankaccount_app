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
	
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Double> getTransactions() {
		return transactions;
	}

	public void updateTrans(int index, Double newTrans) {
		getTransactions().set(index, newTrans);
	}
	
	public void deleteTrans(int index) {
		String trans = getTransactions().get(index).toString();
		getTransactions().remove(index);
		System.out.println(trans + " removed");
	}
	
	public void addTransaction(Double price) {
		getTransactions().add(price);
		System.out.println(price + " added to " + getName() + " '(s) account");
	}
	
	public void listTransaction() {
		for (int i = 0; i < getTransactions().size(); i++) {
			System.out.println(i + ". " + getTransactions().get(i));
		}
	}
}
