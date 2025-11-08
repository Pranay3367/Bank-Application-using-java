import java.math.BigDecimal;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        Account acc = bank.createAccount("KOMMARAJULA PRANAY KUMAR");

        System.out.println("=== Console Bank App ===");

        while (true) {
            System.out.println("\n1) Deposit");
            System.out.println("2) Withdraw");
            System.out.println("3) Check Balance");
            System.out.println("4) View Transactions");
            System.out.println("0) Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        acc.deposit(sc.nextBigDecimal());
                        System.out.println("✅ Deposit successful!");
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        acc.withdraw(sc.nextBigDecimal());
                        System.out.println("✅ Withdrawal successful!");
                        break;
                    case 3:
                        System.out.println("💰 Current Balance: " + acc.getBalance());
                        break;
                    case 4:
                        System.out.println("📜 Transaction History:");
                        for (Transaction t : acc.getTransactions()) {
                            System.out.println(t);
                        }
                        break;
                    case 0:
                        System.out.println("👋 Exiting. Thank you!");
                        sc.close();
                        return;
                    default:
                        System.out.println("⚠️ Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
                sc.nextLine(); // clear invalid input
            }
        }
    }
}
