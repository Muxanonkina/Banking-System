package modules;

import interfaces.Transactable;

public class SavingsAccount  extends Account implements Transactable {

    private double balance;

public SavingsAccount(double balance){
    this.balance = balance;
}


    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        balance += amount;


        System.out.println("Deposited: $" + amount);
        System.out.println("Current balance: " + balance);
    }

@Override
    public void withdraw(double amount){
        if (amount <=0){
            System.out.println("Amount must be positive");
        return;
        }
        if (amount > balance){
            System.out.println("Insufficient funds. Balance: $" + balance);
        return;
        }
        balance -= amount;
}
@Override
    public void showBalance(){
    System.out.println("Current balance: $" + balance);
}

@Override
    public void showAccountType(){
    System.out.println("Savings Module.Account");
}
}
