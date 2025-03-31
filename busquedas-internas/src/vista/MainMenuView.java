package vista;

import javax.swing.*;
import java.awt.*;

public class MainMenuView extends JFrame {
    private JComboBox<String> comboAlgoritmos;
    private JTextField txtTamano;
    private JButton btnIniciar;

    public MainMenuView() {
        // Configurar Look and Feel Nimbus (opcional)
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("No se pudo aplicar Nimbus Look and Feel");
        }

        setTitle("Menú Búsquedas Internas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal con márgenes
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel de datos con GridBagLayout para organizar los componentes
        JPanel panelDatos = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Etiqueta y combo para seleccionar el método
        JLabel labelMetodo = new JLabel("Seleccione el método:");
        labelMetodo.setFont(new Font("Arial", Font.BOLD, 16));
        labelMetodo.setForeground(new Color(0, 102, 204)); // Azul
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelDatos.add(labelMetodo, gbc);

        String[] opciones = {
                "Búsqueda Lineal",
                "Búsqueda Binaria",
                "Hash Mod",
                "Hash Cuadrado",
                "Hash Plegamiento",
                "Hash Truncamiento"
        };
        comboAlgoritmos = new JComboBox<>(opciones);
        comboAlgoritmos.setFont(new Font("Arial", Font.PLAIN, 14));
        comboAlgoritmos.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        panelDatos.add(comboAlgoritmos, gbc);

        // Etiqueta y campo de texto para el tamaño de la estructura
        JLabel labelTamano = new JLabel("Tamaño de la estructura:");
        labelTamano.setFont(new Font("Arial", Font.BOLD, 16));
        labelTamano.setForeground(new Color(0, 102, 204));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelDatos.add(labelTamano, gbc);

        txtTamano = new JTextField(10);
        txtTamano.setFont(new Font("Arial", Font.PLAIN, 14));
        txtTamano.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        panelDatos.add(txtTamano, gbc);

        // Botón iniciar con cambios en fuente y colores
        btnIniciar = new JButton("Iniciar");
        btnIniciar.setFont(new Font("Arial", Font.BOLD, 14));
        btnIniciar.setBackground(new Color(0, 153, 76)); // Verde
        btnIniciar.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelDatos.add(btnIniciar, gbc);

        // Agregar el panel de datos al panel principal
        mainPanel.add(panelDatos, BorderLayout.CENTER);
        add(mainPanel);

        pack();
        setLocationRelativeTo(null);
    }

    public String getMetodoSeleccionado() {
        return (String) comboAlgoritmos.getSelectedItem();
    }

    public int getTamano() {
        try {
            return Integer.parseInt(txtTamano.getText().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public JButton getBtnIniciar() {
        return btnIniciar;
    }
}
