
package ventana;

/**
 *
 * @author Fabro
 */
public class UsuarioLogic {
    private static UsuarioOB usuarioOB = new UsuarioOB();
    
    public static boolean autentificar(String codigo, String contra){
        if(obtener(codigo)!=null){
            Usuarios usuarioconsulta = obtener(codigo);
            if (usuarioconsulta.getCodigo().equals(codigo)&&usuarioconsulta.getContra().equals(contra)) {
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    public static boolean insertar(Usuarios codigo){
        return usuarioOB.insertar(codigo);
        
    }
    public static boolean modificar(Usuarios usuarios){
        return usuarioOB.insertar(usuarios);
    }
    public static Usuarios obtener(String codigo){
        return usuarioOB.obtener(codigo);
    }
    public static boolean eliminar(String codigo){
        return usuarioOB.eliminar(codigo);
    }
    
    
    
}
