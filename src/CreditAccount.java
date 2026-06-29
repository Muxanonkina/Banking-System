import java.util.Scanner;

public class CreditAccount extends Account implements Transactable {
private double debt;
private CreditPlane currentPlan;
private double creditLimit;

CreditAccount(String name,String sureName,String tel,String gmail,double debt){
    super(name,sureName,tel,gmail);
    this.debt = debt;
}

void chooseCreditPlan(CreditPlane plan){

         if (plan != null) {
            this.currentPlan = plan;

            System.out.println("Credit plan activated: " + plan.name());
            System.out.println("Added to debt: $" + plan.getCreditLimit());
            System.out.println("Your interest rate: " + (plan.getInterestRate() * 100) + "%");
        } else {
            System.out.println("Invalid credit plan!");
        }
    }

void takeCredit(double debtSum){
 if (currentPlan == null){
     System.out.println("Choose credit plan first");
     return;
 }
 if (debtSum <=0){
     System.out.println("Credit amount must be greater than 0.");
     System.out.println("Credit approved: $" + debtSum);
     System.out.println("Current debt: $" + debt);
 } else {
     System.out.println("Credit limit exceeded!");
 }

    if (debt + debtSum <= currentPlan.getCreditLimit()){
        debt += debtSum;
        System.out.println("Your credit plan increased to: " + debtSum);
    }
}

void payCredit(double paySum){

    if (paySum <= debt){
        debt -= paySum;
        System.out.println("Payment successful");
    } else {
        System.out.println("Payment is bigger than debt");
    }
}


 public void showDebt(){
    if(debt <=0){
        System.out.println("You do not credit which need to pay");
    } else {
        System.out.println("Your debt summ: " + debt);
    }
 }



@Override
    public void showAccountType(){
    System.out.println("Credit Account");
}

@Override
    public void deposit(double amount){
    if(amount <= 0){
        System.out.println("Error message, exit");
        return;
    }
    if (debt == 0){
        System.out.println("No debt to pay");
        return;
    }
    if (amount > debt){
        amount = debt;

    }
    debt -= amount;
    System.out.println("Your debt: " + debt);

}

@Override
    public void withdraw(double amount){
if (amount <= 0){
System.out.println("Write current number");
}
if (currentPlan == null){
    System.out.println("Current plan should be bigger than null");
}
    if (debt + amount > creditLimit) {
        System.out.println("Credit limit exceeded. Available: $" + (creditLimit - debt));
        return;
    }
    debt += amount;
    System.out.println("Withdrawn: $" + amount + ". Current debt: $" + debt);
}


    @Override
    public void showBalance() {
        System.out.println("Debt: $" + debt);
        System.out.println("Credit limit: $" + creditLimit);
        System.out.println("Available: $" + (creditLimit - debt));
    }

}



}


