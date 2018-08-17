package gof;
//桥接
interface Color{
    void applyColor();

}
class RedColor implements Color{

    @Override
    public void applyColor() {
        System.out.println("red");
    }
}
class GreenColor implements Color{

    @Override
    public void applyColor() {
        System.out.println("green");
    }
}

abstract class Shape{
    Color color;
    Shape(Color c){
        this.color = c;
    }

    abstract public void applyColor();
}

class Triangle extends Shape{

    Triangle(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.println("Triangle with color");
        color.applyColor();
    }
}
class Circle extends Shape{

    Circle(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.println("Triangle with color");
        color.applyColor();
    }
}

public class DemoBridge {
    public static void main(String[] args) {
        Shape cir = new Circle(new RedColor());
        cir.applyColor();

        Shape single = new Triangle(new GreenColor());
        single.applyColor();
    }
}
