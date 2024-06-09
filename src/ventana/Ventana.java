
package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.security.auth.spi.LoginModule;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Fabro
 */
public class Ventana extends JFrame{
    public Ventana (){
        this.setSize(800, 500);
        login();
        setTitle("CipherChat");
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    } 
     void login(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        this.getContentPane().add(panel);
        
        JLabel titulo = new JLabel("INICIO DE SESION", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial",Font.BOLD,26));
        titulo.setBounds(250, 5, 300, 35);
        panel.add(titulo);
        
        ImageIcon iconL = new ImageIcon(getClass().getResource("iconL.png"));
        JLabel iconLabel = new JLabel(iconL);
        iconLabel.setBounds(290, 0, 200, 200);
        iconLabel.setIcon(new ImageIcon(iconL.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
     
       panel.add(iconLabel);
       
       JLabel email = new JLabel("Ingresa tu Codigo:", SwingConstants.CENTER);
       email.setFont(new Font("Arial",Font.BOLD,18));
       email.setBounds(150, 180, 200, 25);
       
        panel.add(email);
        
       JLabel pw = new JLabel("Ingresa tu contraseña:", SwingConstants.CENTER);
       pw.setFont(new Font("Arial",Font.BOLD,18));
       pw.setBounds(150, 230, 200, 25);
       
        panel.add(pw);
        
        JTextField emailField = new JTextField();
         emailField.setBounds(350, 180, 200, 25);
         
         panel.add(emailField);
         
         JTextField pwField = new JTextField();
         pwField.setBounds(350, 230, 200, 25);
         
         panel.add(pwField);
         
        JButton iniciar = new JButton();
        iniciar.setText("Iniciar Sesion");
        iniciar.setFont(new Font("Arial", Font.BOLD, 16));
        iniciar.setForeground(Color.WHITE);
        iniciar.setBackground(Color.BLACK);
        iniciar.setBounds(400, 300, 150, 50);
        ActionListener oyenteI = new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!emailField.getText().isEmpty()&&!pwField.getText().isEmpty()){
                    if(UsuarioLogic.autentificar(emailField.getText(), pwField.getText())){
                        JOptionPane.showMessageDialog(Ventana.this, "¡Bienvenido!");
                        inicial inicio = new inicial();
                        inicio.setSize(800, 500);
        inicio.setLocation(0, 0);
                panel.removeAll();
                panel.add(inicio,BorderLayout.CENTER);
                panel.revalidate();
                panel.repaint();
                    }else{
                        JOptionPane.showMessageDialog(Ventana.this, "Codigo o usuario incorrectos");
                    }
                } else{
                    JOptionPane.showMessageDialog(Ventana.this, "Falta ingresar codigo y contraseña");
                }
                
            }
        };
         iniciar.addActionListener(oyenteI);
        
        
        panel.add(iniciar);
        
        JButton regis = new JButton("");
        regis.setText("¿No tienes cuenta?, crea una");
        regis.setFont(new Font("Arial", Font.BOLD, 14));
        regis.setForeground(Color.WHITE);
        regis.setBackground(Color.BLACK);
        regis.setBounds(100, 300, 250, 50);
        
        ActionListener oyenteR = new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                registro r1 = new registro();
                
        
        r1.setSize(800, 500);
        r1.setLocation(0, 0);
                panel.removeAll();
                panel.add(r1,BorderLayout.CENTER);
                panel.revalidate();
                panel.repaint();
            }
        };
        regis.addActionListener(oyenteR);    
        
        panel.add(regis);
        
    }
    }
//------------------------------------(Esto significa que aqui termina una clase)