package taranet;

import java.util.Iterator;

public class AnonyDemo {
		public static void main (String[] args) {
			
			Book book = new Book("武林外传",new String[]{
					"zbz","zbd","gaoming"
			});
			Iterator<String> it = book.authors();
			while(it.hasNext()){
				System.out.println(it.next());
			}
		}
}

class Book{
	String name;
	String[] authros;
	public Book(String name,String[] authros){
		this.name=name;
		this.authros= authros;
	}
	public Iterator authors(){
		return new Iterator(){
			int cursor = -1;
			 
			@Override
			public boolean hasNext() {
				 
				return cursor +1 <authros.length;
			}
			@Override
			public Object next() {
				// TODO Auto-generated method stub
				return authros[++cursor];
			}
			public void remove(){
				
			}
			
		};
		
	}
}