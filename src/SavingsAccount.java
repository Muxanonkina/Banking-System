public class SavingsAccount  implements Transactable  {

    public double debt;




    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        if (debt <= 0) {
            System.out.println("You have no debt.");
            return;
        }

        if (amount > debt) {
            amount = debt;
        }

        debt -= amount;

        System.out.println("Payment: " + amount);
        System.out.println("Remaining debt: " + debt);
    }

@Override
    public void withdraw(double amount){
        System.out.println("Saving account");
}
@Override
    public void showBalance(){}


}
