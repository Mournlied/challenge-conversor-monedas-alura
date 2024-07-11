package main.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertirDatos implements ConvertirDatosI{
    
    private ObjectMapper mapper = new ObjectMapper();
    
    @Override
    public <T>T parseData(String json, Class<T> aClass) {
        try {
            return mapper.readValue(json,aClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
