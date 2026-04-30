class BankAccount {
    private int currentBalance;

    public BankAccount(int initialAmount) {
        currentBalance = initialAmount;
    }

    public int getBalance() {
        return currentBalance;
    }

    public synchronized void withdraw(int withdrawAmount) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " wants to withdraw " + withdrawAmount);

        if (currentBalance < withdrawAmount) {
            System.out.println(threadName + " withdrawal failed. Not enough balance.");
            return;
        }

        currentBalance = currentBalance - withdrawAmount;
        System.out.println(threadName + " successfully withdrew " + withdrawAmount);
        System.out.println("Remaining balance: " + currentBalance);
    }
}

class WithdrawTask implements Runnable {
    private BankAccount bankAccount;
    private int withdrawAmount;

    public WithdrawTask(BankAccount bankAccount, int withdrawAmount) {
        this.bankAccount = bankAccount;
        this.withdrawAmount = withdrawAmount;
    }

    public void run() {
        bankAccount.withdraw(withdrawAmount);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount acc = new BankAccount(1000);

        Thread t1 = new Thread(new WithdrawTask(acc, 700), "User-1");
        Thread t2 = new Thread(new WithdrawTask(acc, 500), "User-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final balance: " + acc.getBalance());
    }
}
