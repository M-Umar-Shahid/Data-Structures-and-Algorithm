public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int count = n; count >= 0; count--) {
            for (int index = 0; index < count - 1; index++) {
                if (arr[index] > arr[index + 1]) {
                    int temp = arr[index];
                    arr[index] = arr[index + 1];
                    arr[index + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 2, 1, 4 };
        System.out.println("Original Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        bubbleSort(arr);

        System.out.println("\nSorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
