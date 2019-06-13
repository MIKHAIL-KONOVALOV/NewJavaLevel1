public class J1HomeWork2 {
    public static void main(String[] args) {
//          1  EXERCISE
        {
            int[] arr1 = {1, 0, 0, 1, 0, 1, 0, 1};
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (arr1[i] == 0 ? 1 : 0);
                System.out.print(arr1[i] + " ");
            }
            System.out.println();
        }
//          2 EXERCISE
        {
            int[] arr = new int[8];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i * 3;
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
//          3 EXERCISE
        {
            int[] arr = {1,5,3,2,11,4,5,2,4,8,9,1};
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (arr[i] < 6 ? arr[i] * 2 : arr[i]);
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
