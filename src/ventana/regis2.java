

package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static ventana.principal.code;

/**
 *
 * @author Fabro
 */
public class regis2 extends JPanel{
    public regis2(){
        // Establecer el tamaño preferido del panel
        setPreferredSize(new Dimension(800, 500));
        setBackground(Color.WHITE);
        setLayout(null);

        // Crear los componentes
        
        JLabel titulo = new JLabel("REGISTRO");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setBounds(350, 20, 100, 40);
        
        JLabel name = new JLabel("Nombre:");
        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setBounds(200, 60, 100, 40);
        
        JTextField nameF = new JTextField(15);
        nameF.setBounds(300, 70, 200, 20);
        
        JLabel lastn = new JLabel("Apellido:");
        lastn.setFont(new Font("Arial", Font.BOLD, 18));
        lastn.setBounds(200, 90, 100, 40);
        
        JTextField lastF = new JTextField(15);
        lastF.setBounds(300, 100, 200, 20);
        
        JLabel passw = new JLabel("Password:");
        passw.setFont(new Font("Arial", Font.BOLD, 18));
        passw.setBounds(200, 120, 100, 40);
        
        JPasswordField passwF= new JPasswordField();
        passwF.setBounds(300, 130, 200, 20);
        JCheckBox showPassword = new JCheckBox("Mostrar contraseña");
    showPassword.setBounds(500, 130, 200, 25);
   add(showPassword);
    
    showPassword.addItemListener(e -> {
        if (showPassword.isSelected()) {
            passwF.setEchoChar((char) 0);
        } else {
            passwF.setEchoChar('*');
        }
    });
        
        JLabel gen = new JLabel("Genero:");
        gen.setFont(new Font("Arial", Font.BOLD, 18));
        gen.setBounds(200, 150, 100, 40);
        
        //JTextField genF =new JTextField();
        //genF.setBounds(300, 160, 150, 25);
        String[] genders = {"Masculino", "Femenino"};
        JComboBox genderComboBox = new JComboBox<>(genders);
        genderComboBox.setBounds(300, 160, 150, 25);
        
        JLabel edad = new JLabel("Edad:");
        edad.setFont(new Font("Arial", Font.BOLD, 18));
        edad.setBounds(200, 200, 100, 40);
        
        JTextField edadF = new JTextField(15);
        edadF.setBounds(300, 210, 200, 20);
    
        JLabel tel = new JLabel("Telefono:");
        tel.setFont(new Font("Arial", Font.BOLD, 18));
        tel.setBounds(200, 230, 100, 40);
        
        JTextField telF = new JTextField(15);
        telF.setBounds(300, 240, 200, 20);
       
        JButton sing = new JButton();
        sing.setFont(new Font("Arial", Font.BOLD, 18));
        
        sing.setForeground(Color.WHITE);
        sing.setBackground(Color.BLACK);
        sing.setBounds(300, 300, 200, 60);
        sing.setText("REGISTRARSE");
        sing.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        char[] passwordChars = passwF.getPassword();
                String password = new String(passwordChars);
                
        String codigoStr = Integer.toString(code);        
        if (!nameF.getText().isEmpty()&&!lastF.getText().isEmpty()
                &&!password.isEmpty()
                &&!edadF.getText().isEmpty()&&!telF.getText().isEmpty()) {
            
            String selectedGender = (String)genderComboBox.getSelectedItem();
            Usuarios usuario = new Usuarios(codigoStr,nameF.getText(),lastF.getText(),edadF.getText(),
            telF.getText(),selectedGender,password); 
            if (UsuarioLogic.insertar(usuario)) {
                JOptionPane.showMessageDialog(regis2.this, "USUARIO CREADO");
                System.out.println("mandado: "+code);
                code +=1;
            admin in = new admin();
                
        
        in.setSize(800, 500);
        in.setLocation(0, 0);
                removeAll();
                add(in,BorderLayout.CENTER);
                revalidate();
                repaint();
            
          
            }else{
                
                JOptionPane.showMessageDialog(regis2.this, "Usuario ya existente" );
                
            }
            
        }
                
      
    }
    
});
        
        
        
        
         add(titulo);
        add(name);
        add(lastn);
        add(passw);
       add(gen);
        add(edad);
        add(tel);
        add(nameF);
        add(lastF);
        add(edadF);
        add(telF);
        add(passwF);
        add(sing);
        //add(genderComboBox);
       
          //add(genF);
          add(genderComboBox);
    }
    
}
