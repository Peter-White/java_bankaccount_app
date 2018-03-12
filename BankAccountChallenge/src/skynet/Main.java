package skynet;

import java.util.Scanner;

public class Main {
	public static Scanner scanner = new Scanner(System.in);
	public static Bank wSW = new Bank("Wall Street Whaler");
   
	public static void main(String[] args) {
		boolean quit = false;
		int choice = 0;
		
		Branch orlando = new Branch("Orlando");
		wSW.addBranch(orlando);
		wSW.getBranches().get(wSW.findBranch(orlando))
			.addCustomer(new Customer("Goku"), 3.45);
		
		System.out.println("Welcome to " + wSW.getName());
		printBankInstructions();
		
		while (!quit) {			
			System.out.println("");
			System.out.println("Enter your choice:");
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
				case 0:
					printBankInstructions();
					break;
				case 1:
					listBrnaches();
					break;
				case 2:
					openBranch();
					break;
				case 3:
					createBranch();
					break;
				case 4:
					updateBranch();
					break;
				case 5:
					deleteBranch();
					break;
				case 6:
					System.out.println("Goodbye");
					quit = true;
					break;
				default:
					System.out.println("Invalid selection. Try Again.");
					break;
			}
		}
	}

	// Bank Options
	public static void printBankInstructions() {
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To view options.");
        System.out.println("\t 1 - To print the list of branches.");
        System.out.println("\t 2 - To open a branch's menu.");
        System.out.println("\t 3 - To add a new branch.");
        System.out.println("\t 4 - To update a branch's name.");
        System.out.println("\t 5 - To delete a branch.");
        System.out.println("\t 6 - To quit the application.");
	}
	
	public static void listBrnaches() {
		wSW.listBranches();
	}
	
	public static void createBranch() {
		System.out.println("Enter the name of the new branch (mind spelling and capitols)");
		String name = scanner.nextLine();
		if(wSW.findBranch(name) == -1) {
			Branch newBranch = new Branch(name);
			wSW.addBranch(newBranch);
		} else {
			System.out.println("Branch " + 
					wSW.getBranches().get(wSW.findBranch(name)).getName() + 
					" already exists");
		}
	}
	
	private static void updateBranch() {
		System.out.println("Enter branch name");
		String name = scanner.nextLine();
		if(wSW.findBranch(name) != -1) {
			System.out.println("Enter new branch name");
			String newName = scanner.nextLine();
			wSW.updateBranch(name, newName);
		} else {
			System.out.println("Branch not found");
		}
	}
	
	public static void deleteBranch() {
		System.out.println("Enter branch name");
		String name = scanner.nextLine();
		if(wSW.findBranch(name) != -1) {
			int position = wSW.findBranch(name);
			wSW.deleteBranch(position);
		} else {
			System.out.println("Branch not found");
		}
	}
	
	public static void openBranch() {
		System.out.println("Enter branch name");
		String name = scanner.nextLine();
		if(wSW.findBranch(name) != -1) {
			int position = wSW.findBranch(name);
			Branch currentBranch = wSW.getBranch(position);
			System.out.println(currentBranch.getName() + " branch");
			boolean branchBack = false;
			int branchChoice = 0;
			printBranchInstructions();
			
			while(!branchBack) {
				System.out.println("");
				System.out.println("Enter your choice:");
				branchChoice = scanner.nextInt();
				scanner.nextLine();
				
				switch(branchChoice) {
					case 0:
						printBranchInstructions();
						break;
					case 1:
						listCustomers(currentBranch);
						break;
					case 2:
						openCustomer(currentBranch);
						break;
					case 3:
						addCustomerToBranch(currentBranch);
						break;
					case 4:
						updateCustomerInBranch(currentBranch);
						break;
					case 5:
						deleteCustomerInBranch(currentBranch);
						break;
					case 6:
						System.out.println("Back To Bank");
						branchBack = true;
						break;
					default:
						System.out.println("Invalid selection. Try Again.");
						break;
				}
			}
		} else {
			System.out.println("Branch not found");
		}
	}
	
	// Branch Options
	public static void printBranchInstructions() {
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To view options.");
        System.out.println("\t 1 - To print the list of customers.");
        System.out.println("\t 2 - To open a customer's menu.");
        System.out.println("\t 3 - To add a new customer.");
        System.out.println("\t 4 - To update a customers's name.");
        System.out.println("\t 5 - To delete a customer.");
        System.out.println("\t 6 - To back to bank menu.");
	}
	
	public static void listCustomers(Branch branch) {
		branch.listCustomers();
	}
	
	public static void openCustomer(Branch branch) {
		System.out.println("Enter customer name");
		String name = scanner.nextLine();
		if(branch.findCustomer(name) != -1) {
			int position = branch.findCustomer(name);
			Customer currentCustomer = branch.getCustomers().get(position);
			System.out.println(currentCustomer.getName() + "'(s) account");
			boolean customerBack = false;
			int customerChoice = 0;
			printCustomerInstructions();
			
			while(!customerBack) {
				System.out.println("");
				System.out.println("Enter your choice:");
				customerChoice = scanner.nextInt();
				scanner.nextLine();
				
				switch(customerChoice) {
					case 0:
						printCustomerInstructions();
						break;
					case 1:
						listTransactions(currentCustomer);
						break;
					case 2:
						addCustomerTransaction(currentCustomer);
						break;
					case 3:
						deleteCustomerTransaction(currentCustomer);
						break;
					case 4:
						System.out.println("Back To Branch");
						customerBack = true;
						break;
					default:
						System.out.println("Invalid selection. Try Again.");
						break;
				}
			}
		} else {
			System.out.println("Branch not found");
		}
	}
	
	public static void addCustomerToBranch(Branch branch) {
		System.out.println("Enter the customer's name");
		String name = scanner.nextLine();
		if(branch.findCustomer(name) == -1) {
			System.out.println("Enter starting transaction");
			Double trans = scanner.nextDouble();
			Customer newCustomer = new Customer(name);
			branch.addCustomer(newCustomer, trans);
			System.out.println(name + " added to " + branch.getName() + " branch");
		} else {
			System.out.println(name + " already has account with " + branch.getName());
		}
	}
	
	public static void updateCustomerInBranch(Branch branch) {
		System.out.println("Enter the customer name");
		String name = scanner.nextLine();
		int position = branch.findCustomer(name);
		if(position != -1) {
			System.out.println("Enter new customer name");
			String newName = scanner.nextLine();
			branch.updateCustomer(name, newName);
		} else {
			System.out.println("Customer not found in " + branch.getName() + " branch");
		}
	}
	
	public static void deleteCustomerInBranch(Branch branch) {
		System.out.println("Enter the customer name");
		String name = scanner.nextLine();
		int position = branch.findCustomer(name);
		if(position != -1) {
			branch.deleteCustomer(position);
		} else {
			System.out.println("Customer not found in " + branch.getName() + " branch");
		}
	}
	
	// Customer Options
	public static void printCustomerInstructions() {
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To view options.");
        System.out.println("\t 1 - To print the list of transactions.");
        System.out.println("\t 2 - To add a new transaction.");
        System.out.println("\t 3 - To delete a transaction.");
        System.out.println("\t 4 - To back to branch menu.");
	}
	
	public static void listTransactions(Customer customer) {
		customer.listTransactions();
	}
	
	public static void addCustomerTransaction(Customer customer) {
		System.out.println("Enter Transaction Amount");
		Double trans = scanner.nextDouble();
		customer.addTransaction(trans);
	}
	
	private static void deleteCustomerTransaction(Customer customer) {
		System.out.println("Enter transaction index");
		int position = scanner.nextInt();
		customer.deleteTrans(position - 1);
	}
}
