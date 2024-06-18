public class Min {

    public int findMin(int... minArray) {
        int minimumValue = minArray[0];
        if (minArray.length == 1) {
            return minArray[0];
        }
        for (int i = 0; i < minArray.length; i++) {
            if (minimumValue > minArray[i]) {
                minimumValue = minArray[i];
            }
        }

        return minimumValue;
    }

}

class Main {
    public static void main(String[] args) {
        Min obj = new Min();
        int minimumValue = obj.findMin(3);
        System.out.println(minimumValue);
    }
}
