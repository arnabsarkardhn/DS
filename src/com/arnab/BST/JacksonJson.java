package com.arnab.BST;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJson {

	
	public static void main(String args[]) {
		
		JsonFactory factory = new JsonFactory();
		String json = "{\"color\":\"RED\",\"carDesc\":{\"numberPlate\":\"KA\",\"numberPlateType\":\"KAP\"}}";
        ObjectMapper mapper = new ObjectMapper(factory);
        JsonNode rootNode;
		try {
			rootNode = mapper.readTree(json);
        	Iterator<Map.Entry<String,JsonNode>> fieldsIterator = rootNode.fields();
		    while (fieldsIterator.hasNext()) {
		           Map.Entry<String,JsonNode> field = fieldsIterator.next();
		           System.out.println("Key: " + field.getKey() + "\tValue:" + field.getValue());
		       }
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
}
