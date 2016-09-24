package com.bootcamp.builder;

public class TestBuilder {

	public static void main(String[] args) {
		Employee.Builder employeeBuilder = Employee.Builder.getInstance();
		Employee john = employeeBuilder.name("John").age(25).department("Services").fullTimeEmployee(true)
				.managerName("Kevin").build();
		System.out.println(john);

		try {
			employeeBuilder = Employee.Builder.getInstance();
			Employee invalidEmployee = employeeBuilder.name("890").age(29).managerName("Cleve").build();
			System.out.println(invalidEmployee);
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}

		try {
			employeeBuilder = Employee.Builder.getInstance();
			Employee invalidAgeEmployee = employeeBuilder.name("Tom").age(150).department("IT").build();
			System.out.println(invalidAgeEmployee);
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}

		try {
			employeeBuilder = Employee.Builder.getInstance();
			Employee invalidDepartmentEmployee = employeeBuilder.name("Brian").age(55).fullTimeEmployee(false).build();
			System.out.println(invalidDepartmentEmployee);
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
}
