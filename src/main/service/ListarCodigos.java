package main.service;

import main.models.DatosCodigos;

public class ListarCodigos {
    private final String API_KEY = System.getenv("ER_APIKEY");
    ConsumirAPI consumirAPI = new ConsumirAPI();
    ConvertirDatos convertirDatos = new ConvertirDatos();
    String codigos = consumirAPI.consumirAPI("https://v6.exchangerate-api.com/v6/"+ API_KEY + "/codes");
    DatosCodigos listaCodigos = convertirDatos.parseData(codigos, DatosCodigos.class);
    
    public void mostrarListaCompleta(){
        listaCodigos.listaCodigos().forEach(System.out::println);
    }
    
    public void mostrarListaFiltrada(){
        var listaFiltrada = listaCodigos.listaCodigos().stream()
                .filter(m->m.contains("ARS")||m.contains("BOB")||m.contains("BRL")||m.contains("CLP")||m.contains("COP")||m.contains("EUR")||m.contains("PEN")
                        ||m.contains("PYG")||m.contains("UYU")||m.contains("USD")).toList();
        listaFiltrada.forEach(System.out::println);
    }
}
