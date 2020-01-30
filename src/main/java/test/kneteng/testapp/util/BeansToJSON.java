package test.kneteng.testapp.util;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import test.kneteng.testapp.domain.Contractor;

public class BeansToJSON {
	public static String ContractorsToJSON(List<Contractor> contractors) throws Exception {
		StringBuilder resp = new StringBuilder();
		resp.append("{\"data\": { contractors:");
		
		for(Contractor c: contractors) {
			resp.append(c.toString());
		}
		
		resp.append(contractors.toString());
		resp.append("}");
		
        return resp.toString().replace("[[", "[").replace("]]", "]");
	}
	
	public static String ManagerToJSON(Contractor c) throws JsonGenerationException, JsonMappingException, IOException {
        // Create ObjectMapper
        
        return "";
	}
}
