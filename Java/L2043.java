import java.util.HashMap;
import java.util.Map;

class Bank {
    Map<Integer, Long> balances = new HashMap<>();

    public Bank(long[] balance) {
        for (int i = 0; i < balance.length; i++) {
            balances.put(i + 1, balance[i]);
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!balances.containsKey(account1) || !balances.containsKey(account2) || balances.get(account1) < money) {
            return false;
        }
        balances.put(account1, balances.get(account1) - money);
        balances.put(account2, balances.get(account2) + money);
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!balances.containsKey(account)) return false;
        balances.put(account, balances.get(account) + money);
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!balances.containsKey(account) || balances.get(account) < money) return false;
        balances.put(account, balances.get(account) - money);
        return true;
    }
}

public class L2043 {
    public static void main(String[] args) {
        Bank bank = new Bank(new long[]{10L, 100L, 20L, 50L, 30L});
        System.out.println(bank.withdraw(3, 10));    // 返回 true ，账户 3 的余额是 $20 ，所以可以取款 $10 。
        // 账户 3 余额为 $20 - $10 = $10 。
        System.out.println(bank.transfer(5, 1, 20)); // 返回 true ，账户 5 的余额是 $30 ，所以可以转账 $20 。
        // 账户 5 的余额为 $30 - $20 = $10 ，账户 1 的余额为 $10 + $20 = $30 。
        System.out.println(bank.deposit(5, 20));     // 返回 true ，可以向账户 5 存款 $20 。
        // 账户 5 的余额为 $10 + $20 = $30 。
        System.out.println(bank.transfer(3, 4, 15)); // 返回 false ，账户 3 的当前余额是 $10 。
        // 所以无法转账 $15 。
        System.out.println(bank.withdraw(10, 50));   // 返回 false ，交易无效，因为账户 10 并不存在。

        System.out.println(1);
    }
}
