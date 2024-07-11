package main.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosMoneda(
        @JsonAlias("base_code") String monedaBase,
        @JsonAlias("conversion_rates") Map<String,Double> tasaConversion){
}
