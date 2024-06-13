package ventana;

import java.util.ArrayList;
import java.util.List;

public class UsuarioOB {
    public static List<Usuarios> usuario = new ArrayList<>();

    public boolean insertar(Usuarios nuevoUsuario) {
        return usuario.add(nuevoUsuario);
    }

    public boolean modificar(Usuarios usuarioModificado) {
        for (int i = 0; i < usuario.size(); i++) {
            if (usuario.get(i).getCodigo().equals(usuarioModificado.getCodigo())) {
                usuario.set(i, usuarioModificado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(String codigo) {
        return usuario.removeIf(u -> u.getCodigo().equals(codigo));
    }

    public Usuarios obtener(String codigo) {
        for (Usuarios u : usuario) {
            if (u.getCodigo().equals(codigo)) {
                return u;
            }
        }
        return null;
    }

    public int buscar(String codigo) {
        for (int i = 0; i < usuario.size(); i++) {
            if (usuario.get(i).getCodigo().equals(codigo)) {
                return i;
            }
        }
        return -1;
    }
}


    
    

    
    

