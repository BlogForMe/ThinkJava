package concurrency.thread.lagou.deadlock;


public class TransferMoney implements Runnable {
    int flag;
    static Account a = new Account(800);
    static Account b = new Account(600);

    static class Account {

        public Account(int balance) {
            this.balance = balance;
        }

        int balance;
    }

    @Override
    public void run() {
        if (flag == 1) {
            transferMoney(a, b, 200);
        }
        if (flag == 0) {
            transferMoney(b, a, 200);
        }
    }

    public static void transferMoney(Account from, Account to, int amount) {
        //先获取两把锁，然后开始转账
        int fromHash = System.identityHashCode(from);
        int toHash = System.identityHashCode(to);
        System.out.println(Thread.currentThread().getName() +  "  fromHash < toHash "+(fromHash < toHash));
        if (fromHash < toHash) {
            synchronized (from) {
                System.out.println(Thread.currentThread().getName() + " 获得锁A    " + from.balance);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                synchronized (to) {
                    System.out.println(Thread.currentThread().getName() + " 获得锁B    " + to.balance);

                    if (from.balance - amount < 0) {
                        System.out.println(Thread.currentThread().getName() + " 余额不足，转账失败。");
                        return;
                    }
//                    from.balance -= amount;
//                    to.balance += amount;
                    System.out.println(Thread.currentThread().getName() + " 成功转账" + amount + "元");
                }
            }
        } else if (fromHash > toHash) {
            synchronized (to) {
                System.out.println(Thread.currentThread().getName() + " 获得锁A    " + to.balance);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                synchronized (from) {
                    System.out.println(Thread.currentThread().getName() + " 获得锁B    " + from.balance);
                    if (from.balance - amount < 0) {
                        System.out.println(Thread.currentThread().getName() + "  余额不足，转账失败。");
                        return;
                    }
//                    from.balance -= amount;
//                    to.balance += amount;
                    System.out.println(Thread.currentThread().getName() + "   成功转账" + amount + "元");
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        TransferMoney r1 = new TransferMoney();
        TransferMoney r2 = new TransferMoney();
        r1.flag = 1;
        r2.flag = 0;
        Thread t1 = new Thread(r1, "t1");
        Thread t2 = new Thread(r2, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
//        System.out.println("a的余额" + a.balance);
//        System.out.println("b的余额" + b.balance);
    }
}
