import java.util.List;

public interface ElevatorSystemInterface {
    void pickup(int floor, int direction);
    void update(int elevatorId, int currentFloor, int targetFloor);
    void step();
    List<String> status();
}