import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MainTest {


    @Test
    void getItemCost() {
        assertEquals(4, Main.getItemCost(2, 2));

    }

    @Test
    void getTotalCost() {
        assertEquals(8, Main.getTotalCost(2, 4));
    }
}