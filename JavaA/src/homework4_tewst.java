public class homework4_tewst {
    public static void main(String[] args) {

//        //test for the Student class
//
//        Student student1 = new Student("12411036",'A',100);
//        System.out.println(student1.toString());
//
//        System.out.println("modifying information");
//        student1.setStudentNumber("12311036");
//        student1.setLab('X');
//        student1.setGrade(110);
//
//        System.out.println(student1.toString());
//
//            //println自动调用toString
//        System.out.println("\"System.out.println(student1.getStudentNumber());\" gives");
//        System.out.println(student1.getStudentNumber());
//        System.out.println("\"System.out.println(student1.getLab());\" gives");
//        System.out.println(student1.getLab());
//        System.out.println("\"System.out.println(student1.getGrade());\" gives");
//        System.out.println(student1.getGrade());
//        System.out.println("\"System.out.println(student1);\" gives");
//        System.out.println(student1);


    // test class Group
        //test checkSameLab

//        Student student4 = new Student("11240101",'B',100);

//        Group group2 = new Group(student2,student4,'A');
//        Group group3 = new Group(student3,'A');
//        Group group4 = new Group(student2,student3, 'B');
//        System.out.printf("two not-null, both in lab A, group lab is also A: %b\n",group1.checkSameLab());
//        System.out.printf("students in different labs: %b\n",group2.checkSameLab());
//        System.out.printf("only one student in a group: %b\n", group3.checkSameLab());
//        System.out.printf("students in the same class but student class different from group class: %b",group4.checkSameLab());
//
//        //check toString
//        System.out.println("check toString");
//        System.out.println("student1 < student2");
//        System.out.println(group1);
//        System.out.println("student1 > student2");
//        System.out.println(group2);
//        System.out.println("student2 = null");
//        System.out.println(group3);

//        Student student0 = new Student("0",'A',85); // valid student
        Student student1 = new Student("1",'A',80);
        Student student2 = new Student("2",'A',90);
//        Student student3 = new Student("3",'A',85);
        Student student4 = new Student("4",'B',88);
//        Student student5 = new Student("5",'A',78); // ungrouped
//        Student student6 = new Student("6",'A',88); // single, grouped
//
//        Group group0 = new Group(student0,'A');
        Group group1 = new Group(student2, student4, 'A'); // 2 overlapped ,2,3 ,4 invalid
        Group group2 = new Group(student1,student2,'A');
//        Group group3 = new Group(student1,student3,'A'); // 1 overlapped ,1,2,3 invalid
//        Group group4 = new Group(student6,'A');
//        Group group5 = new Group(student6,student1,'A');

        Student[] students = {student1, student2, student4};
        Group[] groups = {group1, group2};

        Student[] problem = GroupSystem.check(students, groups);
        for (int i = 0; i < problem.length; i++)
        {
            System.out.println(problem[i]);
        }
    }
}
