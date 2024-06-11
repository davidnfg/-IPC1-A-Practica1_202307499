package ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.GenericSignatureFormatError;
import javax.security.auth.spi.LoginModule;
import static ventana.principal.code;

;


public class registro extends JPanel{
    //int code = 20230000;
   //String codigoStr = Integer.toString(code);
    
    
    
    public registro() {
        
        // Establecer el tamaño preferido del panel
        setPreferredSize(new Dimension(800, 500));
        setBackground(Color.WHITE);
        setLayout(null);

        // Crear los componentes
        JLabel codigo = new JLabel("Tu codigo:");
        codigo.setFont(new Font("Arial", Font.BOLD, 18));
        codigo.setBounds(200, 30, 100, 40);
        
        JTextField codigoF = new JTextField();
        codigoF.setBounds(300, 40, 200, 20);
        
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
        
        JTextField passwF = new JTextField(15);
        passwF.setBounds(300, 130, 200, 20);
        
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
        sing.setBounds(300, 300, 160, 60);
        sing.setText("SING UP");
        sing.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        
                
        String codigoStr = Integer.toString(code);        
        if (!nameF.getText().isEmpty()&&!lastF.getText().isEmpty()
                &&!passwF.getText().isEmpty()
                &&!edadF.getText().isEmpty()&&!telF.getText().isEmpty()) {
            //String codigoStr = Integer.toString(code);
            String selectedGender = (String)genderComboBox.getSelectedItem();
            Usuarios usuario = new Usuarios(codigoStr,nameF.getText(),lastF.getText(),edadF.getText(),
            telF.getText(),selectedGender,passwF.getText()); 
            if (UsuarioLogic.insertar(usuario)) {
                JOptionPane.showMessageDialog(registro.this, "USUARIO CREADO. TU CODIGO ES: "+code);
                System.out.println("mandado: "+code);
                code +=1;
            Ventana login = new Ventana();
            login.setVisible(true);
            
          
            }else{
                JOptionPane.showMessageDialog(registro.this, "Usuario ya existente" );
                
            }
            
        }
                
      
    }
    
});
        
        
        
        
         
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
        add(codigo);
        add(codigoF);
          //add(genF);
          add(genderComboBox);
        
    }

    
}
