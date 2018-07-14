package accountApp;

import com.google.gson.*;

public class JSONUtil {

	private Gson gson;
	
	public JSONUtil() {
		this.gson = new Gson();
	}
	
	public String getJSONForObject(Object obj) {
		return gson.toJson(obj);
	}
	
	public <T> T getObjectForJSON(String jsonString, Class<T> clasS) {
		return gson.fromJson(jsonString, clasS);
	}
}
