package taranet;

public class Point {
	private int x;
	private int y;
	public Point(){
		System.out.println("--无参数构造--"); 
	}
	public Point(Point p){
		this(p.x,p.y);
	}
	public Point(int x, int y) {
		this(); //调用point的构造必须放在第一行
		this.x = x;
		this.y = y;
	}
	
	/*
	 * 返回x,y 到原点的距离
	 * */
	public double getDistance () {
		return Math.sqrt(x*x + y*y);
	} 
	/*
	 * 求当前坐标到指定坐标的距离
	 * */
	public double getDistance(int x,int y) {
		return Math.sqrt((this.x -x)*(this.x - x) + (this.y - y)*(this.y- y));
	}
	
	public double getDistance(Point p) {
		return getDistance(p.x,p.y);
	}
	/**
	 * 坐标显示
	 * */
	public void show () {
		System.out.println("(" + x +","+ y +")");
	}
	public void setX(int x) {
		this.x= x;
		
	}
	public int getX(){
		return x;
	}
	public void setY(int y){
		 this.y = y;
	}
	public int getY(){
		return y;
	}
	
	public static void main(String[] args) {
			Point p = new Point();
			p.setX(3);
			p.setY(4);
			p.show();
			System.out.println("距离原点的距离为："+p.getDistance());
			boolean[] arr = new boolean[7];
 			 arr[0] = true;
			 arr[1] = false;
			 arr[3] = false;
			 arr[4] = true;
			 arr[5] = false;
			 arr[6] = true;
			
			for(int i=0;i<arr.length;i++){
				if (arr[i]==true) {
					System.out.println("星期"+(i+1)+"有飞机");
				}else if(arr[i]==false){
					System.out.println("星期"+(i+1)+"无飞机");
				}else {
					System.out.println("非法字符串");
				}
			}
	}
	
	
}
