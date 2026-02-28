package java;

public class SalaryCalculator {

    public double calculateSalary(double basic, double bonus, double tax) {

        if (basic <= 0) {
            throw new IllegalArgumentException("Basic salary must be positive");
        }
        if (bonus < 0) {
            throw new IllegalArgumentException("Bonus cannot be negative");
        }
        if (tax < 0) {
            throw new IllegalArgumentException("Tax cannot be negative");
        }
        if (tax > basic) {
            throw new IllegalArgumentException("Tax cannot exceed basic salary");
        }

        double netSalary = basic + bonus - tax;

        if (netSalary < 0) {
            return 0;
        }
        return netSalary;
    }
}