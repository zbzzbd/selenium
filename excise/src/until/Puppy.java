package until;

public class Puppy {

	int puppyAge;
	public Puppy(String name){
		System.out.println("Passed Name is :"+ name);
	}
	public void setAge(int age){
		puppyAge = age;
	}
	public void getAge(){
		System.out.println("Puppy's age is :"+puppyAge);
	}
	public static void main (String []args) {
		Puppy myPuppy = new Puppy ("tommy");//创建对象
		myPuppy.setAge(2);//设置年龄
		myPuppy.getAge();
		System.out.println("Variable value:"+myPuppy.puppyAge);
	}
	
}
