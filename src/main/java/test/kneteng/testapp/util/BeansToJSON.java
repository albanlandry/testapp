package test.kneteng.testapp.util;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import test.kneteng.testapp.domain.Contractor;

public class BeansToJSON {
	public static String ContractorsToJSON(List<Contractor> contractors) throws Exception {
		StringBuilder resp = new StringBuilder();
		resp.append("[");
		
		int size = contractors.size();
		for(int i = 0; i < size; i++)
		{
			resp.append(contractors.get(i).toString());

			if(i != size-1)
				resp.append(",");
		}
		
		resp.append("]");
		
        return resp.toString()/*.replace("[[", "[").replace("]]", "]")*/;
	}
}
