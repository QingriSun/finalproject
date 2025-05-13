public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle(1);
        Circle c2 = new Circle(5);
        Circle c3 = new Circle(2, 0, 0);
        Circle c4 = new Circle(4, 1, 1);

        // test queue implementation
        Queue<Circle> queue = new Queue<Circle>();
        queue.enqueue(c1);
        queue.enqueue(c2);
        queue.enqueue(c3);
        queue.enqueue(c4);
        while(queue.hasItems()){
            System.out.println(queue.dequeue());
        }
    }
}
