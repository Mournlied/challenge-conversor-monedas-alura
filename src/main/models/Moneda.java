package main.models;

import java.util.Map;


public class Moneda {
    private String monedaBase;
    private Map<String,Double> tasaConversion;
    
    public Moneda(DatosMoneda datosMoneda) {
        this.monedaBase = datosMoneda.monedaBase();
        this.tasaConversion = datosMoneda.tasaConversion();
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public Map<String, Double> getTasaConversion() {
        return tasaConversion;
    }

    @Override
    public String toString() {
        return monedaBase + ":\n" +
                "   Peso Argentino (ARS): " + tasaConversion.get("ARS") + "\n"+
                "   Boliviano (BOB): " + tasaConversion.get("BOB") + "\n"+
                "   Real Brasileño (BRL): " + tasaConversion.get("BRL") + "\n"+
                "   Peso Chileno (CLP): " + tasaConversion.get("CLP") + "\n"+
                "   Peso Colombiano (COP): " + tasaConversion.get("COP") + "\n"+
                "   Dolar Estadounidense (USD): " + tasaConversion.get("USD") + "\n";
    }
}
