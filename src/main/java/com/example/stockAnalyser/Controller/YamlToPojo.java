package com.example.stockAnalyser.Controller;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YamlToPojo {

	public static <T> T parseYamlToPojo(String filePath, Class<T> valueType)
			throws IOException, JsonParseException, JsonMappingException {
		File f = new File(filePath);
		return instantiateObject(f, valueType);
	}

	public static <T> T parseYamlToPojo(File f, Class<T> valueType)
			throws JsonParseException, JsonMappingException, IOException {
		return instantiateObject(f, valueType);
	}

	private static <T> T instantiateObject(File f, Class<T> valueType)
			throws JsonParseException, JsonMappingException, IOException {
		final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		return (T) mapper.readValue(f, valueType);
	}
}
