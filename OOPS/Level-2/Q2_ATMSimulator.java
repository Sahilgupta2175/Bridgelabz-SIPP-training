public class Q2_ATMSimulator {

    static class BankAccount {
        String accountHolder;
        String accountNumber;
        double balance;

        public BankAccount(String holder, String accNumber, double balance) {
            this.accountHolder = holder;
            this.accountNumber = accNumber;
            this.balance = balance;
        }

        public void deposit(double amount) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        }

        public void withdraw(double amount) {
            if (amount > balance) {
                System.out.println("Insufficient balance!");
            } else {
                balance -= amount;
                System.out.println("Withdrawn: ₹" + amount);
            }
        }

        public void displayBalance() {
            System.out.println("Current Balance: ₹" + balance);
        }
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Arjun Mehta", "AC4567", 10000);
        acc.deposit(2500);
        acc.withdraw(3000);
        acc.displayBalance();
    }
}
