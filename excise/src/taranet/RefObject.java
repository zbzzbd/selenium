package taranet;

public class RefObject {
	private static final int size =8000;
	//创建一个object 数组，这样会占用很大空间。预计大概有640k左右的内存占用
	private Object[] object = new Object[size];
	private String refId;
	public RefObject(String id){
		this.refId = id;
	}
	public String RefIdToString(){
		return refId;
	}		
	public void findName(){
		System.out.println("findname="+refId);
	}
	
}
