package in.cg.salary;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeSalaryCalculatorTest {

    // Positive Test Case
    @Test
    void testValidSalaryCalculation() {
        EmployeeSalaryCalculator calc =
                new EmployeeSalaryCalculator(20000, 5000, 10);

        calc.validateSalary();

        assertEquals(4000, calc.calculateHRA());
        assertEquals(2000, calc.calculateDA());
        assertEquals(31000, calc.calculateGrossSalary());
        assertEquals(27900, calc.calculateNetSalary());
    }

    @Test
    void testHRA() {
        EmployeeSalaryCalculator calc =
                new EmployeeSalaryCalculator(10000, 0, 5);

        assertEquals(2000, calc.calculateHRA());
    }

    @Test
    void testDA() {
        EmployeeSalaryCalculator calc =
                new EmployeeSalaryCalculator(10000, 0, 5);

        assertEquals(1000, calc.calculateDA());
    }

    @Test
    void testGrossSalary() {
        EmployeeSalaryCalculator calc =
                new EmployeeSalaryCalculator(10000, 2000, 5);

        assertEquals(15000, calc.calculateGrossSalary());
    }

    @Test
    void testNetSalary() {
        EmployeeSalaryCalculator calc =
                new EmployeeSalaryCalculator(10000, 2000, 10);

        // Gross = 10000 + 2000 + 1000 + 2000 = 15000
        // Tax = 1500
        // Net = 13500
        assertEquals(13500, calc.calculateNetSalary());
    }

    // Negative Test Cases

    @Test
    void testBasicSalaryZero() {
        EmployeeSalaryCalculator calc =
                new EmployeeSalaryCalculator(0, 2000, 10);

        assertThrows(IllegalArgumentException.class,
                calc::validateSalary);
    }

    @Test
    void testNegativeSalary() {
        EmployeeSalaryCalculator calc =
                new EmployeeSalaryCalculator(-5000, 2000, 10);

        assertThrows(IllegalArgumentException.class,
                calc::validateSalary);
    }

    @Test
    void testInvalidTaxPercent() {
        EmployeeSalaryCalculator calc =
                new EmployeeSalaryCalculator(10000, 2000, 150);

        assertThrows(IllegalArgumentException.class,
                calc::validateSalary);
    }
}
