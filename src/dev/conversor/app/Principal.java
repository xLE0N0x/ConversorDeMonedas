package dev.conversor.app;

import dev.conversor.ui.AppUI;

public class Principal {

    public static void main(String[] args) {
        AppUI appUI = new AppUI();

        appUI.mostrarMensajeBienvenida();
        while (true) {
            var codigoBase = appUI.mostrarMenuDivisas("A continuación selecciona la divisa base:");
            var codigoTarget = appUI.mostrarMenuDivisas("Ahora selecciona la divisa de destino:");
            var montoAConvertir = appUI.montoDivisa();
            appUI.convertirDivisa(codigoBase, codigoTarget, montoAConvertir);
            String opcionContinuar = appUI.bucleMoneda();

            if (opcionContinuar.equals("no")) {
                appUI.salirDelPrograma();
                break;
            }
        }
    }
}
