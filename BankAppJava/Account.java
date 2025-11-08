import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String holderName;
    private BigDecimal balance;
    private List<Transaction> transactions;

    public Account(String holderName) {
        this.holderName = holderName;
        this.balance = BigDecimal.ZERO;
        this.transactions = new ArrayList<>();
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance = balance.add(amount);
        transactions.add(new Transaction(Transaction.Type.DEPOSIT, amount, balance));
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount.compareTo(balance) > 0) {
            throw new IllegalArgumentException("Insufficient balance.");
        }
        balance = balance.subtract(amount);
        transactions.add(new Transaction(Transaction.Type.WITHDRAW, amount, balance));
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
