package stream;

interface Coffee{
    void service(String shop, String name);
}

public class IceCoffee {
    public static void main(String[] args) {
        int size = 10;
        Coffee order = ((shop, name) -> System.out.println(shop + "  order: " + name + " size " + size));
        order.service("starbucks","latte");
    }
}
