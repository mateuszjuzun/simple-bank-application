import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;


    public boolean newCustomer(String customerName, double initialTransactionAmount) {

        if (findCustomer(customerName) == null) {
             this.customers.add(new Customer(customerName,initialTransactionAmount));
            return true;
        }  return false;
    }

    private Customer findCustomer(String name) {

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name))
                return customers.get(i);
        }
        return null;
    }

    private Customer findCustomer(Customer customer) {

        String searchedName = customer.getName();

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(searchedName))
                return customers.get(i);
        }
        return null;
    }

    public boolean addCustomerTransaction(String customerName, double transactionAmount) {
        Customer existingCustomer = findCustomer(customerName);
        if (findCustomer(customerName) != null) {
            existingCustomer.addTransaction(transactionAmount);
            return true;
        } return false;
    }

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getName() {
        return name;
    }
}
