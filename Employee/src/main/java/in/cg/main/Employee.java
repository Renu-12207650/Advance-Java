package in.cg.main;

import org.springframework.stereotype.Component;

@Component
public class Employee {

    private int id;
    private String name;

    public Employee() {
        System.out.println("Employee Bean Created");
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
    }
}