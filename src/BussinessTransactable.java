public interface BussinessTransactable {
    void deposit(String company,double amount);
    void withdraw(String company,double amount);
    void transfer(String from,String to,double amount);
    
}
