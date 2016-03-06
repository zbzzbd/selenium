package taranet;

public class Sample01 {
	
	public static void count(String str){
		int upper =0;
		int lowser = 0;
		if (str ==null) {
			 return;
		}
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(c>='a' && c<='z') {
				lowser++;
			}else if(c>'A' && c<'Z'){
				upper++;
			}
		}
		System.out.println("大写字母"+upper+"个");
		System.out.println("小写字母"+lowser+"个");
	}
	
	public static void test1() {
		String s = "ab中cd";
		for (int i=0;i<s.length();i++) {
			System.out.println(s.charAt(i));
		}
	}
	
	public static void test2(){
		String str = "AbcE你fg";
		str = str.toLowerCase();
		System.out.println(str);
	}
	public static void test3(){
		String str = "ab c";
		String b = "efg";
		str = str.trim()+b;
		System.out.println(str);
	}
	
	public static void test4(){
		System.out.println("hello张三".startsWith("hello"));
		 
	}
	
	public static void test5(){
		System.out.println("a".compareTo("b"));
		System.out.println("abc".compareTo("abc"));
		System.out.println("az".compareTo("ab"));
	}
	public static void test6(){
		System.out.println("abcedf".indexOf("ce"));
		System.out.println("abcedf".lastIndexOf("f"));
	}
	
	public static void test7(){
		String str="计算机,旅游,爬山";
		String[] strArr = str.split(",");
		System.out.print(strArr.length);
		for(String s:strArr){
			System.out.println(s);
		}
	}
	public static void test8(){
		String file="hello java";
		System.out.println(file.substring(6));
	}
	public static String getFileName(String path) {
		int index = path.lastIndexOf("\\") +1;
		return path.substring(index);
	}
	
	public static String getFileType(String path) {
		int index = path.lastIndexOf(".");
		return path.substring(index);
	}
	
	public static void main(String[] args) {
		test8();
	}
}
