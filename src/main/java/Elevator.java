import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

class Elevator {
    UUID id;
    int currentFloor;
    int targetFloor;
    Queue<Integer> targets;

    public Elevator(int id, int currentFloor) {
        this.id = UUID.randomUUID();
        this.currentFloor = currentFloor;
        this.targetFloor = currentFloor;
        this.targets = new LinkedList<>();
    }

    public void update(int currentFloor, int targetFloor) {
        this.currentFloor = currentFloor;
        this.targetFloor = targetFloor;
    }

    public void step() {
        if (currentFloor < targetFloor) {
            currentFloor++;
        } else if (currentFloor > targetFloor) {
            currentFloor--;
        } else if (!targets.isEmpty()) {
            targetFloor = targets.poll();
        }
    }

    public void addTarget(int floor) {
        targets.add(floor);
        if (targetFloor == currentFloor && targets.size() == 1) {
            targetFloor = targets.poll();
        }
    }

    public String status() {
        return String.format("(%s, %d, %d)", id.toString(), currentFloor, targetFloor);
    }

    public boolean isIdle() {
        return currentFloor == targetFloor && targets.isEmpty();
    }
}