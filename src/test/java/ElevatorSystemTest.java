import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElevatorSystemTest {
    private ElevatorSystem system;

    @BeforeEach
    void setUp() {
        system = new ElevatorSystem(2);
    }

    @Test
    void testPickup() {
        system.pickup(3, 7);
        system.pickup(5, 1);
        List<String> status = system.status();
        assertEquals(2, status.size());
    }

    @Test
    void testUpdate() {
        system.update(0, 0, 3);
        system.update(1, 0, 5);
        List<String> status = system.status();
        assertEquals("(0, 0, 3)", status.get(0));
        assertEquals("(1, 0, 5)", status.get(1));
    }

    @Test
    void testStep() {
        system.pickup(3, 7);
        system.pickup(5, 1);
        system.step();
        List<String> status = system.status();
        assertEquals("(0, 1, 3)", status.get(0));
        assertEquals("(1, 1, 5)", status.get(1));
    }

    @Test
    void testStatus() {
        system.pickup(3, 7);
        system.pickup(5, 1);
        List<String> status = system.status();
        assertEquals(2, status.size());
    }
}