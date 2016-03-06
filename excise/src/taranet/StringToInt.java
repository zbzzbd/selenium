package taranet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToInt {

	
	public static void main(String[] args){
		String s="123";
		stringPaseToInt(s);
		
		//  直接调用系统的方法
		System.out.println(Integer.parseInt(s,10));
		int i=145;
		System.out.println(Integer.toString(i));
		
	}
	
	/**
	 * 字符串转化为int类型
	 * */
	public static void stringPaseToInt (String s){
		s=s.replace(" ", "");
		// 检查str是否为整数
		System.out.println(s);
		Pattern p = Pattern.compile("[0-9]+");
		Matcher matcher = p.matcher(s);
		int tmp=0;
		if(matcher.matches()) {
			
			for(int i=0;i<s.length();i++){
			int m=0;
			m=(int)Math.pow(10, s.length()-(i+1));
			tmp+=(s.charAt(i)-48)*m; 
			}
			System.out.println(tmp);
		}else {
			System.out.println("还有非法字符");
		}
	}
}
//1    10  2
//2    10  1
//3    10  0