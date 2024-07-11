package main;

import main.models.DatosConversorMonedas;
import main.models.DatosMoneda;
import main.models.Moneda;
import main.service.ConsumirAPI;
import main.service.ConvertirDatos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    private final String API_KEY = System.getenv("ER_APIKEY");
    Scanner scanner = new Scanner(System.in);
    ConsumirAPI consumirAPI = new ConsumirAPI();
    ConvertirDatos convertirDatos = new ConvertirDatos();
    Map<DatosConversorMonedas,Double> historial = new HashMap<>();
    
    
    public void showMenu() {
        int i = -1;
        System.out.println("Bienvenido al conversor de monedas de Mournlied");
        while (i != 0) {
            System.out.println("""
                    
                    *****************************************************************
                    Por favor, ingrese el numero de la consulta que desea realizar:
                    
                    1- Ver todas las tasas de conversiones para una moneda
                    2- Ver las conversiones a ARS, BOB, BRL, CLP, COP y USD para una moneda
                    3- Ver la tasa de conversion entre dos monedas especificas
                    4- Convertir el valor de una moneda a otra
                    5- Ver historial de valores convertidos
                    
                    0- Salir de la aplicación
                    *****************************************************************
                    
                    """);
            i = scanner.nextInt();
            scanner.nextLine();
            switch (i) {
                case 1:
                    mostrarTasasConversiones();
                    break;
                case 2:
                    mostrarTasasConversionesFiltradas();
                    break;
                case 3:
                    mostrarTasasEntreMonedas();
                    break;
                case 4:
                    convertirValor();
                    break;
                case 5:
                    mostrarHistorial();
                    break;
                case 0:
                    System.out.println("Saliendo de la Aplicación...");
                    System.out.println("Gracias por usar nuestro servicio");
                    break;
                default:
                    System.out.println("Opcion inválida");
            }
        }
    }

    private void mostrarTasasConversiones() {
        System.out.println("Ingrese el codigo de tres letras ISO 4217 de la moneda que desea consultar");
        System.out.println("Ejemplo: USD");
        String moneda = scanner.nextLine();
        var json = consumirAPI.consumirAPI("https://v6.exchangerate-api.com/v6/"+ API_KEY + "/latest/" + moneda.toUpperCase());
        Moneda monedaUsuario = new Moneda(convertirDatos.parseData(json, DatosMoneda.class));
        monedaUsuario.getTasaConversion().forEach((k,v)-> System.out.println(k+": "+v));
    }

    private void mostrarTasasConversionesFiltradas() {
        System.out.println("Ingrese el codigo de tres letras ISO 4217 de la moneda que desea consultar");
        System.out.println("Ejemplo: USD");
        String moneda = scanner.nextLine();
        var json = consumirAPI.consumirAPI("https://v6.exchangerate-api.com/v6/"+ API_KEY + "/latest/" + moneda.toUpperCase());
        Moneda monedaUsuario = new Moneda(convertirDatos.parseData(json, DatosMoneda.class));
        System.out.println(monedaUsuario);
    }
    
    private void mostrarTasasEntreMonedas(){
        System.out.println("Ingrese el codigo de tres letras ISO 4217 de la moneda que desea usar como base");
        System.out.println("Ejemplo: USD");
        String monedaBase = scanner.nextLine();
        System.out.println("Ingrese el codigo de la moneda objetivo");
        String monedaObjetivo = scanner.nextLine();
        var json = consumirAPI.consumirAPI("https://v6.exchangerate-api.com/v6/"+ API_KEY + "/pair/"+monedaBase.toUpperCase()+"/"+monedaObjetivo.toUpperCase());
        var conversion = convertirDatos.parseData(json, DatosConversorMonedas.class);
        System.out.println("La tasa de conversion de "+conversion.monedaBase()+" a "+conversion.monedaObjetivo()+" es: "+conversion.tasaConversion());
    }
    
    private void convertirValor(){
        System.out.println("Ingrese el codigo de tres letras ISO 4217 de la moneda que desea usar como base");
        System.out.println("Ejemplo: USD");
        String monedaBase = scanner.nextLine();
        System.out.println("Ingrese el codigo de la moneda objetivo");
        String monedaObjetivo = scanner.nextLine();
        System.out.println("Ingrese el valor que desea convertir");
        var valor = scanner.nextDouble();
        var json = consumirAPI.consumirAPI("https://v6.exchangerate-api.com/v6/"+ API_KEY + "/pair/"+monedaBase.toUpperCase()+"/"+monedaObjetivo.toUpperCase()+"/"+valor);
        var conversion = convertirDatos.parseData(json, DatosConversorMonedas.class);
        System.out.println(valor+" "+conversion.monedaBase()+" = "+conversion.resultado()+" "+conversion.monedaObjetivo());
        System.out.println("La tasa de conversion actual es: "+conversion.tasaConversion());
        historial.put(conversion,valor);
    }

    private void mostrarHistorial(){
        historial.forEach((c,v)-> System.out.println(v+" "+c.monedaBase()+" = "+c.resultado()+" "+c.monedaObjetivo()+" con tasa: "+c.tasaConversion()));
    }
}
