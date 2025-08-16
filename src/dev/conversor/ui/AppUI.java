package dev.conversor.ui;

import dev.conversor.model.Conversor;
import dev.conversor.services.RequestAPI;

import java.util.Locale;
import java.util.Scanner;

public class AppUI {

    Scanner teclado = new Scanner(System.in);

    public void mostrarMensajeBienvenida() {
        System.out.println("""
                ************************************************************
                *           Bienvenido/a al conversor de divisas           *
                ************************************************************
                
                A continuacion debe selecciona, en primera instancia, la 
                moneda que desea convertir, posteriormente seleccionar la 
                moneda de objetivo: (ej: UDS a CLP)
                """);
        System.out.println("Seleccione una opción:");
    }

    public String mostrarMenuDivisas(String mensaje) {
        System.out.println("""
                1. USD - Dolar estadounidense
                2. CLP - Peso chileno
                3. ARS - Peso argentino
                4. BRL - Real brasileño
                5. COP - Peso colombiano
                6. BOB - Boliviano boliviano
                """);
        System.out.println(mensaje);
        int opcionDivisa = teclado.nextInt();
        String codigoDivisaSeleccionada;
        switch (opcionDivisa) {
            case 1:
                codigoDivisaSeleccionada = "USD";
                break;
            case 2:
                codigoDivisaSeleccionada = "CLP";
                break;
            case 3:
                codigoDivisaSeleccionada = "ARS";
                break;
            case 4:
                codigoDivisaSeleccionada = "BRL";
                break;
            case 5:
                codigoDivisaSeleccionada = "COP";
                break;
            case 6:
                codigoDivisaSeleccionada = "BOB";
                break;
            default:
                System.out.println("La opcion que digito no es valida. Intentelo nuevamente.");
                return mostrarMenuDivisas(mensaje);
        }
        return codigoDivisaSeleccionada;
    }

    public void convertirDivisa(String codigoBase, String codigoTarget, Double montoAConvertir) {
        RequestAPI request = new RequestAPI();
        Conversor conversor = new Conversor();

        var requestMoneda = request.obtenerDatosDivisa(codigoBase, codigoTarget); // Obtengo datos de la API
        var conversionRate = conversor.convertirDatos(requestMoneda).conversion_rate(); // obtengo valor moneda

        obtenerResultado(codigoBase, codigoTarget, montoAConvertir, conversionRate);

    }

    public Double montoDivisa() {
        System.out.println("Ingrese el monto de que desea convertir: ");
        Double monto = teclado.nextDouble();
        return monto;
    }


    public void obtenerResultado(String codigoBase, String codigoTarget, Double montoAConvertir, Double conversionRate) {
        System.out.println(
                "Moneda base seleccionada: " + codigoBase +
                        ", Monto a convertir: $ " + montoAConvertir + ".");
        System.out.println(
                "Moneda objetivo seleccionada: " + codigoTarget +
                        ", valor convertido: $ " + (conversionRate * montoAConvertir + "."));
    }

    public String bucleMoneda() {
        System.out.println("Desea realizar otra conversión? Si/N0");
        String opcionContinuar = teclado.next().toLowerCase(Locale.ROOT);
        return opcionContinuar;
    }

    public void salirDelPrograma() {
        System.out.println("Saliendo del programa. ¡Hasta la proxima!");
    }
}
