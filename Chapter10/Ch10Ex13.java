abstract class Shape {
    private double side1;
    private double side2;
    private double side3;

    public Shape(double side1) {
        this.side1 = side1;
    }

    public Shape(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    public Shape(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public abstract double getArea();

    public String getName() {
        return getClass().getName();
    }

    @Override
    public String toString(){
        return "area = " + getArea();
    }
}

abstract class TwoDimensionalShape extends Shape {
    public TwoDimensionalShape(double side1) {
        super(side1);
    }

    public TwoDimensionalShape(double side1, double side2) {
        super(side1, side2);
    }

    public abstract double getArea();
}

abstract class ThreeDimensionalShape extends Shape {
    public ThreeDimensionalShape(double side1) {
        super(side1);
    }

    public ThreeDimensionalShape (double side1, double side2, double side3)	{
        super(side1, side2, side3);
    }

    public abstract double getArea();
    public abstract double getVolume();
}

class Circle extends TwoDimensionalShape {
    public Circle(double radius) {
        super(radius);
    }

    @Override
    public double getArea()
    {
        return (Math.pow(getSide1(), 2) * Math.PI);
    }

    @Override
    public String toString()
    {
        return "radius: " + getSide1();
    }

}

class Square extends TwoDimensionalShape {
    public Square(double side1) {
        super(side1);
    }

    @Override
    public double getArea()
    {
        return getSide1() * getSide1();
    }

    @Override
    public String toString()
    {
        return "length: " + getSide1();
    }
}

class Triangle10 extends TwoDimensionalShape {
    public Triangle10(double side1, double height) {
        super(side1, height);
    }

    @Override
    public double getArea()	{
        return getSide1() * getSide2() * 0.5;
    }

    @Override
    public String toString(){
        return "base: " + getSide1() + "\nheight: " + getSide2();
    }
}

class Tetrahedron extends ThreeDimensionalShape{
    public Tetrahedron (double side1, double side2, double height)	{
        super(side1, side2, height);
    }

    @Override
    public double getArea()	{
        return 4 * (0.5 * getSide1() * getSide2());
    }

    @Override
    public double getVolume()	{
        return ((0.5 * getSide1() * getSide2()) * getSide3())/3;
    }

    @Override
    public String toString()	{
        return "Side 1: " + getSide1() + "\nSide 2: " + getSide2() + "\nHeight: " + getSide3();
    }
}

class Cube extends ThreeDimensionalShape {
    public Cube(double length) {
        super(length);
    }

    @Override
    public double getArea() {
        return 6 * Math.pow(getSide1(), 2.0);
    }

    @Override
    public double getVolume() {
        return Math.pow(getSide1(), 3.0);
    }

    @Override
    public String toString() {
        return "length: " + getSide1();
    }
}

class Sphere extends ThreeDimensionalShape {
    public Sphere(double radius) {
        super(radius);
    }

    @Override
    public double getArea() {
        return 4 * (Math.pow(getSide1(), 2) * Math.PI);
    }

    @Override
    public double getVolume() {
        return Math.PI * 4/3 * Math.pow(getSide1(), 3.0);
    }

    @Override
    public String toString()	{
        return "radius: " + getSide1();
    }
}
public class Ch10Ex13 {
    public static void main(String[] args) {
        Shape[] shape = new Shape[6];
        shape[0] = new Circle(7);
        shape[1] = new Square(7);
        shape[2] = new Triangle10(4, 5);
        shape[3] = new Sphere(1);
        shape[4] = new Cube(1);
        shape[5] = new Tetrahedron(1.0, 1, 1);

        for (Shape currentShape : shape) {
            System.out.println(currentShape.getName());
            if (currentShape instanceof TwoDimensionalShape) {
                TwoDimensionalShape twoDimensionalShape = (TwoDimensionalShape) currentShape;
                System.out.printf("%s%nArea: %.2f\n\n",
                        twoDimensionalShape, twoDimensionalShape.getArea());

            } else if (currentShape instanceof ThreeDimensionalShape) {
                ThreeDimensionalShape threeDimensionalShape = (ThreeDimensionalShape) currentShape;
                System.out.printf("%s%nVolume: %.2f\n\n",
                        threeDimensionalShape, threeDimensionalShape.getVolume());
                System.out.printf("%s%nArea: %.2f\n\n",
                        threeDimensionalShape, threeDimensionalShape.getArea());
            }
        }
    }
}
