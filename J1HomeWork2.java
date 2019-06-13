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
//          4 EXERCISE
        {
            final int N = 7; // Длинна квадрата
            int[][] square =new int[N][N];
            for (int i = 0; i < N; i++) {
                square[i][i] = 1;
                square[i][(N - i - 1)] = 1;
            }
            for (int i = 0; i < N ; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(square[i][j] + " ");
                }
                System.out.println();
            }
        }
//          5 EXERCISE
        {
            int[] arr = {2, 7, 156, -4, 35, -1, 0, 67, -56, 78};
            int min = arr[0], max = arr[0];
                for (int j = 0; j < arr.length; j++) {
                    if (min > arr[j])
                        min = arr[j];
                    if (max < arr[j])
                        max = arr[j];
                }
                System.out.println("Min = " + min + " Max = " + max);

        }
        int[] massive = {1,2,3,6,7,19,1,40};
        System.out.println(isArraySim(massive));
    }
    //          6 EXERCISE
    public static boolean isArraySim(int[] arr) {
        boolean result = false;
        int sumLeft , sumRight;
        for (int i = 0; i < arr.length; i++) {
            sumLeft = 0;
            sumRight = 0;
            for (int j = 0; j < i; j++) {
                sumLeft = sumLeft + arr[j];
            }
            for (int j = i; j < arr.length ; j++) {
                sumRight = sumRight + arr[j];
            }
            if (sumLeft == sumRight) {
                result = true;
                break;
            }
        }
            return result;
    }

}
