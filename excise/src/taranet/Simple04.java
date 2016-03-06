package taranet;

public class Simple04 {
	
	public static void main(String[] args){
		 int num=12345;
		 int sum=0;
		
		
		while(num>0){
			int n = num%10;
			sum=sum*10+n;
			num=num/10;
		}
		 System.out.println(sum);
		 
	}
}
