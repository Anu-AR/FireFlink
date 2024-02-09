package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadData_JSONTest {

	public static void main(String[] args) throws Exception 
	{
		FileReader filePath = new FileReader(".\\src\\test\\resources\\JSONReader.json");
		JSONParser jparser = new JSONParser();
		Object obj = jparser.parse(filePath);
		Map map = (JSONObject)obj;
		System.out.println(map.get("employee"));
		System.out.println(map.get("employee1"));
		
		

	}

}
