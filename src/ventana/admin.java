package ventana;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static ventana.principal.code;

public class admin extends JPanel {
    private DefaultTableModel modeloTabla;
    private JTable tablaUsuarios;

    public admin() {
        setBackground(Color.WHITE);
        setLayout(null);
        setSize(800, 500);

        // Configurar la tabla de usuarios
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Código");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Edad");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Género");

        tablaUsuarios = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
        scrollPane.setBounds(10, 10, 500, 500);


        add(scrollPane, BorderLayout.CENTER);
        
        
        JLabel elminar = new JLabel("Usuario que desea eliminar");
        elminar.setFont(new Font("Arial", Font.BOLD, 12));
        elminar.setBounds(575, 10, 200, 50);
        add(elminar);
        
        JTextField codigo = new JTextField();
        codigo.setBounds(575, 50, 150, 40);
        add(codigo);
        
        
        JButton Act = new JButton("ELIMINAR");
        Act.setForeground(Color.BLACK);
        Act.setBackground(Color.RED);
        Act.setFont(new Font("Arial", Font.BOLD, 16));
        Act.setBounds(575, 100, 150, 50);
        Act.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (!codigo.getText().isEmpty()) {
            
                   System.out.println("Mandando 3: "+code);
            if (UsuarioLogic.eliminar(codigo.getText())) {
                
                JOptionPane.showMessageDialog(admin.this, "Usuario eliminado correctamente.");
                admin in = new admin();

                
        
        in.setSize(800, 500);
        in.setLocation(0, 0);
                removeAll();
                add(in,BorderLayout.CENTER);
                revalidate();
                repaint();

            }else{
                JOptionPane.showMessageDialog(admin.this, "Usuario no encontrado" );
            }
            
        }
                
      
    }
});
        add(Act);
        
        
        JButton Edit = new JButton("EDITAR PERFIL");
        Edit.setFont(new Font("Arial", Font.BOLD, 12));
        Edit.setForeground(Color.WHITE);
        Edit.setBackground(Color.BLACK);
        Edit.setBounds(575, 200, 150, 50);
        ActionListener addEdit = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               edit in = new edit();
            in.setSize(800, 500);
            in.setLocation(0, 0);
            removeAll();
            add(in, BorderLayout.CENTER);
            revalidate();
            repaint();
            }
        };
        Edit.addActionListener(addEdit);
        add(Edit);
        
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
        add(logout);

        // Botón para agregar un nuevo usuario
        JButton añadir = new JButton("CREAR USUARIO");
        añadir.setFont(new Font("Arial", Font.BOLD, 12));
        añadir.setForeground(Color.WHITE);
        añadir.setBackground(Color.BLACK);
        añadir.setBounds(575, 300, 150, 50);
        añadir.addActionListener(e -> {
            regis2 in = new regis2();
            in.setSize(800, 500);
            in.setLocation(0, 0);
            removeAll();
            add(in, BorderLayout.CENTER);
            revalidate();
            repaint();
        });

        add(añadir, BorderLayout.SOUTH);

        // Llamar al método para inicializar la tabla con los usuarios existentes
        actualizarTablaUsuarios();
    }

    public void actualizarTablaUsuarios() {
        modeloTabla.setRowCount(0); // Limpiar la tabla
        for (Usuarios usuario : UsuarioLogic.usuarioOB.usuario) {
            Object[] fila = {
                usuario.getCodigo(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEdad(),
                usuario.getTelefono(),
                usuario.getGenero()
            };
            modeloTabla.addRow(fila);
        }
    }
    
}
