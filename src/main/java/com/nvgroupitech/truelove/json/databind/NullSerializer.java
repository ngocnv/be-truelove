package com.nvgroupitech.truelove.json.databind;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class NullSerializer extends JsonSerializer<Object> {

	@Override
	public void serialize(Object value, JsonGenerator json, SerializerProvider provider) throws IOException,
			JsonProcessingException {
		if (value == null) {
			json.writeString("");
		}
	}
}
