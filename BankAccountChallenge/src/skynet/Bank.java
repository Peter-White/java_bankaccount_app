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

	public ArrayList<Branch> getBranches() {
		return branches;
	}

	public void addBranch(Branch branch) {
		getBranches().add(branch);
	}
	
	public void listBranches() {
		for (int i = 0; i < getBranches().size(); i++) {
			System.out.println(i + ". " + getBranches().get(i).getName());
		}
	}
	
	public int findBranch(String name) {
		for (Branch branch : getBranches()) {
			if(branch.getName().equals(name)) {
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
