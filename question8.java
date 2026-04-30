class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public synchronized void withdraw(int amount) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " wants to withdraw " + amount);

        if (balance < amount) {
            System.out.println(name + " failed. Not enough balance.");
            return;
        }

        balance -= amount;
        System.out.println(name + " withdrew " + amount);
        System.out.println("Remaining: " + balance);
    }
}

public class SyncBug {
    public static void main(String[] args) throws InterruptedException {
        Account acc = new Account(1000);

        Thread t1 = new Thread(() -> acc.withdraw(700), "User-1");
        Thread t2 = new Thread(() -> acc.withdraw(500), "User-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final balance: " + acc.getBalance());
    }
}
