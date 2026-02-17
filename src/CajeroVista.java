import java.util.Scanner;

public class CajeroVista {
    private Scanner scanner;

    public CajeroVista() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarMensajeSinSalto(String mensaje) {
        System.out.print(mensaje);
    }

    public String leerPin() {
        System.out.print("Ingrese su PIN: ");
        return scanner.nextLine();
    }

    public int mostrarMenu() {
        System.out.println("\n1. Ver saldo");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Depositar dinero");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        return opcion;
    }

    public double leerCantidad(String accion) {
        System.out.print("Ingrese cantidad a " + accion + ": ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine(); // limpiar buffer
        return cantidad;
    }
}