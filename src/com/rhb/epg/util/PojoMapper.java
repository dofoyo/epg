package com.rhb.epg.util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

public class PojoMapper {
    private static ObjectMapper mapper = new ObjectMapper();
    private static JsonFactory jf = new JsonFactory();

    public static <T> Object fromJson(String jsonAsString, Class<T> pojoClass)
    throws JsonMappingException, JsonParseException, IOException {
    	mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(jsonAsString, pojoClass);
    }

    public static <T> Object fromJson(FileReader fr, Class<T> pojoClass)
    throws JsonParseException, IOException
    {
    	mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(fr, pojoClass);
    }

    public static String toJson(Object pojo, boolean prettyPrint){
    	mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);//disable SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS

        String json = null;

        StringWriter sw = new StringWriter();
		try {
	        JsonGenerator jg = jf.createJsonGenerator(sw);
	        if (prettyPrint) {
	            jg.useDefaultPrettyPrinter();
	        }
			//System.out.println("json:");
	        mapper.writeValue(jg, pojo);
			json = sw.toString();
			jg.close();
			sw.close();
			//System.out.println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return json;
    }

    public static void toJson(Object pojo, FileWriter fw, boolean prettyPrint)
    throws JsonMappingException, JsonGenerationException, IOException {
        JsonGenerator jg = jf.createJsonGenerator(fw);
        if (prettyPrint) {
            jg.useDefaultPrettyPrinter();
        }
        mapper.writeValue(jg, pojo);
        jg.close();
        
    }

}
