package taranet;

import java.util.*;

public class CollectionsDemo {
	public static void main(String[] args) {
		/**
		 * 创建一个数组并添加值，调用cllections.sort()来进行排序
		 * */
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("sdfa");
		list.add("eb");
		list.add("3c");
		list.add("43e");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		LinkedList<Car> carList = new LinkedList<Car>();
		carList.add(new Car(2));
		carList.add(new Car(1));
		carList.add(new Car(7));
		System.out.println(carList);
		Collections.sort(carList);
		System.out.println(carList);
	}

}

class Car implements Comparable {
	int id;

	public Car(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return Integer.toString(id);
	}

	@Override
	public int compareTo(Object obj) {
		// TODO Auto-generated method stub
		Car car = (Car) obj;

		return id - car.id;
	}
}

class Person implements Comparable {
	int id;
	String name;
	int score;
	int age;

	public Person(int id, String name, int score, int age) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.age = age;
	}

	@Override
	public String toString() {
		return "[" + id + "," + name + "," + score + "," + age + "]";
	}
	// 自定义排序原则

	@Override
	public int compareTo(Object obj) {
		return age - ((Person) obj).age; // 按照age 排序
	}

}

// 定义比较器，比较原则是按照字符串的长度
class ByLength implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}
}