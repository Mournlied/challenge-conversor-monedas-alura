package main;

import main.models.*;
import main.service.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    Scanner scanner = new Scanner(System.in);
    Map<DatosConversorMonedas,Double> historial = new HashMap<>();
    ListarCodigos codigos = new ListarCodigos();
    ConvertirValor convertidor = new ConvertirValor();
    MostrarTasas mostradorTasas = new MostrarTasas();
    Integer ayudaMenu = -1;
    
    public void showMenu() {
        int i = -1;
        System.out.println("Bienvenido al conversor de monedas de Mournlied");
        while (i != 0) {
            ayudaMenu = -1;
            System.out.println("""
                    
                    *****************************************************************
                    Por favor, ingrese el número de la consulta que desea realizar:
                    
                    1- Ver todas las tasas de conversiones para una moneda
                    2- Ver las conversiones recomendadas para una moneda
                    3- Ver la tasa de conversión entre dos monedas específicas
                    4- Convertir el valor de una moneda a otra
                    5- Ver historial de valores convertidos
                    9- Ver lista completa de códigos
                    
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
                case 9:
                    codigos.mostrarListaCompleta();
                    break;
                case 0:
                    System.out.println("Saliendo de la Aplicación...");
                    System.out.println("Gracias por usar nuestro servicio");
                    break;
                default:
                    System.out.println("\n** Opción inválida **");
            }
        }
    }

    private void mostrarTasasConversiones() {
        while (ayudaMenu != 0) {
            System.out.println("""
                    
                    *****************************************************************
                    Por favor, ingrese el número de la opción que desea realizar:
                    
                    1- Ingresar código de la moneda que desea consultar(Ej: USD)
                    2- Ver lista de códigos recomendados
                    3- Ver lista completa de códigos
                    
                    9- Volver al menú anterior
                    *****************************************************************
                    
                    """);
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el código");
                    String moneda = scanner.nextLine();
                    if (moneda.length()==3){
                        mostradorTasas.totalTasas(moneda);
                        ayudaMenu = 0;
                    } else {
                        System.out.println("\n** Código inválido **");
                    }
                    break;
                case 2:
                    codigos.mostrarListaFiltrada();
                    break;
                case 3:
                    codigos.mostrarListaCompleta();
                    break;
                case 9:
                    ayudaMenu = 0;
                    break;
                default:
                    System.out.println("\n** Opción inválida **");
            }
            
        }
    }

    private void mostrarTasasConversionesFiltradas() {
        while (ayudaMenu != 0) {
            System.out.println("""
                    
                    *****************************************************************
                    Por favor, ingrese el número de la opción que desea realizar:
                    
                    1- Ingresar código de la moneda que desea consultar(Ej: USD)
                    2- Ver lista de códigos recomendados
                    3- Ver lista completa de códigos
                    
                    9- Volver al menú anterior
                    *****************************************************************
                    
                    """);
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el código");
                    String moneda = scanner.nextLine();
                    if (moneda.length()==3){
                        mostradorTasas.tasasFiltradas(moneda);
                        ayudaMenu = 0;
                    } else {
                        System.out.println("\n** Código inválido **");
                    }
                    break;
                case 2:
                    codigos.mostrarListaFiltrada();
                    break;
                case 3:
                    codigos.mostrarListaCompleta();
                    break;
                case 9:
                    ayudaMenu = 0;
                    break;
                default:
                    System.out.println("\n** Opción inválida **");
            }

        }
    }
    
    private void mostrarTasasEntreMonedas(){
        while (ayudaMenu != 0) {
            System.out.println("""
                    
                    *****************************************************************
                    Por favor, ingrese el número de la opción que desea realizar:
                    
                    1- Ingresar códigos de la monedas que desea consultar(Ej: USD)
                    2- Ver lista de códigos recomendados
                    3- Ver lista completa de códigos
                    
                    9- Volver al menú anterior
                    *****************************************************************
                    
                    """);
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el código de la moneda base");
                    String monedaBase = scanner.nextLine();
                    System.out.println("Ingrese el codigo de la moneda objetivo");
                    String monedaObjetivo = scanner.nextLine();
                    if (monedaBase.length()==3 && monedaObjetivo.length()==3){
                        mostradorTasas.tasasEntreMonedas(monedaBase,monedaObjetivo);
                        ayudaMenu = 0;
                    } else {
                        System.out.println("\n** Código(s) inválido(s) **");
                    }
                    break;
                case 2:
                    codigos.mostrarListaFiltrada();
                    break;
                case 3:
                    codigos.mostrarListaCompleta();
                    break;
                case 9:
                    ayudaMenu = 0;
                    break;
                default:
                    System.out.println("\n** Opción inválida **");
            }

        }
    }
    
    private void convertirValor(){
        while (ayudaMenu != 0) {
            System.out.println("""
                    
                    *****************************************************************
                    Por favor, ingrese el número de la opción que desea realizar:
                    
                    1- Ingresar códigos de la monedas que desea consultar(Ej: USD)
                    2- Ver lista de códigos recomendados
                    3- Ver lista completa de códigos
                    
                    9- Volver al menú anterior
                    *****************************************************************
                    
                    """);
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el codigo de la moneda que desea usar como base");
                    String monedaBase = scanner.nextLine();
                    System.out.println("Ingrese el codigo de la moneda objetivo");
                    String monedaObjetivo = scanner.nextLine();
                    System.out.println("Ingrese el valor que desea convertir (Ej: 123.456)");
                    var valor = scanner.nextDouble();
                    if (monedaBase.length()==3 && monedaObjetivo.length()==3){
                        var conversion = convertidor.convertirValores(valor,monedaBase,monedaObjetivo);
                        historial.put(conversion,valor);
                        ayudaMenu = 0;
                    } else {
                        System.out.println("\n** Código(s) inválido(s) **");
                    }
                    break;
                case 2:
                    codigos.mostrarListaFiltrada();
                    break;
                case 3:
                    codigos.mostrarListaCompleta();
                    break;
                case 9:
                    ayudaMenu = 0;
                    break;
                default:
                    System.out.println("\n** Opción inválida **");
            }

        }
    }

    private void mostrarHistorial(){
        historial.forEach((c,v)-> System.out.println(v+" "+c.monedaBase()+" = "+c.resultado()+" "+c.monedaObjetivo()+" con tasa: "+c.tasaConversion()));
    }
}
