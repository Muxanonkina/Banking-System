import java.util.Scanner;
import enums.CreditPlane;

import modules.BusinessAccount;
import modules.Account;
import modules.SavingsAccount;
import modules.BusinessAccount;
import modules.BusinessStorage;
import modules.CreditAccount;

public class Main {

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
                System.out.println("=== Welcome to the Banking System ===");

                SavingsAccount savings = new SavingsAccount(0.0);
                CreditAccount credit = new CreditAccount("John", "Doe", "+998901234567", "john@gmail.com", 0.0);
                BusinessAccount business = new BusinessAccount("Jane", "Smith", "+998907654321", "jane@gmail.com");

                boolean running = true;
                while (running) {
                        System.out.println("\n=== MAIN MENU ===");
                        System.out.println("1. Savings Module.Account");
                        System.out.println("2. Credit Module.Account");
                        System.out.println("3. Business Module.Account");
                        System.out.println("0. Exit");
                        System.out.print("Choose option: ");

                        int choice = readInt();

                        switch (choice) {
                                case 1 -> savingsMenu(savings);
                                case 2 -> creditMenu(credit);
                                case 3 -> businessMenu(business);
                                case 0 -> {
                                        running = false;
                                        System.out.println("Goodbye!");
                                }
                                default -> System.out.println("Invalid option. Try again.");
                        }
                }
                scanner.close();
        }

        // ============ SAVINGS ACCOUNT MENU ============
        private static void savingsMenu(SavingsAccount account) {
                boolean back = false;
                while (!back) {
                        System.out.println("\n--- Savings Module.Account ---");
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Show balance");
                        System.out.println("0. Back");
                        System.out.print("Choose option: ");

                        int choice = readInt();

                        switch (choice) {
                                case 1 -> {
                                        System.out.print("Enter amount to deposit: ");
                                        double amount = readDouble();
                                        account.deposit(amount);
                                }
                                case 2 -> {
                                        System.out.print("Enter amount to withdraw: ");
                                        double amount = readDouble();
                                        account.withdraw(amount);
                                }
                                case 3 -> account.showBalance();
                                case 0 -> back = true;
                                default -> System.out.println("Invalid option. Try again.");
                        }
                }
        }

        // ============ CREDIT ACCOUNT MENU ============
        private static void creditMenu(CreditAccount credit) {
                boolean back = false;
                while (!back) {
                        System.out.println("\n--- Credit Module.Account ---");
                        System.out.println("1. Choose credit plan");
                        System.out.println("2. Take credit");
                        System.out.println("3. Pay credit");
                        System.out.println("4. Deposit (pay off debt)");
                        System.out.println("5. Withdraw (borrow money)");
                        System.out.println("6. Show debt");
                        System.out.println("7. Show balance");
                        System.out.println("0. Back");
                        System.out.print("Choose option: ");

                        int choice = readInt();

                        switch (choice) {
                                case 1 -> choosePlanMenu(credit);
                                case 2 -> {
                                        System.out.print("Enter amount to borrow: ");
                                        double amount = readDouble();
                                        credit.takeCredit(amount);
                                }
                                case 3 -> {
                                        System.out.print("Enter amount to pay: ");
                                        double amount = readDouble();
                                        credit.payCredit(amount);
                                }
                                case 4 -> {
                                        System.out.print("Enter amount to deposit: ");
                                        double amount = readDouble();
                                        credit.deposit(amount);
                                }
                                case 5 -> {
                                        System.out.print("Enter amount to withdraw: ");
                                        double amount = readDouble();
                                        credit.withdraw(amount);
                                }
                                case 6 -> credit.showDebt();
                                case 7 -> credit.showBalance();
                                case 0 -> back = true;
                                default -> System.out.println("Invalid option. Try again.");
                        }
                }
        }

        private static void choosePlanMenu(CreditAccount account) {
                System.out.println("\n-- Choose Credit Plan --");
                System.out.println("1. START   (limit $1000,   rate 20%)");
                System.out.println("2. STANDART (limit $10000,  rate 15%)");
                System.out.println("3. PREMIUM (limit $100000, rate 12%)");
                System.out.print("Choose plan: ");

                int choice = readInt();

                CreditPlane plan = switch (choice) {
                        case 1 -> CreditPlane.START;
                        case 2 -> CreditPlane.STANDART;
                        case 3 -> CreditPlane.PREMIUM;
                        default -> null;
                };

                account.chooseCreditPlan(plan);
        }

        // ============ BUSINESS ACCOUNT MENU ============
        private static void businessMenu(BusinessAccount account) {
                boolean back = false;
                while (!back) {
                        System.out.println("\n--- Business Module.Account ---");
                        System.out.println("1. Deposit to company");
                        System.out.println("2. Withdraw from company");
                        System.out.println("3. Transfer between companies");
                        System.out.println("4. Set transaction limit");
                        System.out.println("0. Back");
                        System.out.print("Choose option: ");

                        int choice = readInt();

                        switch (choice) {
                                case 1 -> {
                                        String company = readCompanyName("Enter company name: ");
                                        System.out.print("Enter amount to deposit: ");
                                        double amount = readDouble();
                                        account.deposit(company, amount);
                                }
                                case 2 -> {
                                        String company = readCompanyName("Enter company name: ");
                                        System.out.print("Enter amount to withdraw: ");
                                        double amount = readDouble();
                                        account.withdraw(company, amount);
                                }
                                case 3 -> {
                                        String from = readCompanyName("Enter source company: ");
                                        String to = readCompanyName("Enter destination company: ");
                                        System.out.print("Enter amount to transfer: ");
                                        double amount = readDouble();
                                        account.transfer(from, to, amount);
                                }
                                case 4 -> {
                                        String company = readCompanyName("Enter company name: ");
                                        System.out.print("Enter new limit: ");
                                        double limit = readDouble();
                                        account.setTransactionLimit(company, limit);
                                }
                                case 0 -> back = true;
                                default -> System.out.println("Invalid option. Try again.");
                        }
                }
        }

        // ============ INPUT HELPERS ============
        private static int readInt() {
                while (true) {
                        try {
                                int value = Integer.parseInt(scanner.nextLine().trim());
                                return value;
                        } catch (NumberFormatException e) {
                                System.out.print("Invalid number, try again: ");
                        }
                }
        }

        private static double readDouble() {
                while (true) {
                        try {
                                return Double.parseDouble(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                                System.out.print("Invalid number, try again: ");
                        }
                }
        }

        private static String readCompanyName(String prompt) {
                System.out.print(prompt);
                return scanner.nextLine().trim();
        }
}