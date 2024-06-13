

package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static ventana.principal.code;

/**
 *
 * @author Fabro
 */
public class edit extends JPanel{
    public edit(){
         // Establecer el tamaño preferido del panel
        setPreferredSize(new Dimension(800, 500));
        setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel codeJ = new JLabel("Codigo:");
        codeJ.setFont(new Font("Arial", Font.BOLD, 16));
        codeJ.setBackground(Color.BLACK);
        codeJ.setBounds(50, 80, 150, 35);
        //String codigoStr = Integer.toString(code);
        JTextField codeF = new JTextField("20230000");
        codeF.setBounds(50, 120, 150, 35);
        codeF.setEditable(true);
        //
        JLabel nameJ = new JLabel("Nombre:");
        nameJ.setFont(new Font("Arial", Font.BOLD, 16));
        nameJ.setBounds(50, 150, 150, 35);
        
        JTextField nameF = new JTextField();
        nameF.setBounds(50, 190, 150, 35);
        //
        JLabel lastJ = new JLabel("Apellido:");
        lastJ.setFont(new Font("Arial", Font.BOLD, 16));
        lastJ.setBounds(50, 240, 150, 35);
        
        JTextField lastF = new JTextField();
        lastF.setBounds(50, 280, 150, 35);
        //
        JLabel genJ = new JLabel("Genero:");
        genJ.setFont(new Font("Arial", Font.BOLD, 16));
        genJ.setBounds(300, 80, 150, 35);
        
        JTextField genF = new JTextField();
        genF.setBounds(300, 120, 150, 35);
        //
       
        JLabel edadJ = new JLabel("Edad:");
        edadJ.setFont(new Font("Arial", Font.BOLD, 16));
        edadJ.setBounds(300, 150, 150, 35);
        
        JTextField edadF = new JTextField();
        edadF.setBounds(300, 190, 150, 35);
        
        //
        JLabel telJ = new JLabel("Telefono:");
        telJ.setFont(new Font("Arial", Font.BOLD, 16));
        telJ.setBounds(300, 240, 150, 35);
        
        JTextField telF = new JTextField();
        telF.setBounds(300, 280, 150, 35);
        
        //
        JLabel passwJ = new JLabel("Password:");
        passwJ.setFont(new Font("Arial", Font.BOLD, 16));
        passwJ.setBounds(550, 80, 150, 35);
        
        JTextField passwF = new JTextField();
        passwF.setBounds(550, 120, 150, 35);
        
        JButton Act = new JButton("ACTUALIZAR");
        Act.setForeground(Color.WHITE);
        Act.setBackground(Color.BLACK);
        Act.setFont(new Font("Arial", Font.BOLD, 16));
        Act.setBounds(550, 280, 150, 35);
        Act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (!nameF.getText().isEmpty()&&!lastF.getText().isEmpty()
                &&!passwF.getText().isEmpty()
                &&!edadF.getText().isEmpty()&&!telF.getText().isEmpty()&&!telF.getText().isEmpty()) {
            
            Usuarios usuario = new Usuarios(codeF.getText(),nameF.getText(),lastF.getText(),edadF.getText(),
            telF.getText(),genF.getText(),passwF.getText());
                   System.out.println("Mandando 3: "+code);
            if (UsuarioLogic.modificar(usuario)) {
                
                JOptionPane.showMessageDialog(edit.this, "Usuario modificado correctamente.");
                admin in = new admin();
                
        
        in.setSize(800, 500);
        in.setLocation(0, 0);
                removeAll();
                add(in,BorderLayout.CENTER);
                revalidate();
                repaint();
                
         
            }else{
                JOptionPane.showMessageDialog(edit.this, "Usuario no encontrado" );
            }
            
        }
                
      
    }
});
            

       
        

     
        add(codeJ);
        add(codeF);
        add(nameJ);
        add(nameF);
        add(lastJ);
        add(lastF);
        add(genF);
        add(genJ);
        add(edadJ);
        add(edadF);
        add(telJ);
        add(telF);
        add(passwJ);
        add(passwF);
        add(Act);
    }
    
}
    

