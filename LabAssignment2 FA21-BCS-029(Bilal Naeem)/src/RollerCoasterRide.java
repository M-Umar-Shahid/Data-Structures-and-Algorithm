import java.util.ArrayDeque;
import java.util.Queue;

public class RollerCoasterRide {
    private Queue<String> ridersQueue;
    private int adultCount;
    private int childCount;

    public RollerCoasterRide() {
        ridersQueue = new ArrayDeque<>();
        adultCount = 0;
        childCount = 0;
    }

    public void addRider(String rider) {
        ridersQueue.add(rider);
        if (isAdult(rider)) {
            adultCount++;
        } else {
            childCount++;
        }
        System.out.println(rider + " has joined the queue.");
        if (ridersQueue.size() >= 20) {
            startRide();
        }
    }

    private boolean isAdult(String rider) {
        return !rider.contains("Child");
    }

    private void startRide() {
        System.out.println("\nRide starting with the following riders:");
        while (!ridersQueue.isEmpty() && ridersQueue.size() <= 20) {
            String rider = ridersQueue.poll();
            System.out.println("- " + rider);
            if (isAdult(rider)) {
                adultCount--;
            } else {
                childCount--;
            }
        }
        System.out.println("Ride finished.\n");
    }

    public void processVIPFamily(String vipFamily) {
        Queue<String> tempQueue = new ArrayDeque<>();

        while (!ridersQueue.isEmpty()) {
            String rider = ridersQueue.poll();
            if (isVIPFamily(rider)) {
                System.out.println("Processing VIP family: " + vipFamily);
                System.out.println("- " + vipFamily + " is riding the roller coaster.");
                if (isAdult(vipFamily)) {
                    adultCount--;
                } else {
                    childCount--;
                }
                break;
            }
            tempQueue.add(rider);
        }

        while (!tempQueue.isEmpty()) {
            ridersQueue.add(tempQueue.poll());
        }
    }

    private boolean isVIPFamily(String rider) {
        return rider.contains("VIP");
    }

    public int getAdultCount() {
        return adultCount;
    }

    public int getChildCount() {
        return childCount;
    }

    public static void main(String[] args) {
        RollerCoasterRide rollerCoaster = new RollerCoasterRide();

        rollerCoaster.addRider("John");
        rollerCoaster.addRider("Lisa");
        rollerCoaster.addRider("Michael");
        rollerCoaster.addRider("Sarah Child");
        rollerCoaster.addRider("David");
        rollerCoaster.addRider("Emily");
        rollerCoaster.addRider("VIP Family");
        rollerCoaster.addRider("Daniel");
        rollerCoaster.addRider("Olivia");

        System.out.println("Adult count: " + rollerCoaster.getAdultCount());
        System.out.println("Child count: " + rollerCoaster.getChildCount());

        rollerCoaster.processVIPFamily("VIP Family");

        System.out.println("Adult count: " + rollerCoaster.getAdultCount());
        System.out.println("Child count: " + rollerCoaster.getChildCount());
        rollerCoaster.startRide();

    }
}
