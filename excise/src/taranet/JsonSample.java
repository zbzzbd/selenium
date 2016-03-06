package taranet;

import java.util.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListToJson();
		MapToJson();
	}
	public static void ListToJson(){
		List list = new ArrayList();
		list.add("first");
		list.add("second");
		JSONArray json = JSONArray.fromObject(list);
		System.out.println(json);
	}
	public static void MapToJson(){
		Map map = new HashMap();
		map.put("name", "zbz");
		map.put("bool", Boolean.TRUE);
		map.put("int", new Integer(1));
		map.put("arr", new String[] {"a","b"});
		map.put("func", "functin(i) { return this.arr[i];}");
		JSONObject json = JSONObject.fromObject(map);
		System.out.println(json);
	}
}
