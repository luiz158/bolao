package bolao.model;

import java.util.HashMap;
import java.util.Map;

public class StoreValue {
	private static Map<String, String> stores = new HashMap<String, String>();
	
	public static void add(String tag, String value){
		stores.put(tag, value);
	}
	
	public static String getValue (String tag){
		return stores.get(tag);
	}
}
