
package ventana;

import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author Fabro
 */
public class UsuarioOB {
    private List<Usuarios> usuario;
    
    public UsuarioOB(){
        usuario = new ArrayList<>();
    }
    public int buscar(String codigo){
        //int n = -1;
        for (int i = 0; i < usuario.size(); i++) {
            if(usuario.get(i).getCodigo().equals(codigo)){
                return i;
                
            }
            
        }
        return -1;
    }
    public boolean insertar(Usuarios codigo){
        if(buscar(codigo.getCodigo())==-1){
            usuario.add(codigo);
            return true;
        }else{
            return false;
        }
        
    }
      public boolean modificar(Usuarios usuario) {
        int indice = buscar(usuario.getCodigo());
        if (indice != -1) {
            Usuarios usuarioAux = obtener(usuario.getCodigo());
            usuarioAux.setContra(usuario.getContra());
            usuarioAux.setNombre(usuario.getNombre());
            usuarioAux.setApellido(usuario.getApellido());
            usuarioAux.setEdad(usuario.getEdad());
            usuarioAux.setTelefono(usuario.getTelefono());
            usuarioAux.setGenero(usuario.getGenero());
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminar(String codigo) {
        int indice = buscar(codigo);
        if (indice != -1) {
            usuario.remove(indice); // Elimina el usuario en el índice encontrado
            return true;
        } else {
            return false;
        }
    }

    public Usuarios obtener(String codigo) {
        int indice = buscar(codigo);
        if (indice != -1) {
            return usuario.get(indice); // Devuelve el usuario en el índice encontrado
        } else {
            return null;
        }
    }

}
    
    

