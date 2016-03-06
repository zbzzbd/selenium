package until;

public class BinarySearch {
	private int rCount =0;
	private int lCount = 0;
	
	//获取递归次数
	
	public int getrCount() {
		return rCount;
	}
	//获取循环次数
	public int getlCount() {
		return lCount;
	}

/**
 *  执行递归二分查找，返回第一次出现改值的位置
 *  @param sortedData 已排序的数组
 *  @param  start   开始位置  
 *  @param  end 	结束位置
 *  @param	findValue   需要找的值
 *  @return  			值在数组中的位置，从0开始，找不到返回－1
 * */
	public int searchRecursive(int[] sortedData,int start,int end,int findValue) {
		rCount++;
		if (start <=end) {
			//中间位置
			int middle =(start+end)>>1;
			//中值
			int middleValue = sortedData[middle];
			if (findValue == middleValue) {
				//等于中间值直接返回
				return middle;
			}
			else if (findValue<middleValue) {
				return searchRecursive(sortedData,start,middle-1,findValue);
			}
			else {
				//大于中值在中值后面找
				return searchRecursive(sortedData,middle+1,end,findValue);
			}
		} else {
			//找不到
			return -1;
		} 
	} 
	
	
	/**
	 * @param sortedData  已排序的数组
	 * @param findValue  需要找的值
	 * @return  值在数组中的位置，从0开始，找不到返回－1
	 * */
	public int searchLoop(int[] sortedData,int findValue) {
		int start =0;
		int end = sortedData.length-1;
		
		while(start<=end) {
			lCount++;
			//中间位置
			int middle = (start +end) >>1;
		//中值
		 int middValue= sortedData[middle];
		 if (findValue== middValue) {
			 //等于中间只直接返回
			 return middle;
		 }
		 else if (findValue <middValue) {
			 //小于中间值在前面找
			 end=middle-1;
		 }
		 else {
			 //大于中值在中值后面找
			 start= middle+1;
		 }
		 
		}
		return -1; 
	}
	
}
