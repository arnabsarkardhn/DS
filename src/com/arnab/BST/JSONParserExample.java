package com.arnab.BST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONParserExample {

	static JsonObject json = (JsonObject)new JsonParser().parse("{\"color\":\"RED\",\"carDesc\":{\"numberPlate\":\"KA\",\"numberPlateType\":\"KAP\"}}");
	static JsonParser parser = new JsonParser();
	static ArrayList<Object> maps = new ArrayList<Object>();
	
	public static void main(String args[]) {
		
		/*JsonParser color = new JsonParser();
		JsonElement jsonTree = color.parse("{\"color\":\"RED\",\"carDesc\":{\"numberPlate\":\"KA\",\"numberPlateType\":\"KAP\"}}");
		
		if(jsonTree.isJsonObject()) {
			JsonObject jsonObject = jsonTree.getAsJsonObject();
			JsonElement carElement = jsonObject.get("color");
			System.out.println(carElement.getAsString());
			
			JsonElement numberElement = jsonObject.get("carDesc");
			if(numberElement.isJsonObject()) {
				JsonObject jsonObjectNumber = numberElement.getAsJsonObject();
				JsonElement f3 = jsonObjectNumber.get("numberPlate");
				JsonElement f5 = jsonObjectNumber.get("numberPlateType");
				System.out.println("f3 : " + f3.getAsString() + " : f5 : " + f5.getAsString());
			}
						
			JsonElement numberPlateElement = jsonObject.get("carDesc");
			JsonObject jsonNumberPlateObject = numberPlateElement.getAsJsonObject();
			System.out.println(jsonNumberPlateObject.get("numberPlate").getAsString());
		}
		
		JsonArray results = (JsonArray) json.get("results");*/
		
		//"{\"color\":\"RED\",\"f1\" : { \"carDesc\":{\"numberPlate\":\"KA\",\"numberPlateType\":\"KAP\"}}}", new HashMap<String, Object>()
		try {
		Map<JSONParserExample.KeyManager, Object> jsonMap = JSONParserExample.createKeyValueFromJsonString(
			//	"{\"shipping_address\": {\"street_address\": \"1600 Pennsylvania Avenue NW\",\"city\": \"Washington\",\"state\": \"DC\"},\"billing_address\": {\"street_address\": \"1st Street SE\",\"city\": \"Washington\",\"state\": \"DC\"}}"
			//	 "{\"results\" : [{\"formatted_address\" : \"Puławska, Piaseczno, Polska\",\"geometry\" : {\"bounds\" : {\"northeast\" : {\"lat\" : 52.0979041,\"lng\" : 21.0293984},\"southwest\" : {\"lat\" : 52.0749265,\"lng\" : 21.0145743}},\"location\" : {\"lat\" : 52.0860667,\"lng\" : 21.0205308},\"location_type\" : \"GEOMETRIC_CENTER\",\"viewport\" : {\"northeast\" : {\"lat\" : 52.0979041,\"lng\" : 21.0293984},\"southwest\" : {\"lat\" : 52.0749265,\"lng\" : 21.0145743}}},\"partial_match\" : true,\"types\" : [ \"route\" ]}],\"status\" : \"OK\"}"
			//	"{\"MyStringArray\" : [\"somestring1\", \"somestring2\"]}"
	//index
	//				"{\"indexConfigID\": \"BANK_BIN_DELTA_INDEX\",\"indexSourceType\": \"FILE\",\"indexSourceValue\": \"import/compliance_scanning/sine/process/current/BANK_BIN_DELTA\",\"distributionStrategy\": \"FILE\",\"distributionPath\": \"import/compliance_scanning/sine/index/current/BANK_BIN_DELTA\",\"indexSourceProperties\": [{\"fieldName\": \"delimiter\",\"fieldValue\": \"\t\"}],\"fields\": [{\"sourceFieldName\": \"NAME\",\"indexFieldName\": \"name\",\"matchType\": \"FUZZY\",\"multiValue\": true,\"delimiter\":\";\",\"cache\": true},{\"sourceFieldName\": \"UID\",\"indexFieldName\": \"UID\",\"matchType\": \"EXACT\",\"multiValue\": false,\"cache\": true},{\"sourceFieldName\": \"LISTNAME\",\"indexFieldName\": \"LISTNAME\",\"matchType\": \"EXACT\",\"multiValue\": false,\"cache\": true}]}"
	//index with array
	//			"{\"fileProcessingConfigID\": \"BANK_BIN_DELTA_PROCESS\",\"outputFilePath\": \"import/compliance_scanning/sine/process/current/BANK_BIN_DELTA\",\"listName\": \"banklistdelta\",\"filefilterConfig\": [{\"fileName\": \"/import/compliance_scanning/sine/download/current/PREMIUM\",\"delimiter\": \"\t\",\"isPrimary\":true,\"charset\":\"ISO-8859-1\",\"filters\": [{\"fieldName\": \"KEYWORDS\",\"fieldValue\": [\"OFAC-NONSDN\",\"OFAC\"],\"multiValue\": true,\"delimiter\": \"~\"},{\"fieldName\": \"CATEGORY\",\"fieldValue\": [\"BANK\"]}],\"dateFilters\":[{\"fieldName\":\"ENTERED\",\"endDate\":\"today\",\"format\":\"yyyy/mm/dd\",\"checkPointVariable\":{\"variableName\":\"last_executed_time\",\"groupName\":\"BANK_BIN_DELTA_PROCESS\",\"defaultStartDate\":\"today-1\"}},{\"fieldName\":\"UPDATED\",\"endDate\":\"today\",\"format\":\"yyyy/mm/dd\",\"checkPointVariable\":{\"variableName\":\"last_executed_time\",\"groupName\":\"BANK_BIN_DELTA_PROCESS\",\"defaultStartDate\":\"today-1\"}}]}]}"				
	//download
	//			"{\"fullDownloadConfigID\": \"DAILY_DOWNLOAD\",\"downloadConfigs\": [{\"fileDownloadConfigID\": \"WC_PREMIUM\",\"outputFileName\":\"import/compliance_scanning/sine/download/current/PREMIUM\",\"downloadURL\":\"https://www.world-check.com/datafile/premium/premium-world-check.csv.gz\",\"checksumDownloadURL\": \"https://www.world-check.com/datafile/premium/premium-world-check.csv.gz.md5\",\"username\":\"jse181\",\"password\":\"encrypted_wc_download_password\"}]}"
	//process
				"{\"fileProcessingConfigID\":\"PAYPAL_OFAC_PROCESS\",\"outputFilePath\":\"import/compliance_scanning/sine/process/current/PAYPAL_OFAC\",\"listName\":\"paypalofac\",\"filefilterConfig\":[{\"fileName\":\"import/compliance_scanning/sine/download/current/PREMIUM\",\"isPrimary\": true,\"charset\":\"ISO-8859-1\",\"delimiter\":\"\t\",\"excludeFilters\":[ { \"fieldName\":\"CATEGORY\",\"fieldValue\":[ \"EMBARGO VESSEL\"]}],\"filters\":[ { \"fieldName\":\"KEYWORDS\",\"fieldValue\":[\"OFAC\",\"UN\",\"EU\",\"UKHMT\",\"CANS\",\"JFSA\",\"JMETI-WMD\",\"JMOF\",\"JNPA-DB\",\"JP-ASF\",\"MAS\",\"MAS-TSOFA\",\"MYAGC-SANC\",\"OFAC-NONSDN\",\"PBC\",\"PBC-ETIM\",\"RBI\",\"RBI-NBFC\",\"UN-CIAC\",\"UNEMBARGO\",\"UNTB-LBY\",\"CANSEMRUS-FSR\",\"CSSF\",\"CSSFW\",\"DFAT\",\"DFAT-AS\",\"DFAT-ASFSR\",\"EU-AN\",\"EUEMBARGO\",\"EUFSR-RUS\",\"EUFSR-SYR\",\"EUMY-LTM\",\"FFMS\",\"HKGAZ\",\"HKMA\",\"IMHA-BTO\",\"IMOD\",\"JFIO\",\"SECO\"],\"multiValue\": true,\"delimiter\": \"~\"}],\"patternFilters\": [{\"fieldName\": \"DOB\",\"fieldValue\":\"(\\d+)/\\d+/\\d+\",\"targetFieldName\": \"YOB\"}]}]}"			
				
				, new LinkedHashMap<JSONParserExample.KeyManager, Object>(), new String());
		
		for (Map.Entry<JSONParserExample.KeyManager, Object> entry : jsonMap.entrySet()) {
			System.out.println("Key : " + entry.getKey().getKey() + " Value : " + entry.getValue());
		}}
		catch(Exception exp){}
		System.out.println("********************");
//		Iterator<Object> it = maps.iterator();
//		while(it.hasNext()) {
//			System.out.println("arraylist :" +it.next());
//		}
		
		
	}

	public static LinkedHashMap<JSONParserExample.KeyManager, Object> createKeyValueFromJsonString(String json, LinkedHashMap<JSONParserExample.KeyManager, Object> map, String parent) throws Exception{

	    JsonObject object = (JsonObject) parser.parse(json);
	    Set<Map.Entry<String, JsonElement>> set = object.entrySet();
	    Iterator<Map.Entry<String, JsonElement>> iterator = set.iterator();
	    while (iterator.hasNext()) {

	        Map.Entry<String, JsonElement> entry = iterator.next();
	        String key = entry.getKey();
	        JsonElement value = entry.getValue();

	        if (null != value) {
	        	String path = parent + "." + key;
	        	if (!value.isJsonPrimitive()) {
	                if (value.isJsonObject()) {
	                    map = createKeyValueFromJsonString(value.toString(), map, path);
	                } else if (value.isJsonArray() && value.toString().contains(":")) {
	                	List<HashMap<JSONParserExample.KeyManager, Object>> list = new ArrayList<>();
	                    JsonArray array = value.getAsJsonArray();
	                    if (null != array) {
	                    	for (JsonElement element : array) {
	                        	System.out.println("hi");
	                            list.add(createKeyValueFromJsonString(element.toString(), map, path));
	                        }
	                        map.put(new JSONParserExample.KeyManager(path, list.toArray().toString()), list.toArray());
	                        maps.add(key + ":" + map.get(key));
	                    }
	                } else if (value.isJsonArray() && !value.toString().contains(":")) {
	                    map.put(new JSONParserExample.KeyManager(path, value.getAsJsonArray().toString()), value.getAsJsonArray());
	                    for(int i = 0; i < value.getAsJsonArray().size(); i++) {
	                    	System.out.println("hello");
	                    	maps.add(key + ":" + value.getAsJsonArray().get(i));
	                    }
	                    System.out.println(">>" + map.get(key));
	                }
	            } else {
	                map.put(new JSONParserExample.KeyManager(path,value.getAsString()), value.getAsString());
	                maps.add(key + ":" + map.get(key));
	                System.out.println(">>" + map.get(key));
	            }
	        }
	    }
	    return map;
	}
	
	static class KeyManager {
		private String key;
		private String value;
		
		KeyManager(String key, String value) {
			this.key = key;
			this.value = value;
		}
				
		public String getKey() {
			return key;
		}
		
		public String getValue() {
			return value;
		}
		
		@Override
		public int hashCode() {
			return key.hashCode() + value.hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			if(this == obj)
				return true;
			if(obj == null || (obj.getClass() != this.getClass()))
				return false;
			KeyManager obj1 = (KeyManager) obj;
			return obj1.key.equals(key) && obj1.value.equals(value);
		}
	}
	
}
