package main.service;

public interface ConvertirDatosI {
    <T> T parseData(String json, Class<T> tClass);    
}
