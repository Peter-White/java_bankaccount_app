package skynet;

import java.util.ArrayList;

public class Bank {
	private String name;
	private ArrayList<Branch> branches;
	
	public Bank(String name) {
		this.name = name;
		this.branches = new ArrayList<Branch>();
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Branch> getBranches() {
		return branches;
	}

	public void addBranch(Branch branch) {
		getBranches().add(branch);
		System.out.println(branch.getName() + " added");
	}
	
	public Branch getBranch(int position) {
		return getBranches().get(position);
	}
	
	public void listBranches() {
		if(getBranches().size() > 0) {
			System.out.println("Branches:");
			for (int i = 0; i < getBranches().size(); i++) {
				System.out.println((i + 1) + ". " + getBranches().get(i).getName());
			}	
			System.out.println(getBranches().size() + " branches");
		} else {
			System.out.println("You have no branches. You are bankrupt.");
		}
	}
	
	public void updateBranch(String name, String newName) {
		int position = findBranch(name);
		
		String oldname = getBranches().get(findBranch(name)).getName();
		getBranches().get(position).setName(newName.toString());
		System.out.println("Branch " + oldname + " is now " + 
				getBranches().get(position).getName());
	}
	
	public void deleteBranch(int position) {
		String dead = getBranches().get(position).getName();
		getBranches().remove(position);
		System.out.println(dead + " removed");
	}
	
	public int findBranch(String name) {
		for (Branch branch : getBranches()) {
			String lowered = branch.getName().toLowerCase();
			if(lowered.equals(name.toLowerCase())) {
				return getBranches().indexOf(branch);
			}
		}
		return -1;
	}
	public int findBranch(Branch branch) {
		for (Branch branchInList : getBranches()) {
			if(branchInList.equals(branch)) {
				return getBranches().indexOf(branch);
			}
		}
		return -1;
	}
}
