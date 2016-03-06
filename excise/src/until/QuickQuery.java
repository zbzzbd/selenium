package until;

public class QuickQuery {
	
	/*
	 * 快速排序的基本思想： 
     * 通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比
     * 另一部分关键字小，则分别对这两部分继续进行排序，直到整个序列有序
	 * */
	
	public int getMiddle(Integer[] list, int low,int high) {
		int tmp = list[low];    //数组的第一个作为中轴
		while (low < high) {
			while(low <high && list[high] > tmp) {
				high--;
			}
			list[low]= list[high];   //比中轴小的纪录移到低端
			
			while (low < high && list[low] < tmp) {
				low++;
			}
			list[high] = list[low];   //比中轴大的纪录移到最高端
		}
		
		return low;
	}
	//递归形式分治排序算法：
	public void quickSort(Integer[] list,int low,int high) {
		if (low < high) {
			int middle = getMiddle(list,low,high);
			quickSort(list,low,middle-1);
			quickSort(list,middle+1, high);
		}
	}
	// 
	public void quick(Integer[] data) {
		if (data.length >0) {
			quickSort(data,0,data.length-1);
		}
	}
	
	public static void main (String []args) {
		 Integer[] list={34,3,53,2,23,7,14,10};
		 QuickQuery qs = new  QuickQuery();
		 qs.quick(list);
		 for(int i=0;i<list.length;i++){
			 System.out.print(list[i]+",");
		 }
	}
}
