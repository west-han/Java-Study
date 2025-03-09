package advanced1.thread.sync;

public class WithdrawTask implements Runnable{

    private BankAccount account;
    private int amount;

    public WithdrawTask(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        boolean withdraw = account.withdraw(amount);
    }
}
