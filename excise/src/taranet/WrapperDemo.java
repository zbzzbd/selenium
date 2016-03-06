package taranet;

import java.util.ArrayList;

public class WrapperDemo {

	public static void main(String[] args){
		ArrayList list = new ArrayList();
		list.add("abc");
		list.add(new Integer(10));
		list.add(10);
		
		int i =10;
		Integer m = i; //自动装箱
		int j = m;//自动拆箱子
		
		double pi = 3.12d;
		Double d = pi;//自动装箱,new Double(3,14)
		double d1 = d; //自动拆箱
		
		//字符串和数字之间的转换
		
	}
}
