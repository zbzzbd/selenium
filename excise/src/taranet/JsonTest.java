package taranet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTest {

	
	/*
	 * 构造 json数据
	 * */
	
	public static String BuildJson(){
		//JSON格式数据解析对象
		JSONObject jo = new JSONObject();
		
		//下面构造两个map,一个list和一个employee对象
		Map<String,String> map1 = new HashMap<String,String>();
		map1.put("name", "zbz");
		map1.put("sex", "man");
		map1.put("age", "26");
		
		Map<String,String> map2 = new HashMap<String,String>();
		map2.put("name", "zbz2");
		map2.put("sex", "man");
		map2.put("age", "24");
		
		List<Map> list = new ArrayList<Map>();
		list.add(map1);
		list.add(map2);
		
		Employee employee = new Employee();
		employee.setName("zf");
		employee.setSex("female");
		employee.setAge(24);
		
		//将map转换为jsonArray 
		JSONArray ja1 = JSONArray.fromObject(map1);
		JSONArray ja2 = JSONArray.fromObject(map2);
		JSONArray ja3 = JSONArray.fromObject(employee);//将employee对象转换为json对象
		
		System.out.println("JSON格式对象为");
		System.out.println(ja1.toString());
		System.out.println(ja2.toString());
		System.out.println(ja3.toString());
		
		//构造json数据，包含一个map和一个employee 对象
		jo.put("map", ja1);
		jo.put("employee", ja2);
		System.out.println("\n 最终构造数据格式：");
		System.out.println(jo.toString());
		return jo.toString();
	}
	
	/**
	 * 
	 * 解析json
	 * */
	public static void ParseJson (String jsonString) {
		JSONObject jb = JSONObject.fromObject(jsonString);
		JSONArray  ja = jb.getJSONArray("employee");
		
		List<Employee> empList = new ArrayList<Employee>();
		
		for(int i =0;i<ja.size();i++){
			Employee employee = new Employee();
			employee.setName(ja.getJSONObject(i).getString("name"));
			employee.setSex(ja.getJSONObject(i).getString("sex"));
			employee.setAge(ja.getJSONObject(i).getInt("age"));
			
			empList.add(employee);
		}
		System.out.println("\n 将json 数据转换为Employee  对象");
		for (int i =0;i <empList.size();i++){
			Employee emp = empList.get(i);
			System.out.println("name:" + emp.getName()+ "sex:"+ emp.getSex() +"age"+emp.getAge());
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParseJson(BuildJson());
	}

}
