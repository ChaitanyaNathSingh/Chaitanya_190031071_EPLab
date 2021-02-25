package Employee_IN_LAB.Employee_Task;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee_pojo {

	@Id
	private int empno;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	@Column
	private String empname;
	@Column
	private int age;
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Employee_pojo [empno=" + empno + ", empname=" + empname + ", age=" + age + "]";
	}
	public void setAge(int age) {
		this.age = age;
	}
}
