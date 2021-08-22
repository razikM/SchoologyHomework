package homework7;

public class Main {

    public static void main(String[] args) {
        Main.printName(new Triangle());
        Main.printName(new Circle());
        Main.printName(new Quad());
        Main.printName(new Rectangle());
        Main.printName(new Square());
    }

    public static void printName(Shape shape) {
        System.out.println(shape.getName());
    }
}
