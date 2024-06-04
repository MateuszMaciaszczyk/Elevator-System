public class Main {
    public static void main(String[] args) {
        ElevatorSystem system = new ElevatorSystem(2);
        system.pickup(3, 7);
        system.pickup(5, 1);
        system.pickup(6, 4);
        system.pickup(3, 5);

        for (int i = 0; i < 15; i++) {
            system.step();
            System.out.println("Step " + i + ": " + system.status());
        }
    }
}
