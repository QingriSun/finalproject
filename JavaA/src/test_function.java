public class test_function {
    public static void main(String[] args) {
   int[] array = {1,2,3};
//   array = {3,4,5}; is not allowed
   int[] array1 = new int[3];
   array1 = array;
   for (int i = 0; i < array.length; i++)
   {
       System.out.println(array[i]);
       System.out.println(array1[i]);
   }
    }


}
////3
////        7
//12 45 -1 37 95 30 -1
//        -1 -1 62 -1 36 0 -1
//        24 61 79 49 77 2 -1
