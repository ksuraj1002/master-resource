package com.feign.client.child.app.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feign.client.child.app.entity.PincodeRegistry;
import com.feign.client.child.app.repository.PincodeRegistryRepo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken; 

@Service
public class RegistryService {
	
	@Autowired
	PincodeRegistryRepo pincodeRegistryRepo;

	public void savePincodeRegistry() throws FileNotFoundException, IOException, ParseException {
		List<PincodeRegistry> pincodeRegistry = extractPincodeRegistry();
		pincodeRegistryRepo.saveAll(pincodeRegistry);
	}

	private List<PincodeRegistry> extractPincodeRegistry() throws FileNotFoundException, IOException, ParseException {
		ObjectMapper mapper = new ObjectMapper();
		String records = new ObjectMapper()
				.readTree(Paths.get("H:\\sts-workspace\\master\\src\\pincode_all_India.json").toFile()).get("records")
				.toPrettyString();
		List<PincodeRegistry> pincodes=mapper.readValue(records, new TypeReference<List<PincodeRegistry>>() { });
		
		//String recordss=parent.asText("title");
		//JsonNode records = mapper.readTree(parent.toPrettyString()).get("records");
		//String records = parent.get("records").asText();
		
		//Note: working code....with json simple and gson
		/*JSONParser parser = new JSONParser();
		JSONObject data = (JSONObject)parser.parse(new FileReader("H:\\sts-workspace\\master\\src\\pincode_all_India.json"));
        String recordsStr=data.get("records").toString();
        List<PincodeRegistry> pincodes = new Gson().fromJson(recordsStr, new TypeToken<Collection<PincodeRegistry>>(){}.getType());
        */
        return pincodes;
	}

}
