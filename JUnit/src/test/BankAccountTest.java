import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    @Test
    public void testDepositWithdraw() {
        BankAccount a = new BankAccount();
        a.deposit(100);
        assertEquals(100, a.getBalance());
        a.withdraw(30);
        assertEquals(70, a.getBalance());
    }

    @Test
    void testWithdrawInsufficient() {
        BankAccount a = new BankAccount();
        a.deposit(50);
        assertThrows(IllegalArgumentException.class, () -> a.withdraw(100));
    }
}
