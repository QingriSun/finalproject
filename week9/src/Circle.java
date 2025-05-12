public class Circle extends Shape{
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
}
