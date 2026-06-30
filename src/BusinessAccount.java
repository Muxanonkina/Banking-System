import java.util.HashMap;
import java.util.Map;

public class BusinessAccount extends Account implements LimitManagable,BussinessTransactable {

    private final Map<String, Double> businessMap = new HashMap<>();
    private final Map<String, Double> limitsMap = new HashMap<>();

    public BusinessAccount(String name, String sureName, String tel, String gmail) {
        super(name, sureName, tel, gmail);

        businessMap.put("IT company", 1000.0);
        businessMap.put("Restaurant business", 2000.0);
        businessMap.put("Holding business", 1000000.0);
        businessMap.put("Hotel business", 10000000.0);

        limitsMap.put("IT company", 5000.0);
        limitsMap.put("Restaurant business", 3000.0);
        limitsMap.put("Holding business", 10000000.0);
        limitsMap.put("Hotel business", 20000000.0);
    }

    @Override
    public void showAccountType() {
        System.out.println("Account: Business");
    }



    @Override
    public void setTransactionLimit(String company, double limit) {
        if (!limitsMap.containsKey(company)) {
            System.out.println("Company not found");
            return;
        }
        if (limit <= 0) {
            System.out.println("Limit must be positive");
            return;
        }
        if (limit < businessMap.get(company)) {
            System.out.println("New limit is below current balance");
            return;
        }
        limitsMap.put(company, limit);
        System.out.println("New limit for " + company + ": $" + limit);
    }

        @Override
    public void deposit(String companyName, double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive!");
            return;
        }
        if (!businessMap.containsKey(companyName)) {
            System.out.println("Company not found: " + companyName);
            return;
        }
        double current = businessMap.get(companyName);
        double limit = limitsMap.get(companyName);
        if (current + amount > limit) {
            System.out.println("Deposit limit exceeded for " + companyName
                    + ". Available: " + (limit - current));
            return;
        }
        double updated = current + amount;
        businessMap.put(companyName, updated);
        System.out.println("Deposited " + amount + " to " + companyName
                + ". New balance: " + updated);
    }

    @Override
    public void withdraw(String companyName, double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive!");
            return;
        }
        if (!businessMap.containsKey(companyName)) {
            System.out.println("Company not found: " + companyName);
            return;
        }
        double currentBalance = businessMap.get(companyName);
        if (amount > currentBalance) {
            System.out.println("Insufficient funds in " + companyName
                    + ". Balance: " + currentBalance);
            return;
        }
        double updated = currentBalance - amount;
        businessMap.put(companyName, updated);
        System.out.println("Withdrew " + amount + " from " + companyName
                + ". New balance: " + updated);
    }

    @Override
    public void transfer(String from, String to, double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive!");
            return;
        }
        if (!businessMap.containsKey(from)) {
            System.out.println("Source company not found: " + from);
            return;
        }
        if (!businessMap.containsKey(to)) {
            System.out.println("Destination company not found: " + to);
            return;
        }
        if (from.equals(to)) {
            System.out.println("Cannot transfer to the same company.");
            return;
        }
        double fromBalance = businessMap.get(from);
        if (fromBalance < amount) {
            System.out.println("Insufficient funds in " + from
                    + ". Balance: " + fromBalance);
            return;
        }
        businessMap.put(from, fromBalance - amount);
        businessMap.put(to, businessMap.get(to) + amount);
        System.out.println("Transferred " + amount + " from " + from + " to " + to);
    }


    
}