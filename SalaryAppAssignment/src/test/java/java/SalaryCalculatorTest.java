package java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SalaryCalculatorTest {

    private SalaryCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new SalaryCalculator();
    }

    @Test
    void testNormalSalaryCalculation() {
        assertEquals(53000,
                calculator.calculateSalary(50000, 5000, 2000));
    }

    @Test
    void testZeroBonus() {
        assertEquals(38000,
                calculator.calculateSalary(40000, 0, 2000));
    }

    @Test
    void testHighTax() {
        assertEquals(4000,
                calculator.calculateSalary(30000, 2000, 28000));
    }

    @Test
    void testNegativeBasicSalary() {
        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculateSalary(-10000, 2000, 1000));
    }

    @Test
    void testTaxGreaterThanBasic() {
        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculateSalary(20000, 2000, 30000));
    }

    @Test
    void testBoundaryValue() {
        assertEquals(1,
                calculator.calculateSalary(1, 0, 0));
    }
    
    private SalaryCalculator calculator2 = new SalaryCalculator();

    @ParameterizedTest
    @CsvSource({
            "50000, 5000, 2000, 53000",
            "40000, 0, 2000, 38000",
            "30000, 2000, 28000, 4000",
            "1, 0, 0, 1"
    })
    void testMultipleScenarios(double basic, double bonus,
                               double tax, double expected) {

        assertEquals(expected,
                calculator2.calculateSalary(basic, bonus, tax));
    }
}