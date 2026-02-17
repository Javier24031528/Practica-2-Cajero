import java.util.ArrayList;
import java.util.List;

public class CajeroControlador {
    private List<Usuario> usuarios;
    private Usuario usuarioActual;

    public CajeroControlador() {
        usuarios = new ArrayList<>();
        // Inicializamos con los datos del código original
        usuarios.add(new Usuario("1234", "Juan", 1000.0));
        usuarios.add(new Usuario("5678", "Maria", 2500.0));
    }

    public boolean validarPin(String pin) {
        for (Usuario u : usuarios) {
            if (u.getPin().equals(pin)) {
                usuarioActual = u;
                return true;
            }
        }
        return false;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public double consultarSaldo() {
        return usuarioActual.getSaldo();
    }

    public boolean realizarRetiro(double cantidad) {
        return usuarioActual.retirar(cantidad);
    }

    public void realizarDeposito(double cantidad) {
        usuarioActual.depositar(cantidad);
    }
}