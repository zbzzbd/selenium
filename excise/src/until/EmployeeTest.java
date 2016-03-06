package until;

public class EmployeeTest {

	public static void main (String args[]){
		Employ empOne = new Employ("james Smith"); //创建一个对象
		Employ empTwo = new Employ("Mary Anne");
		empOne.empAge(26);//设置属性
		empOne.empDesignation("Senior Sofware Engineer");
		empOne.empSalary(500);
		empOne.printEmployee();
		
		empTwo.empAge(21);
		empTwo.empDesignation("software Enginner");
		empTwo.empSalary(500);
		empTwo.printEmployee();
	}
}
