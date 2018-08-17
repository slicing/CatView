package gof;

class DemoBillPughSingleton {

    private DemoBillPughSingleton(){};
    private static class SingletonHelper{
        private static final DemoBillPughSingleton INSTANCE = new DemoBillPughSingleton();
    }
    public static DemoBillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
public class BillPughSingleton{
    public static void main(String[] args) {
        DemoBillPughSingleton demoBillPughSingleton = DemoBillPughSingleton.getInstance();
        System.out.println(demoBillPughSingleton);
    }
}
