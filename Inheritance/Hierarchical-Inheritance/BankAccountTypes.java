class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected String accountHolderName;
    protected String bankName;

    public BankAccount(String accountNumber, double balance, String accountHolderName, String bankName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
        this.bankName = bankName;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Bank: " + bankName);
        System.out.println("Balance: $" + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + ". New balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getBankName() {
        return bankName;
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;
    private int minBalance;

    public SavingsAccount(String accountNumber, double balance, String accountHolderName, 
                         String bankName, double interestRate, int minBalance) {
        super(accountNumber, balance, accountHolderName, bankName);
        this.interestRate = interestRate;
        this.minBalance = minBalance;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Minimum Balance: $" + minBalance);
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        displayAccountType();
    }

    public void calculateInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest added: $" + interest + ". New balance: $" + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= minBalance) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Withdrawal denied. Minimum balance requirement not met.");
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getMinBalance() {
        return minBalance;
    }
}

class CheckingAccount extends BankAccount {
    private double withdrawalLimit;
    private int transactionCount;

    public CheckingAccount(String accountNumber, double balance, String accountHolderName,
                          String bankName, double withdrawalLimit) {
        super(accountNumber, balance, accountHolderName, bankName);
        this.withdrawalLimit = withdrawalLimit;
        this.transactionCount = 0;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        System.out.println("Daily Withdrawal Limit: $" + withdrawalLimit);
        System.out.println("Transactions Today: " + transactionCount);
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        displayAccountType();
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= withdrawalLimit && balance >= amount) {
            balance -= amount;
            transactionCount++;
            System.out.println("Withdrawn $" + amount + ". New balance: $" + balance);
        } else if (amount > withdrawalLimit) {
            System.out.println("Withdrawal amount exceeds daily limit of $" + withdrawalLimit);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void writeCheck(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionCount++;
            System.out.println("Check written for $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds for check");
        }
    }

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public int getTransactionCount() {
        return transactionCount;
    }
}

class FixedDepositAccount extends BankAccount {
    private int termMonths;
    private double maturityAmount;
    private String maturityDate;

    public FixedDepositAccount(String accountNumber, double balance, String accountHolderName,
                              String bankName, int termMonths, double maturityAmount, String maturityDate) {
        super(accountNumber, balance, accountHolderName, bankName);
        this.termMonths = termMonths;
        this.maturityAmount = maturityAmount;
        this.maturityDate = maturityDate;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Term: " + termMonths + " months");
        System.out.println("Maturity Amount: $" + maturityAmount);
        System.out.println("Maturity Date: " + maturityDate);
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        displayAccountType();
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawal not allowed from Fixed Deposit before maturity");
    }

    public void prematureWithdrawal() {
        double penalty = balance * 0.02;
        balance -= penalty;
        System.out.println("Premature withdrawal with penalty of $" + penalty + ". Amount: $" + balance);
    }

    public void checkMaturity() {
        System.out.println("FD will mature on " + maturityDate + " with amount $" + maturityAmount);
    }

    public int getTermMonths() {
        return termMonths;
    }

    public double getMaturityAmount() {
        return maturityAmount;
    }

    public String getMaturityDate() {
        return maturityDate;
    }
}

public class BankAccountTypes {
    public static void main(String[] args) {
        System.out.println("=== Bank Account Types System ===\n");

        SavingsAccount savings = new SavingsAccount("SAV001", 5000, "John Doe", "ABC Bank", 3.5, 1000);
        CheckingAccount checking = new CheckingAccount("CHK001", 3000, "Jane Smith", "XYZ Bank", 500);
        FixedDepositAccount fd = new FixedDepositAccount("FD001", 10000, "Bob Johnson", "DEF Bank", 
                                                        12, 11000, "2026-07-01");

        System.out.println("1. Savings Account:");
        savings.displayAccountInfo();
        savings.calculateInterest();
        savings.withdraw(200);
        System.out.println();

        System.out.println("2. Checking Account:");
        checking.displayAccountInfo();
        checking.withdraw(300);
        checking.writeCheck(150);
        System.out.println();

        System.out.println("3. Fixed Deposit Account:");
        fd.displayAccountInfo();
        fd.withdraw(500);
        fd.checkMaturity();
        System.out.println();

        System.out.println("4. Account Summary:");
        BankAccount[] accounts = {savings, checking, fd};
        for (BankAccount account : accounts) {
            System.out.println(account.getAccountHolderName() + " - " + account.getAccountNumber() + 
                             " - Balance: $" + account.getBalance());
        }

        System.out.println("\n=== End of Bank Account Demo ===");
    }
}
