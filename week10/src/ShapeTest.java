
import java.util.ArrayList;


public class ShapeTest {
    public static void main(String[] args) {
        ArrayList<Circle> circleList = new ArrayList<Circle>();
        Shape.setScreenSize(14);
        StdDraw.setScale(-Shape.getScreenSize(), Shape.getScreenSize());
        for (int i = 1; i < Shape.getScreenSize(); i += 2) {
            circleList.add(new Circle(Shape.getScreenSize()-i, 0, -Shape.getScreenSize()));
        }

        for (int i = 0; i < circleList.size(); i++) {
            circleList.get(i).customizedColor(ColorScheme.RAINBOW, i);
        }
    }
}
