public class Test {
    public static void main(String[] args) {
       Time time1 = new Time(1, 4);
//        Time t2 = new Time(23,59);
//        System.out.println(time1);
//        System.out.println(t2);
//        time1.addMinutes(59);
//        System.out.println(time1);

//                String str = "Hello, World!";
//
//                // 方法一：使用 getClass().getName()
//                String fullClassName = str.getClass().getName();
//                System.out.println("完整类名: " + fullClassName);
//
//                // 方法二：使用 getClass().getSimpleName()
//                String simpleClassName = str.getClass().getSimpleName();
//                System.out.println("简单类名: " + simpleClassName);
//
//                // 方法三：使用 getClass().getCanonicalName()
//                String canonicalClassName = str.getClass().getCanonicalName();
//                System.out.println("规范类名: " + canonicalClassName);

//        System.out.println(Time.class.isInstance(time1));

            Vehicle c1 = new Car("A00000");
            Time arrivetime = new Time(0,0);
            Time leavetime = new Time(2,30);
            c1.setArriveTime(arrivetime);
            System.out.println(c1.calculateMoney(leavetime));

            }
        }

