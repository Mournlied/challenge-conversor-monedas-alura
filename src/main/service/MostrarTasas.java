package main.service;

import main.models.DatosConversorMonedas;
import main.models.DatosMoneda;
import main.models.Moneda;

public class MostrarTasas {
    private final String API_KEY = System.getenv("ER_APIKEY");
    ConsumirAPI consumirAPI = new ConsumirAPI();
    ConvertirDatos convertirDatos = new ConvertirDatos();

    public void totalTasas(String moneda) {
        var json = consumirAPI.consumirAPI("https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + moneda.toUpperCase());
        var monedaUsuario = convertirDatos.parseData(json, DatosMoneda.class);
        monedaUsuario.tasaConversion().forEach((k, v) -> System.out.println(k + ": " + v));
    }

    public void tasasFiltradas(String moneda) {
        var json = consumirAPI.consumirAPI("https://v6.exchangerate-api.com/v6/"+ API_KEY + "/latest/" + moneda.toUpperCase());
        Moneda monedaUsuario = new Moneda(convertirDatos.parseData(json, DatosMoneda.class));
        monedaUsuario.getTasasFiltradas().forEach((k,v)-> System.out.println(k + ": " + v));
    }

    public void tasasEntreMonedas(String monedaBase, String monedaObjetivo){
        var json = consumirAPI.consumirAPI("https://v6.exchangerate-api.com/v6/"+ API_KEY + "/pair/"+monedaBase.toUpperCase()+"/"+monedaObjetivo.toUpperCase());
        var conversion = convertirDatos.parseData(json, DatosConversorMonedas.class);
        System.out.println("La tasa de conversion de "+conversion.monedaBase()+" a "+conversion.monedaObjetivo()+" es: "+conversion.tasaConversion());
    }
}
