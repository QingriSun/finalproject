import java.awt.*;

public class Circle extends Shape implements Comparable<Circle>, Shape.ColorDraw {
    private double radius;
    static final int DEFAULT_RADIUS = 5;

    public Circle(double radius, double x, double y) {
        super (x,y);
        this.radius = radius;
    }

    public Circle(double radius) {
        super (0,0);
        this.radius = radius;
    }

    public Circle(double x, double y) {
        super (x, y);
        this.radius = DEFAULT_RADIUS;
    }

    public void checkColor() {
        if (isInBoundary()) {
            this.setColor(ShapeColor.GREEN);
        } else {
            this.setColor(ShapeColor.RED);
        }
    }

    public boolean isInBoundary() {
        if (-1 * getScreenSize() > this.getX() - this.radius || getScreenSize() < this.getX() + this.radius) {
            return false;
        }
        if (-1 * getScreenSize() > this.getY() - this.radius || getScreenSize() < this.getY()+ this.radius) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + " x=" + getX() +
                ", y=" + getY() +
                ", color=" + getColor() +
                "}\n";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void draw() {

        StdDraw.setPenColor(this.getColor().getColor());
        StdDraw.filledCircle(getX(), getY(), radius);

    }

    @Override
    public void customizedColor(ColorScheme colorScheme, int index) {
        Color[] colorList = colorScheme.getColorScheme();
        if (index < 0){
            index = 0;
        }
        if (index >= colorList.length){
            index = index % colorList.length;
        }
        StdDraw.setPenColor(colorList[index]);
        StdDraw.filledCircle(getX(), getY(), radius);
    }


        @Override
        public int compareTo(Circle o) {
            if(this.radius < o.radius){
                return 1;
            }else if(this.radius > o.radius){
                return -1;
            }
            return 0;
        }

}
