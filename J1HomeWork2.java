public class J1HomeWork2 {
    public static void main(String[] args) {
//        1  EXERCISE
        {
            int[] arr1 = {1, 0, 0, 1, 0, 1, 0, 1};
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (arr1[i] == 0 ? 1 : 0);
                System.out.print(arr1[i] + " ");
            }
            System.out.println();
        }
//        2 EEXRCISE
        {
            int[] arr = new int[8];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i * 3;
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

    }
}
