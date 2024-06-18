public class BubbleSort {
    public static void main(String[] args) {
        int temp;
        int[] unSortedArray = { 3, 1, 7, 2, 6, -100, -23, 9, 45 };
        for (int i = 0; i < unSortedArray.length; i++) {
            for (int j = 0; j < unSortedArray.length; j++) {
                if (unSortedArray[j] > unSortedArray[i]) {
                    temp = unSortedArray[j];
                    unSortedArray[j] = unSortedArray[i];
                    unSortedArray[i] = temp;
                }
            }
        }

        // Printing sorted array
        for (int i = 0; i < unSortedArray.length; i++) {
            System.out.println(unSortedArray[i]);
        }
    }
}
