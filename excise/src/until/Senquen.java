package until;

public class Senquen {

	//冒泡排序
	public static void main(String[] args) {
		int[] myList = {3,1,4,6,8,7,0,9,2,5};
		for(int i=0;i<myList.length;i++) {
			for(int j=0;j<myList.length-1-i;j++)
			{
				if (myList[j]> myList[j+1]) {
					int tmp=0;
					tmp=myList[j];
					myList[j]= myList[j+1];
					myList[j+1]=tmp; 
					
				}
			}

	} 
		
		for(int i=0;i<myList.length;i++){
			System.out.print(myList[i]);
		}
  }
}
