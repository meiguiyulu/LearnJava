/**
 * @author LYJ
 * @create 2021-04-27 16:38
 * Java静态代理
 */
public class LearnThread2StaticProxy {
    public static void main(String[] args){
        new HouseProxy().rentHouse();
    }
}

//定义抽象接口

//出租房子
interface HouseSubject{
    public void rentHouse();
}

//房屋主人出租房子
class RealHouseSubject implements HouseSubject{
    @Override
    public void rentHouse() {
        System.out.println("我是房子主人，我要出租房子");
    }
}

//代理中介
class HouseProxy implements HouseSubject{
    @Override
    public void rentHouse() {
        ad();
        new RealHouseSubject().rentHouse();
        backad();
    }
    public void ad(){
        System.out.println("广告：xxx街道出租房子了");
    }
    public void backad(){
        System.out.println("房子已经出租了，现在要把广告撤销了");
    }
}
