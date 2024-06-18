import java.util.ArrayDeque;
import java.util.Queue;

class ThemePark {
    private Queue<Rider> queue;
    private int adultCount;
    private int childCount;

    public ThemePark() {
        queue = new ArrayDeque<>();
        adultCount = 0;
        childCount = 0;
    }

    public void lineUp(Rider[] members) {
        for (Rider member : members) {
            if (member.age >= 18) {
                adultCount++;
            } else {
                childCount++;
            }
            queue.add(member);
        }
    }

    public int countAdults() {
        return adultCount;
    }

    public int countChildren() {
        return childCount;
    }

    public void processVIPFamily(Rider[] vipFamily) {
        for (Rider member : vipFamily) {
            if (member.age >= 18) {
                adultCount++;
            } else {
                childCount++;
            }
            queue.add(member);
        }
    }

    public void processRide() {
        if (queue.size() >= 20) {
            System.out.println("Ride started with 20 members.");
            for (int i = 0; i < 20; i++) {
                Rider rider = queue.poll();
                System.out.println("Processing rider: " + rider.name);
            }
        } else {
            System.out.println("Not enough members in the queue to start the ride.");
        }
    }
}

class Rider {
    public String name;
    public int age;

    public Rider(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Main1 {
    public static void main(String[] args) {
        ThemePark themePark = new ThemePark();

        Rider[] riders1 = {
                new Rider("John", 25),
                new Rider("Mary", 12),
                new Rider("David", 17),
                new Rider("Alice", 19)
        };

        themePark.lineUp(riders1);

        Rider[] riders2 = {
                new Rider("Mike", 30),
                new Rider("Emily", 7),
                new Rider("Daniel", 16),
                new Rider("Sophia", 18)
        };

        themePark.lineUp(riders2);

        Rider[] vipFamily = {
                new Rider("VIP1", 35),
                new Rider("VIP2", 40),
                new Rider("VIP3", 10),
                new Rider("VIP4", 14)
        };

        themePark.processVIPFamily(vipFamily);

        themePark.processRide();
        System.out.println("Adult count: " + themePark.countAdults());
        System.out.println("Child count: " + themePark.countChildren());
    }
}
