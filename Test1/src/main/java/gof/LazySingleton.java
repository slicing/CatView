package gof;

public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton(){};
    public static LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
class LazyGGG{
    public static void main(String[] args) {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(lazySingleton);
    }
}
