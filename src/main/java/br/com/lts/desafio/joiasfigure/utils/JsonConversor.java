package br.com.lts.desafio.joiasfigure.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConversor {

    private static ObjectMapper mapper = new ObjectMapper();

    public static String convertToJson(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

    public static Object convertFromJson(String json, Class<?> clazz) throws JsonProcessingException {
        return mapper.readValue(json, clazz);
    }
}
