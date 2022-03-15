import java.util.ArrayList;

public class Customer {

    ArrayList<Double> transactions;
    String name;

    public Customer(String name, double initialAmount) {
          this.name = name;
          this.transactions = new ArrayList<Double>();
          addTransaction(initialAmount);
    }


    public void addTransaction(double amount) {
                  this.transactions.add(amount);
        }




    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public String getName() {
        return name;
    }
}
