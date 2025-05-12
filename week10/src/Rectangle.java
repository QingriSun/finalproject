import java.awt.*;

public class Rectangle extends Shape implements Comparable<Rectangle>, Shape.ColorDraw {
	private double width;
	private double height;
	private double area;

	@Override
	public int compareTo(Rectangle rectangle)
	{
		double width = rectangle.getWidth();
		double height = rectangle.getHeight();
		double x = rectangle.getX();

		if (this.area < rectangle.getArea())
		{
			return  1;
		}
		else if (this.area > rectangle.getArea())
		{
			return -1;
		}
		else
		{
			if (this.getX() < x)
			{
				return  1;
			}
			else if (this.getX() > x)
			{
				return -1;
			}
		}
		return  0;
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
		draw();
	}

	public Rectangle(double x, double y, double width, double height) {
		super (x,y);
		this.width = width;
		this.height = height;
		this.area = width * height;

		System.out.printf("area = %.1f\n",area);
	}

	public void checkColor() {
		if (isInBoundary()) {
			this.setColor(ShapeColor.GREEN);
		} else {
			this.setColor(ShapeColor.RED);
		}
	}

	public boolean isInBoundary() {
		if (-1 * getScreenSize() > this.getX() - this.width / 2 || getScreenSize() < this.getX() + this.width / 2) {
			return false;
		}
		if (-1 * getScreenSize() > this.getY() - this.height / 2 || getScreenSize() < this.getY() + this.height / 2) {
			return false;
		}
		return true;
	}


	public double getArea()
	{
		return area;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width)
		{
		this.width = width;
	}

	public double getHeight()
	{
		return height;
	}

	public void setHeight(double height)
		{
		this.height = height;
	}

	public String toString() {
		return "Rectangle{" +
				"width=" + width +
				", height=" + height + " x=" + getX() +
				", y=" + getY() +
				", color=" + getColor() +
				", area = " + this.area +
				"}\n";
	}

	public void draw() {
//		StdDraw.setPenColor(getColor().getColor());
		StdDraw.filledRectangle(getX(), getY(), this.width / 2, this.height / 2);
	}

}


