package in.cg.salary;

public class EmployeeSalaryCalculator {

    private double basicSalary;
    private double bonus;
    private double taxPercent;

    // Constructor
    public EmployeeSalaryCalculator(double basicSalary, double bonus, double taxPercent) {
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        this.taxPercent = taxPercent;
    }

    // Validation
    public void validateSalary() {
        if (basicSalary <= 0) {
            throw new IllegalArgumentException("Basic salary must be greater than 0");
        }

        if (taxPercent < 0 || taxPercent > 100) {
            throw new IllegalArgumentException("Tax percent must be between 0 and 100");
        }
    }

    // HRA = 20% of Basic
    public double calculateHRA() {
        return 0.20 * basicSalary;
    }

    // DA = 10% of Basic
    public double calculateDA() {
        return 0.10 * basicSalary;
    }

    // Gross Salary = Basic + HRA + DA + Bonus
    public double calculateGrossSalary() {
        return basicSalary + calculateHRA() + calculateDA() + bonus;
    }

    // Net Salary = Gross - Tax Deduction
    public double calculateNetSalary() {
        double gross = calculateGrossSalary();
        double taxDeduction = (taxPercent / 100) * gross;
        return gross - taxDeduction;
    }
}
