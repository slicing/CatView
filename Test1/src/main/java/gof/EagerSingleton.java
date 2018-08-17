package gof;
//单例模式
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    private String paw = " I yao eat you";

    private EagerSingleton(){}

    public static EagerSingleton getInstance(){
        return instance;
    }

    public String getPaw(){
        return paw;
    }


    public static void main(String[] args) {
        EagerSingleton single = EagerSingleton.getInstance();
        EagerSingleton singleton = new EagerSingleton();
        System.out.println(singleton.getPaw());
        System.out.println(single.getPaw());
    }
}
