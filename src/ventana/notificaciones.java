
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

/**
 *
 * @author Fabro
 */
public class notificaciones extends JPanel{
    public notificaciones(){
        // Establecer el tamaño preferido del panel
        setPreferredSize(new Dimension(800, 500));
        setBackground(Color.WHITE);
        setLayout(null);
        //Botones de pestañas
        JButton Lista = new JButton("LISTA DE CONTACTOS");
        Lista.setFont(new Font("Arial", Font.BOLD, 12));
        Lista.setBackground(Color.ORANGE);
        Lista.setBounds(50, 20, 200, 35);
         ActionListener oyenteIN = new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                inicial in = new inicial();
                
        
        in.setSize(800, 500);
        in.setLocation(0, 0);
                removeAll();
                add(in,BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        };
        Lista.addActionListener(oyenteIN);
        
        
        JButton notis = new JButton("NOTIFICACIONES");
        notis.setFont(new Font("Arial", Font.BOLD, 12));
        notis.setBackground(Color.ORANGE);
        notis.setBounds(250, 20, 150, 35);
        
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
        
        JLabel pen = new JLabel("Pendientes:");
        pen.setFont(new Font("Arial", Font.BOLD, 26));
        pen.setBackground(Color.BLACK);
        pen.setBounds(50, 60, 150, 75);        
        
        
        
        
        
        
        
        
        
        
        
        add(Lista);
        add(notis);
        add(ep);
        add(pen);
        
    }
    
}