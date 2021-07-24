package Homework7;

public class Main {
    private Shape shape;


    public Main(Shape shape){
        this.shape = shape;
    }

    public static void main(String[] args) {
        Main main = new Main(new Polygon());
//                    new Main(new Triangle());
//                    new Main(new Circle());
//                    new Main(new Quad());
//                    new Main(new Rectangle());
//                    new Main(new Square());
        main.printName();
    }

    public void printName(){
        System.out.println(shape.getName());
    }
}
