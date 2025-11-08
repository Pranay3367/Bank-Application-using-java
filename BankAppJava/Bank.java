import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts = new HashMap<>();

    public Account createAccount(String name) {
        Account acc = new Account(name);
        accounts.put(name, acc);
        return acc;
    }

    public Account getAccount(String name) {
        return accounts.get(name);
    }
}
