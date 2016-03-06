package taranet;
import  java.util.*;
public class ArrayListDemo {
	
	public static void main(String[] args){
		
		Music [] musics = new Music[10];
		int size=0;
		musics[size++] = new Music(1,"a");
		musics[size++] = new Music(2,"b");
		musics[size++] = new Music(3,"c");
		for (Music m : musics) {
			System.out.println(m);
		}
	ArrayList<Object> musicList = new ArrayList<Object>();
	musicList.add(new Music(1,"d"));
	musicList.add(new Music(2,"f"));
	musicList.add(new Music(3,"e")); //添加
	System.out.println(musicList.get(1)); //获取
	System.out.println(musicList);
	
	//遍历
	Iterator it = musicList.iterator();
	while (it.hasNext()){ 
		 System.out.print(it.next());
		
	}
	}
	
	
}

class Music{
	private int id;
	private String name;
	private String filename;
	public Music(){
		
	}
	public Music(int id,String name) {
		this.id=id;
		this.name=name;
	}
	@Override
	public String toString(){
		return name;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if(obj instanceof Music) {
			Music m = (Music)obj;
			return m.id ==this.id;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return id;
	}
}
