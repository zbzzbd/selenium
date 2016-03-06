package until;

public class Employ {

	String name;
	int age;
	String designation;
	double salary;
	
	public Employ(String name){
		this.name = name;
	}
	//设置age 的值
	public void empAge( int empAge){
		age = empAge;
	}
	/* 设置 designation的值*/
	public void empDesignation(String empDesig){
		designation = empDesig;
	}
	/* 设置salary*/
	public void empSalary( double empSalary){
		salary = empSalary;
	}
	
	public void printEmployee () {
		System.out.println("Name:"+ name);
		System.out.println("Age:"+ age);
		System.out.println("Designation:" + designation);
		System.out.println("salary:"+ salary);
	}
}
