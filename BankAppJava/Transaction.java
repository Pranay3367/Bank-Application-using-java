import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    public enum Type { DEPOSIT, WITHDRAW }

    private final LocalDateTime timestamp;
    private final Type type;
    private final BigDecimal amount;
    private final BigDecimal balanceAfter;

    public Transaction(Type type, BigDecimal amount, BigDecimal balanceAfter) {
        this.timestamp = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("[%s] %-8s Amount: %s | Balance: %s",
                timestamp.format(fmt),
                type,
                amount.toPlainString(),
                balanceAfter.toPlainString());
    }
}

