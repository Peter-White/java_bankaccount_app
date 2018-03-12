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
						listCustomersList(currentBranch);
						break;
					case 2:
						System.out.println("Open");
						break;
					case 3:
						System.out.println("Add");
						break;
					case 4:
						System.out.println("Update");
						break;
					case 5:
						System.out.println("Delete");
						break;
					case 6:
						System.out.println("Back");
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
	
	public static void listCustomersList(Branch branch) {
		branch.listCustomers();
	}
	
	public static void addCustomerToBranch(Branch branch) {
		
	}
}
