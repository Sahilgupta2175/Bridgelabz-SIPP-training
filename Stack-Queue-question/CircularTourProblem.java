import java.util.Queue;
import java.util.LinkedList;

class CircularTourProblem {

    static class PetrolPump {
        int petrol;
        int distance;

        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static int circularTour(PetrolPump[] pumps) {
        int n = pumps.length;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.add(i);
        }

        int start = 0;
        int end = 1;
        int currentPetrol = pumps[start].petrol - pumps[start].distance;

        while (end != start || currentPetrol < 0) {
            while (currentPetrol < 0 && start != end) {
                currentPetrol -= pumps[start].petrol - pumps[start].distance;
                start = (start + 1) % n;

                if (start == 0) {
                    return -1;
                }
            }

            currentPetrol += pumps[end].petrol - pumps[end].distance;
            end = (end + 1) % n;
        }

        return start;
    }

    public static int findStartingPoint(PetrolPump[] pumps) {
        int n = pumps.length;
        int start = 0;
        int deficit = 0;
        int capacity = 0;

        for (int i = 0; i < n; i++) {
            capacity += pumps[i].petrol - pumps[i].distance;

            if (capacity < 0) {
                deficit += capacity;
                capacity = 0;
                start = i + 1;
            }
        }

        return (capacity + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(4, 6),
                new PetrolPump(6, 5),
                new PetrolPump(7, 3),
                new PetrolPump(4, 5)
        };

        int startPoint = findStartingPoint(pumps);

        if (startPoint == -1) {
            System.out.println("No circular tour possible");
        } else {
            System.out.println("Circular tour starts at pump: " + startPoint);
        }

        System.out.println("Pump details:");
        for (int i = 0; i < pumps.length; i++) {
            System.out.println("Pump " + i + ": Petrol=" + pumps[i].petrol + ", Distance=" + pumps[i].distance);
        }
    }
}
