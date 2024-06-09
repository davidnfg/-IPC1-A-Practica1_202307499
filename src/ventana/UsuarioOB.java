
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
        int n = -1;
        for (int i = 0; i < usuario.size(); i++) {
            if(usuario.get(i).getCodigo().equals(codigo)){
                n=i;
                break;
            }
            
        }
        return n;
    }
    public boolean insertar(Usuarios codigo){
        if(buscar(codigo.getCodigo())==-1){
            usuario.add(codigo);
            return true;
        }else{
            return false;
        }
        
    }
      public boolean modificar(Usuarios usuario){
          if(buscar(usuario.getCodigo()) !=-1){
              return true;
          }else{
              return false;
          }
}
    public boolean eliminar(String codigo){
        if(buscar(codigo) != -1){
            usuario.remove(buscar(codigo));
            return true;
            
        }else{
            return false;
        }
    }
    public Usuarios obtener (String codigo){
        if(buscar(codigo)!=-1){
            return usuario.get(buscar(codigo));
        }else{
            return null;
        }
    }
    
    
}
