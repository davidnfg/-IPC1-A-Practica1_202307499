package ventana;

public class UsuarioLogic {
    static UsuarioOB usuarioOB = new UsuarioOB();
    static admin adminPanel; // Referencia al panel de admin

    public static void setAdminPanel(admin panel) {
        adminPanel = panel;
    }

    public static boolean insertar(Usuarios nuevoUsuario) {
        boolean resultado = usuarioOB.insertar(nuevoUsuario);
        if (resultado && adminPanel != null) {
            adminPanel.actualizarTablaUsuarios();
        }
        return resultado;
    }

    public static boolean modificar(Usuarios usuarioModificado) {
        boolean resultado = usuarioOB.modificar(usuarioModificado);
        if (resultado && adminPanel != null) {
            adminPanel.actualizarTablaUsuarios();
        }
        return resultado;
    }

    public static boolean eliminar(String codigo) {
        boolean resultado = usuarioOB.eliminar(codigo);
        if (resultado && adminPanel != null) {
            adminPanel.actualizarTablaUsuarios();
        }
        return resultado;
    }

    public static Usuarios obtener(String codigo) {
        return usuarioOB.obtener(codigo);
    }

    public static int buscar(String codigo) {
        return usuarioOB.buscar(codigo);
    }

    public static boolean autentificar(String codigo, String contra) {
        Usuarios usuario = obtener(codigo);
        return usuario != null && usuario.getCodigo().equals(codigo) && usuario.getContra().equals(contra);
    }
}
