public class Main {
    public static void main(String[] args) {
        CajeroControlador controlador = new CajeroControlador();
        CajeroVista vista = new CajeroVista();

        vista.mostrarMensaje("=== Bienvenido al Cajero (MVC) ===");

        int intentos = 0;
        boolean autenticado = false;

        while (intentos < 3 && !autenticado) {
            String pin = vista.leerPin();
            if (controlador.validarPin(pin)) {
                autenticado = true;
            } else {
                vista.mostrarMensaje("PIN incorrecto.");
                intentos++;
            }
        }

        if (!autenticado) {
            vista.mostrarMensaje("Demasiados intentos fallidos. Adiós.");
            return;
        }

        vista.mostrarMensaje("Bienvenido, " + controlador.getUsuarioActual().getNombre());

        boolean salir = false;
        while (!salir) {
            int opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1:
                    vista.mostrarMensaje("Su saldo es: $" + controlador.consultarSaldo());
                    break;
                case 2:
                    double retiro = vista.leerCantidad("retirar");
                    if (controlador.realizarRetiro(retiro)) {
                        vista.mostrarMensaje("Retiro exitoso. Nuevo saldo: $" + controlador.consultarSaldo());
                    } else {
                        vista.mostrarMensaje("Fondos insuficientes.");
                    }
                    break;
                case 3:
                    double deposito = vista.leerCantidad("depositar");
                    controlador.realizarDeposito(deposito);
                    vista.mostrarMensaje("Depósito exitoso. Nuevo saldo: $" + controlador.consultarSaldo());
                    break;
                case 4:
                    salir = true;
                    vista.mostrarMensaje("Gracias por usar el cajero.");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
                    break;
            }
        }
    }
}