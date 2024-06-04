import java.util.*;

class ElevatorSystem implements ElevatorSystemInterface {
    private final List<Elevator> elevators;
    private final Queue<int[]> pickupRequests; // Kolejka przywołań (startFloor, endFloor)

    public ElevatorSystem(int numElevators) {
        elevators = new ArrayList<>();
        pickupRequests = new LinkedList<>();
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator(i, 0));
        }
    }

    public void pickup(int startFloor, int endFloor) {
        pickupRequests.add(new int[]{startFloor, endFloor});
    }

    public void update(int elevatorId, int currentFloor, int targetFloor) {
        elevators.get(elevatorId).update(currentFloor, targetFloor);
    }

    public void step() {
        handlePickupRequests();
        for (Elevator elevator : elevators) {
            elevator.step();
        }
    }

    private void handlePickupRequests() {
        Iterator<int[]> iterator = pickupRequests.iterator();

        while (iterator.hasNext()) {
            int[] request = iterator.next();
            int startFloor = request[0];
            int endFloor = request[1];

            Elevator closestElevator = null;
            int minDistance = Integer.MAX_VALUE;

            for (Elevator elevator : elevators) {
                if (elevator.isIdle()) {
                    int distance = Math.abs(elevator.currentFloor - startFloor);
                    if (distance < minDistance) {
                        minDistance = distance;
                        closestElevator = elevator;
                    }
                }
            }

            if (closestElevator != null) {
                closestElevator.addTarget(startFloor);
                closestElevator.addTarget(endFloor);
                iterator.remove();
            }
        }
    }

    public List<String> status() {
        List<String> statusList = new ArrayList<>();
        for (Elevator elevator : elevators) {
            statusList.add(elevator.status());
        }
        return statusList;
    }
}
