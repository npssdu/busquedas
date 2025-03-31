package vista;

import javax.swing.*;
import java.awt.*;

public class HashTruncamientoView extends HashView {
    private JTextField txtPosiciones;

    public HashTruncamientoView() {
        super("Función Hash Truncamiento");
        // Panel adicional para ingresar las posiciones
        JPanel panelExtra = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelExtra.add(new JLabel("Posiciones (separadas por comas):"));
        txtPosiciones = new JTextField(15);
        panelExtra.add(txtPosiciones);
        // Se añade este panel en la parte inferior de la ventana
        add(panelExtra, BorderLayout.SOUTH);
    }

    public String getTxtPosiciones() {
        return txtPosiciones.getText().trim();
    }
}
