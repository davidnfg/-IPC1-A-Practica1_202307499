package ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import javax.swing.filechooser.FileNameExtensionFilter;
import static ventana.principal.code;

class Message {
    String text;
    String timestamp;
    boolean isSentByCurrentUser;

    public Message(String text, String timestamp, boolean isSentByCurrentUser) {
        this.text = text;
        this.timestamp = timestamp;
        this.isSentByCurrentUser = isSentByCurrentUser;
    }
}

public class ChatWindow extends JFrame {
    private String currentUser;
    private String contactUser;
    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;
    private List<Message> messages;
    private JButton loadMatrixAButton;
    private JButton loadMatrixBButton;
    private boolean isMatrixALoaded;
    private boolean isMatrixBLoaded;

    public ChatWindow(String currentUser, String contactUser, List<Message> messages) {
        this.currentUser = currentUser;
        this.contactUser = contactUser;
        this.messages = messages;
        this.isMatrixALoaded = false;
        this.isMatrixBLoaded = false;
        initUI();
    }
    String codigoStr = Integer.toString(code);

    private void initUI() {
        setTitle("Chat with " + codigoStr);
        setSize(800, 500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        

        JPanel chatPanel = new JPanel(new BorderLayout());
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        chatPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());
        messageField = new JTextField();
        sendButton = new JButton("Enviar");
        sendButton.setEnabled(false);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        JPanel sidePanel = new JPanel(new GridLayout(4, 1));
        sidePanel.setPreferredSize(new Dimension(200, 0));

        loadMatrixAButton = new JButton("Cargar Matriz A");
        loadMatrixAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadMatrixA();
            }
        });

        loadMatrixBButton = new JButton("Cargar Matriz B");
        loadMatrixBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadMatrixB();
            }
        });

        sidePanel.add(new JLabel("Ruta de la matriz clave A:"));
        sidePanel.add(loadMatrixAButton);
        sidePanel.add(new JLabel("Ruta de la matriz clave B:"));
        sidePanel.add(loadMatrixBButton);

        add(chatPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        add(sidePanel, BorderLayout.EAST);

        displayMessages();
    }

    private void displayMessages() {
        chatArea.setText("");
        for (Message message : messages) {
            if (message.isSentByCurrentUser) {
                chatArea.append("Yo: " + message.text + " (" + message.timestamp + ")\n");
            } else {
                chatArea.append(contactUser + ": " + message.text + " (" + message.timestamp + ")\n");
            }
        }
    }

    private void sendMessage() {
        String text = messageField.getText();
        if (!text.isEmpty()) {
            
            String encryptedMessage = encryptMessage(text);
            String timestamp = getCurrentTimestamp();
            messages.add(new Message(encryptedMessage, timestamp, true));
            messageField.setText("");
            displayMessages();
        }
    }

    private void loadMatrixA() {
         JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Seleccionar archivo de matriz A");
    
    // Filtro para mostrar solo archivos de texto
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
    fileChooser.setFileFilter(filter);
    
    int result = fileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        
        try {
            
            FileReader fileReader = new FileReader(selectedFile);
            
            
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            
            ArrayList<ArrayList<Integer>> matrixA = new ArrayList<>();
            
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                
                String[] elements = line.split(";");
                
                
                ArrayList<Integer> row = new ArrayList<>();
                
                
                for (String element : elements) {
                    row.add(Integer.parseInt(element));
                }
                
                
                matrixA.add(row);
            }
            
            
            bufferedReader.close();
            
            
            isMatrixALoaded = true;
            
            
            enableSendButtonIfReady();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

    private void loadMatrixB() {
        JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Seleccionar archivo de matriz B");
    
    // Filtro para mostrar solo archivos de texto
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
    fileChooser.setFileFilter(filter);
    
    int result = fileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        
        try {
           
            FileReader fileReader = new FileReader(selectedFile);
            
            
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            
            ArrayList<ArrayList<Integer>> matrixB = new ArrayList<>();
            
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                
                String[] elements = line.split(";");
                
                
                ArrayList<Integer> row = new ArrayList<>();
                
                
                for (String element : elements) {
                    row.add(Integer.parseInt(element));
                }
                
                
                matrixB.add(row);
            }
            
            
            bufferedReader.close();
            
            
            isMatrixBLoaded = true;
            
           
            enableSendButtonIfReady();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

    private void enableSendButtonIfReady() {
        if (isMatrixALoaded && isMatrixBLoaded) {
            sendButton.setEnabled(true);
        }
    }

    private String encryptMessage(String message) {
       
        return message;
    }

    private String getCurrentTimestamp() {
       LocalDateTime now = LocalDateTime.now();

    // Formateamos la fecha y hora en el formato deseado
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
    String formattedDateTime = now.format(formatter);

    return formattedDateTime;
    }
}
