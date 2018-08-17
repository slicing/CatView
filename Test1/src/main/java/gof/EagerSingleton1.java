package gof;
class EagerSing{
    private static final EagerSing instance = new EagerSing();
    private String paw = " I yao eat you";

    private EagerSing(){}

    public static EagerSing getInstance(){
        return instance;
    }

    public String getPaw(){
        return paw;
    }
        }
public class EagerSingleton1 {
    public static void main(String[] args) {
        EagerSing eagerSing = EagerSing.getInstance();
        //EagerSing eagerSing1 = new EagerSing();  单例模式，不能再次new。
        System.out.println(eagerSing.getPaw());
    }


}
