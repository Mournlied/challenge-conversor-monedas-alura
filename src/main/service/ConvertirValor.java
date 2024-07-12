package main.service;

import main.models.DatosConversorMonedas;

public class ConvertirValor {
    private final String API_KEY = System.getenv("ER_APIKEY");
    ConsumirAPI consumirAPI = new ConsumirAPI();
    ConvertirDatos convertirDatos = new ConvertirDatos();
    
    public DatosConversorMonedas convertirValores(Double valor, String monedaBase, String monedaObjetivo){
        var json = consumirAPI.consumirAPI("https://v6.exchangerate-api.com/v6/"+ API_KEY + "/pair/"+monedaBase.toUpperCase()+"/"+monedaObjetivo.toUpperCase()+"/"+valor);
        var conversion = convertirDatos.parseData(json, DatosConversorMonedas.class);
        System.out.println(valor+" "+conversion.monedaBase()+" = "+conversion.resultado()+" "+conversion.monedaObjetivo());
        System.out.println("La tasa de conversion actual es: "+conversion.tasaConversion());
        return  conversion;
    }
}
