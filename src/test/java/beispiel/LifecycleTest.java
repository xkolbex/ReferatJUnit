package beispiel;

import org.junit.jupiter.api.*;

public class LifecycleTest {
    @BeforeAll
    static void init() {
        System.out.println("Vor allen Tests");
    }
    @BeforeEach
    void setUp() {
        System.out.println("Vor jedem Test");
    }
    @Test
    void test1() {
        System.out.println("Test 1");
    }
    @Test
    void test2() {
        System.out.println("Test 2");
    }
    @AfterEach
    void tearDown() {
        System.out.println("Nach jedem Test");
    }
    @AfterAll
    static void cleanUp() {
        System.out.println("Nach allen Tests");
    }
}
