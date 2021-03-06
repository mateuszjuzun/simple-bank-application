import java.util.ArrayList;

public class Bank {
    String name;
    ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();

    }


    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
        }
        return false;
    }

    public boolean addCustomer(String branchName, String name, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(name, amount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    private Branch findBranch(String name) {
        for (int i = 0; i < this.branches.size(); i++) {
            if (branches.get(i).getName().equals(name))
                return branches.get(i);
        }
        return null;
    }


    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customers details for branch " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();

            for (int i = 0; i < branchCustomers.size(); i++) {

                Customer branchCustomer = branchCustomers.get(i);

                System.out.println("Customer: " + branchCustomer.getName() + " " + "[" + (i + 1) + "]");
                if (showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;

        }
    }
}
