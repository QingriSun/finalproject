package Lab9code.Lab9code;

public class Shape {
    private double x;
    private double y;
    private ShapeColor color = ShapeColor.GRAY;
    private static int screenSize = 10;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y + ", color=" + color;
    }
    //Add getter&setter methods for the private variable by yourself


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static int getScreenSize() {
        return screenSize;
    }

    public ShapeColor getColor() {
        return color;
    }

    public void setColor(ShapeColor color) {
        this.color = color;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static void setScreenSize(int screenSize) {
        Shape.screenSize = screenSize;
    }

}
