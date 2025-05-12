import java.util.Scanner;

public class test1 {
    private String courseName; // 实例变量

    public void setCourseName(String name) {
        courseName = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void displayCourseName() {
        String name = getCourseName();
        System.out.printf("This is %s", name);
    }
}
