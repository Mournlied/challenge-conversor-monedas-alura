package main.models;

import java.util.Map;

public class Moneda {
    private String monedaBase;
    private Map<String,Double> tasaConversion;
    private FiltroMonedas filtro;
    
    public Moneda(DatosMoneda datosMoneda) {
        this.monedaBase = datosMoneda.monedaBase();
        this.tasaConversion = datosMoneda.tasaConversion();
        this.filtro = datosMoneda.filtro();
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
                "   Peso Argentino (ARS): " + filtro.ars() + "\n"+
                "   Boliviano (BOB): " + filtro.bob() + "\n"+
                "   Real Brasileño (BRL): " + filtro.brl() + "\n"+
                "   Peso Chileno (CLP): " + filtro.clp() + "\n"+
                "   Peso Colombiano (COP): " + filtro.cop() + "\n"+
                "   Dolar Estadounidense (USD): " + filtro.usd() + "\n";
    }
}
