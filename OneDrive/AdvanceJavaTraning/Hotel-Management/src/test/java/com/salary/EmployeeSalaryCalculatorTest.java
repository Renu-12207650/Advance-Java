package com.salary;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeSalaryCalculatorTest {

 @Test
 void hraTest(){
  EmployeeSalaryCalculator e=new EmployeeSalaryCalculator(20000,5000,10);
  assertEquals(4000,e.calculateHRA());
 }

 @Test
 void daTest(){
  EmployeeSalaryCalculator e=new EmployeeSalaryCalculator(20000,5000,10);
  assertEquals(2000,e.calculateDA());
 }

 @Test
 void grossTest(){
  EmployeeSalaryCalculator e=new EmployeeSalaryCalculator(20000,5000,10);
  assertEquals(31000,e.calculateGrossSalary());
 }

 @Test
 void netTest(){
  EmployeeSalaryCalculator e=new EmployeeSalaryCalculator(20000,5000,10);
  assertEquals(27900,e.calculateNetSalary());
 }

 @Test
 void invalidSalary(){
  EmployeeSalaryCalculator e=new EmployeeSalaryCalculator(0,5000,10);
  assertThrows(IllegalArgumentException.class,()->e.validateSalary());
 }

 @Test
 void negativeSalary(){
  EmployeeSalaryCalculator e=new EmployeeSalaryCalculator(-10,5000,10);
  assertThrows(IllegalArgumentException.class,()->e.validateSalary());
 }

 @Test
 void invalidTax(){
  EmployeeSalaryCalculator e=new EmployeeSalaryCalculator(20000,5000,120);
  assertThrows(IllegalArgumentException.class,()->e.validateSalary());
 }
}
