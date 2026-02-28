package com.assignment.day3;

import java.sql.*;
import java.util.Scanner;

public class MenuDrivenJDBC {

    private static final String URL = "jdbc:mysql://localhost:3306/capgemini_m1";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== JDBC MENU =====");
            System.out.println("1. Create Table");
            System.out.println("2. Insert Record");
            System.out.println("3. Read Records");
            System.out.println("4. Update Record");
            System.out.println("5. Delete Record");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> createTable();
                case 2 -> insertRecord(sc);
                case 3 -> readRecords();
                case 4 -> updateRecord(sc);
                case 5 -> deleteRecord(sc);
                case 6 -> System.out.println("Exiting application...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    // 1️⃣ Create Table
    private static void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS employee (
                    id INT PRIMARY KEY,
                    name VARCHAR(100),
                    salary DOUBLE
                )
                """;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Table created successfully.");

        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    // 2️⃣ Insert Record
    private static void insertRecord(Scanner sc) {

        String sql = "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, salary);

            int rows = ps.executeUpdate();
            System.out.println(rows + " record inserted.");

        } catch (SQLException e) {
            System.err.println("Insert Error: " + e.getMessage());
        }
    }

    // 3️⃣ Read Records
    private static void readRecords() {

        String sql = "SELECT * FROM employee";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\nID\tName\tSalary");
            System.out.println("-------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getDouble("salary")
                );
            }

        } catch (SQLException e) {
            System.err.println("Read Error: " + e.getMessage());
        }
    }

    // 4️⃣ Update Record
    private static void updateRecord(Scanner sc) {

        String sql = "UPDATE employee SET name = ?, salary = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.print("Enter ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Salary: ");
            double salary = sc.nextDouble();

            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Record updated successfully.");
            else
                System.out.println("Record not found.");

        } catch (SQLException e) {
            System.err.println("Update Error: " + e.getMessage());
        }
    }

    // 5️⃣ Delete Record
    private static void deleteRecord(Scanner sc) {

        String sql = "DELETE FROM employee WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            System.out.print("Enter ID to delete: ");
            int id = sc.nextInt();

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Record deleted successfully.");
            else
                System.out.println("Record not found.");

        } catch (SQLException e) {
            System.err.println("Delete Error: " + e.getMessage());
        }
    }
}
