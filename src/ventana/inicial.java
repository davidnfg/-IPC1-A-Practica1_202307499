
package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Fabro
 */
public class inicial extends JPanel{
    public inicial (){
        // Establecer el tamaño preferido del panel
        setSize(800, 500);
        setBackground(Color.white);
        setLayout(null);
        
        //Botones pestañas
        JButton Lista = new JButton("LISTA DE CONTACTOS");
        Lista.setFont(new Font("Arial", Font.BOLD, 12));
        Lista.setBackground(Color.ORANGE);
        Lista.setBounds(50, 20, 200, 35);
        
        
        JButton notis = new JButton("NOTIFICACIONES");
        notis.setFont(new Font("Arial", Font.BOLD, 12));
        notis.setBackground(Color.ORANGE);
        notis.setBounds(250, 20, 150, 35);
        
        ActionListener oyentNT = new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                notificaciones nt = new notificaciones();
                
        
        nt.setSize(800, 500);
        nt.setLocation(0, 0);
                removeAll();
                add(nt,BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        };
        notis.addActionListener(oyentNT);
        
        JButton ep = new JButton("EDITAR PERFIL");
        ep.setFont(new Font("Arial", Font.BOLD, 12));
        ep.setBackground(Color.ORANGE);
        ep.setBounds(400, 20, 150, 35);
        
        ActionListener oyentEP = new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                Editar_Perfil ep = new Editar_Perfil();
                
        
        ep.setSize(800, 500);
        ep.setLocation(0, 0);
                removeAll();
                add(ep,BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        };
        ep.addActionListener(oyentEP);
        //BUSQUEDA
        
        JLabel TC = new JLabel("TUS CONTACTOS:");
        TC.setFont(new Font("Arial", Font.BOLD, 28));
        TC.setBounds(50, 50, 251, 60);
        
        JLabel search = new JLabel("Buscar Contactos:");
        search.setFont(new Font("Arial", Font.BOLD, 20));
        search.setBounds(550, 50, 200, 60);
        
        JTextField scode = new JTextField();
        scode.setBounds(550, 100, 200, 30);
        
        JButton agregar = new JButton("AGREGAR");
        agregar.setBackground(Color.YELLOW);
        agregar.setBounds(575, 140, 150, 50);
        
       
        JButton logout = new JButton("LOG OUT");
        logout.setForeground(Color.white);
        logout.setBackground(Color.red);
        logout.setBounds(575, 400, 150, 50);
        
       ActionListener oyentlo = new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
               Ventana inicio = new Ventana();
               inicio.setVisible(true);
        
        }
        };
       logout.addActionListener(oyentlo);
        
        
        
        add(Lista);
        add(notis);
        add(ep);
        add(TC);
        add(search);
        add(scode);
        add(agregar);
        add(logout);
    }
    
}
