import org.junit.*;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class NumberProcessorTest {
    private List<Integer> numbers;

    @Before
    public void setUp() {
        numbers = Arrays.asList(1, 4, 2, 3);
    }

    @Test
    public void testMin() {
        assertEquals(1, NumberProcessor._min(numbers));
    }

    @Test
    public void testMax() {
        assertEquals(4, NumberProcessor._max(numbers));
    }

    @Test
    public void testSum() {
        assertEquals(10, NumberProcessor._sum(numbers));
    }

    @Test
    public void testMult() {
        assertEquals(24, NumberProcessor._mult(numbers));
    }
}

