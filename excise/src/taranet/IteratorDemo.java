package taranet;
import java.util.*;
public class IteratorDemo {
	public static void main(String[] args){
		ArrayList<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("cde");
		list.add("sdf");
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String egg = it.next();
			System.out.println(egg);
			if(egg.equals("cde")){
				it.remove();
			}
		}
		System.out.println(list);
		
	}
}
