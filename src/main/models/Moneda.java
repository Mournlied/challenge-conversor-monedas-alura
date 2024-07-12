package main.models;

import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Moneda {
    private String monedaBase;
    private Map<String,Double> tasaConversion;
    private TreeMap<String,Double> tasasFiltradas;
    private List<String> monedasFiltradas = Arrays.asList("ARS","BOB","BRL","CLP","COP","EUR","PEN","PYG","UYU","USD");
    
    public Moneda(DatosMoneda datosMoneda) {
        this.monedaBase = datosMoneda.monedaBase();
        this.tasaConversion = datosMoneda.tasaConversion();
        this.tasasFiltradas = new TreeMap<>(monedasFiltradas.stream().filter(tasaConversion::containsKey).collect(Collectors.toMap(Function.identity(), tasaConversion::get)));
    }

    public String getMonedaBase() {return monedaBase;
    }

    public Map<String, Double> getTasasFiltradas() {
        return tasasFiltradas;
    }
}
