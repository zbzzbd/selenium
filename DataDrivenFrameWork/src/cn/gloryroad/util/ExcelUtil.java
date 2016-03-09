package cn.gloryroad.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class ExcelUtil {
	private static XSSFSheet ExcelWSheet; //工作的sheet
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell; //列
	private static XSSFRow  Row; //行
	
	//设定要操作excel 的 文件路径和excel 文件中的sheet名称
	//在读，写excel 的时候，均需要先调用此方法，设定要操作的execel文件路径和要操作的sheet名称
	public static void setExecelFile(String path,String SheetName){
		FileInputStream ExcelFile;
		
		try {
			//实例化execl 文件的fileInputStream
			ExcelFile = new FileInputStream(path);
			//实例化 execl 文件的xssfworkbook 对象
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//读取excel 文件指定单元格的函数，此函数只支持扩展名为.xsl 的excel 文件
	public static String getCellData(int RowNum,int ColNum) throws Exception{
		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			/***
			 * 如果单元格的内容未字符串类型，则使用getStringcellvalue() 方法获取单元格的内容
			 * 如果单元格的内容未数字类型，则使用getnumericcellvalue() 方法获取单元格的内容
			 * 注意：getNumericCellValue() 方法返回值为double，必须强转化
			 * 在cell.getnumericcellvalue() 前面增加 “”，用于强制转换double 类型到 String 类型， 不加“”会抛出　double 类型无法转换string 类型
			 * 
			 * */
			String CellData = (String)(Cell.getCellType() == XSSFCell.CELL_TYPE_STRING?Cell.getStringCellValue() +"" : String.valueOf(Math.round(Cell.getNumericCellValue())));
			return CellData;
			
		}catch(Exception e){
  			return "";
		} 	
	}
	
	
//在excel 文件的执行单元格写入输入,此函数只支持扩展名为.xlsx 的execl 文件写入
	public static void setCellData(int RowNum,int Column,String Result) throws Exception{
		try{
			//获取excel文件的对象
			Row = ExcelWSheet.getRow(RowNum);
			//如果单元格为空，则返回Null
			Cell = Row.getCell(Column,Row.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				//当单元格对象是null的时候，则创建单元格
				//如果单元格为空，无法直接调用单元格对象的setCellValue 方法 设定单元格的值
				Cell = Row.createCell(Column);
				Cell.setCellValue(Result);
			} else {
				//单元格中有内容，则可以调用单元格
				Cell.setCellValue(Result);
			}
			FileOutputStream fileOut = new FileOutputStream(Constant.TestDataExcelFilePath);
			//将内容写入excel 文件中
			ExcelWBook.write(fileOut);
			fileOut.flush();
			//关闭文件输出流对象
			fileOut.close();
		}catch(Exception e){
		  throw (e);
		}
		
	}
	
	//从excel 文件中获取测试数据的静态方法
	public static Object[][] getTestData(String excelFilePath,String sheetName) throws IOException{
		//根据文件输入的数据文件路径和文件名称，组合出excel 数据文件的绝对路径
		//根据参数传入的数据文件路径和文件名称，组合出excel 数据文件的绝对路径，声明一个file文件对象
		File file = new File(excelFilePath);
		//创建FileInputStream 对象用于读取excel 文件
		FileInputStream inputStream = new FileInputStream(file);
		
		//声明
		Workbook Workbook = null;
		//获取文件参数的名字是.xlsx 还是.xls
		 String fileExtersionName = excelFilePath.substring(excelFilePath.indexOf("."));
		 
		 if(fileExtersionName.equals(".xlsx")){
			 Workbook = new XSSFWorkbook(inputStream);
		 }else if (fileExtersionName.equals(".xls")){
			 Workbook = new HSSFWorkbook(inputStream);
		 }
		 //通过sheetname 参数，声称sheet 对象
		 Sheet sheet = Workbook.getSheet(sheetName);
		 
		 //获取execl 数据文件 sheet1 中数据的行数，getLastRowNum 方法获取数据的最后行号
		 //getFirstRowNum 方法获取数据的第一行行号，相减之后算出数据的行数
		 //注意： excel 文件的行号和列好都从0开始的
		 int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		 //创建名为records 的list 对象来存储从excel 数据文件读取的数据
		 List<Object[]> records = new ArrayList<Object[]>();
		 for(int i=1;i<rowCount;i++){
			 // 使用getrow获取行对象
			 Row row = sheet.getRow(i);
			 String field[] = new String[row.getLastCellNum()-2];// 仅仅存放测试数据
			 
			 if(row.getCell(row.getLastCellNum()-2).getStringCellValue().equals("y")){
				 
				 for(int j=0;j<row.getLastCellNum()-2; j++){
					 field[j] = (String)(row.getCell(j).getCellType() == XSSFCell.CELL_TYPE_STRING?row.getCell(j).getStringCellValue():""+row.getCell(j).getNumericCellValue());
				 }
				 records.add(field);
			 }
		 }
		 //定义函数返回值，即object[][] 
		 //将存储测试数据的list转换为一个object 的二维数组
		 Object[][] results = new Object[records.size()][];
		 
		 //设置二维数组每行的值，每行是一个object对象
		 for(int i=0;i<records.size();i++){
			 results[i] = records.get(i);
		 }
		 return results;
	}
	public static int getLastColumnNum(){
		return ExcelWSheet.getRow(0).getLastCellNum()-1;
	}
}
