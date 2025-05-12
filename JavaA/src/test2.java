import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        test1 myGradeBook = new test1();
        myGradeBook.setCourseName(name);
        myGradeBook.displayCourseName();
        scanner.close(); // 关闭 Scanner 资源
    }
}
