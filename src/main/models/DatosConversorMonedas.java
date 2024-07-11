package main.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosConversorMonedas(
        @JsonAlias("base_code") String monedaBase,
        @JsonAlias("target_code") String monedaObjetivo,
        @JsonAlias("conversion_rate") Double tasaConversion,
        @JsonAlias("conversion_result") Double resultado ) {
}
