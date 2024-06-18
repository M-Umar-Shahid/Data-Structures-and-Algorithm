public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int count = 0; count < n; count++) {
            int pos_min = count;
            for (int index = count; index < n; index++) {
                if (arr[index] < arr[pos_min]) {
                    pos_min = index;
                }
            }

            int temp = arr[pos_min];
            arr[pos_min] = arr[count];
            arr[count] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 2, 1, 4 };
        System.out.println("Original Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        selectionSort(arr);

        System.out.println("\nSorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}