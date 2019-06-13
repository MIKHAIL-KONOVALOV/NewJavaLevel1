public class J1HomeWork2 {
    public static void main(String[] args) {
        int[] arr1 = {1,0,0,1,0,1,0,1};
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (arr1[i] == 0 ? 1 : 0);
            System.out.print(arr1[i] + " ");
        }

    }
}
