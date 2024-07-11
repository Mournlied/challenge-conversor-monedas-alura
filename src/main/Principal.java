package main;

import main.service.ConsumirAPI;
import main.service.ConvertirDatos;

import java.util.Scanner;

public class Principal {
    private final String API_KEY = System.getenv("ER_APIKEY");
    public void showMenu(){
        
        
        var scanner = new Scanner(System.in);
        ConsumirAPI consumirAPI = new ConsumirAPI();
        ConvertirDatos convertirDatos = new ConvertirDatos();
        int i = 0;
        while (i != 9) {
            System.out.println("""
                    Bienvenido al conversor de monedas de Mournlied
                    
                    Por favor, ingrese el numero de la solicitud que desea realizar:
                    
                    1- Ver todas las tasas de conversiones para una moneda
                    2- Ver las conversiones a ARS, BOB, BRL, CLP, COP y USD para una moneda
                    2- Ver la tasa de conversion entre dos monedas especificas
                    3- Convertir el valor de una moneda a otra
                    
                    """);
            i = scanner.nextInt();
            switch (i){
                case 1:
                    System.out.println("Ingrese el codigo de tres letras ISO 4217 de la moneda que desea consultar");
                    System.out.println("Ejemplo: USD");
                    String userCoin = scanner.nextLine();
                    mostrarTasasConversiones(userCoin);
                    break;
                case 2:
                    System.out.println("");
                case 3:
                    System.out.println("");
            }
        }
    }

    private void mostrarTasasConversiones(String coin) {
        
    }
}
