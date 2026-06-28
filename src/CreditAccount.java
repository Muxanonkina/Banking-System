import java.util.Scanner;

public class CreditAccount extends Account implements Transactable {
private double debt;
private CreditPlane currentPlan;


CreditAccount(String name,String sureName,String tel,String gmail,double debt){
    super(name,sureName,tel,gmail);
    this.debt = debt;
}

void chooseCreditPlan(CreditPlane plan){

         if (plan != null) {
            this.currentPlan = plan;
            this.debt += plan.getCreditLimit();

            System.out.println("Credit plan activated: " + plan.name());
            System.out.println("Added to debt: $" + plan.getCreditLimit());
            System.out.println("Your interest rate: " + (plan.getInterestRate() * 100) + "%");
        } else {
            System.out.println("Invalid credit plan!");
        }
    }

void takeCredit(double debtSum){
    debt += debtSum;
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
    }
    if (debt == 0){
        System.out.println("No debt to pay");
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

}

}

@Override
    public void showBalance(){
    System.out.println("your balance = 0$");
}



}


