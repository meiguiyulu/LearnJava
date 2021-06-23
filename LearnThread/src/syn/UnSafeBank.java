package syn;


/**
 * @author LYJ
 * @create 2021-04-30 11:03
 * 不安全的取钱
 * 两个人去银行取钱
 */
public class UnSafeBank {

    public static void main(String[] args) {
        Account account = new Account(1000, "结婚基金");
        Drawing you = new Drawing(account, 50);
        Drawing girlfriend = new Drawing(account, 100);

        new Thread(you, "自己").start();
        new Thread(girlfriend, "女朋友").start();
    }

}

//账户
class Account{
    int money;//余额
    String name;//卡号

    public Account(int money, String name){
        this.money = money;
        this.name = name;
    }
}

//银行：模拟取款
class Drawing implements Runnable {

    Account account; //账户
    int drawingMoney;//去了多少钱
    int nowMoney;//手里有多少钱

    public Drawing(Account account, int drawingMoney){
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    //取钱
    //synchronized默认锁的是this
    //应该锁住的对象是变化的量，即需要增删改的对象
    @Override
    public void run() {
        synchronized (account){
            //判断有没有钱
            if (account.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName() + "，余额不足，无法取钱");
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //取钱
            account.money = account.money - drawingMoney;
            nowMoney = nowMoney + drawingMoney;
            System.out.println(account.name + "余额为：" + account.money);
            System.out.println(Thread.currentThread().getName() + "手里的钱：" + nowMoney);
        }
    }
}
