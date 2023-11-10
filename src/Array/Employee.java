package Array;

import java.util.HashSet;
import java.util.Objects;

public class Employee {
	private int id;
	private String name;

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		Employee e = (Employee) obj;
		if (e.id == this.id) {
			e.setName(this.name);
			return true;
		} else
			return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Employee{id=" + this.id + " , name=" + this.name + "}";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Employee> hs = new HashSet<>();
		hs.add(new Employee(1, "irshad"));
		hs.add(new Employee(2, "khan"));
		hs.add(new Employee(3, "sherani"));
		System.out.println(hs);

	}

}
