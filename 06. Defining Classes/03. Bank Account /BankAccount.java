public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.2;
    private int id;
    private static int bankAccountCounter = 1;
    private double balance;
    private static double interestRate = DEFAULT_INTEREST_RATE;

    public BankAccount(){
        this.id = bankAccountCounter++;
    }
    public int getId() {
        return this.id;
    }

    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }

    public static double getGlobalInterest(){
        return interestRate;
    }
    public double getInterest(int years) {
        return BankAccount.interestRate * years * this.balance;
    }
    public void deposit(double amount) {
        this.balance += amount;
    }
}
