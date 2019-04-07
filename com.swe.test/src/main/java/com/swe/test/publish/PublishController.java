package com.swe.test.publish;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
@RestController
public class PublishController {

	JsonObject personObject;
	
	@RequestMapping(value = "/publish", method = RequestMethod.POST)
	public JsonObject update(@RequestBody Post post) {
		
		return personObject;
	}
	public void initializeRespone(){
		String personJSONData = 
	            "  {" +
	            "   \"Date\": \"132\", " +
	            "   \"isMarried\" : false, "+
	            " }";
		JsonReader reader = Json.createReader(new StringReader(personJSONData));
        personObject = reader.readObject();
	}
	@RequestMapping("/hello")
	public String sayHi() {
		return " Hello World!";
	}

}
