package com.bootcamp.builder;

public class Employee {
	public static class Builder {

		private Employee employee;

		private Builder() {
			employee = new Employee();
		}

		public static Builder getInstance() {
			return new Builder();
		}

		public Employee build() {
			employee.isValid();
			return employee;
		}

		public Builder name(String name) {
			employee.name = name;
			return this;
		}

		public Builder age(int age) {
			employee.age = age;
			return this;
		}

		public Builder fullTimeEmployee(boolean fullTimeEmployee) {
			employee.fullTimeEmployee = fullTimeEmployee;
			return this;
		}

		public Builder department(String department) {
			employee.department = department;
			return this;
		}

		public Builder managerName(String managerName) {
			employee.managerName = managerName;
			return this;
		}
	}

	private String name;
	private int age;
	private boolean fullTimeEmployee;
	private String department;
	private String managerName;

	private Employee() {

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public boolean isFullTimeEmployee() {
		return fullTimeEmployee;
	}

	public String getDepartment() {
		return department;
	}

	public String getManagerName() {
		return managerName;
	}

	private void isValid() {
		if (name == null || !name.matches("^[\\p{L} .'-]+$")) {
			throw new IllegalArgumentException("Invalid name");
		}
		if (age < 16 || age > 75) {
			throw new IllegalArgumentException("Invalid age for an employee at this company");
		}
		if (department == null || department.isEmpty()) {
			throw new IllegalArgumentException("Department cannot be empty");
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("Employee [name=").append(name).append(", age=").append(age).append(", fullTimeEmployee=")
				.append(fullTimeEmployee).append(", department=").append(department).append(", managerName=")
				.append(managerName).append("]");
		return builder2.toString();
	}

}
