package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public abstract class HashView extends JFrame {
    protected JTextField txtInsert, txtUpdateOld, txtUpdateNew, txtDelete, txtBuscar;
    protected JButton btnInsert, btnUpdate, btnDelete, btnBuscar, btnReset;
    protected JTable table;
    protected DefaultTableModel tableModel;

    public HashView(String title) {
        setTitle(title);
        setLayout(new BorderLayout());
        JPanel panelControls = new JPanel(new GridLayout(0, 2, 5, 5));

        // Insertar
        panelControls.add(new JLabel("Insertar clave:"));
        txtInsert = new JTextField();
        panelControls.add(txtInsert);
        btnInsert = new JButton("Insertar");
        panelControls.add(btnInsert);
        panelControls.add(new JLabel(""));

        // Actualizar
        panelControls.add(new JLabel("Actualizar clave (vieja):"));
        txtUpdateOld = new JTextField();
        panelControls.add(txtUpdateOld);
        panelControls.add(new JLabel("Actualizar clave (nueva):"));
        txtUpdateNew = new JTextField();
        panelControls.add(txtUpdateNew);
        btnUpdate = new JButton("Actualizar");
        panelControls.add(btnUpdate);
        panelControls.add(new JLabel(""));

        // Eliminar
        panelControls.add(new JLabel("Eliminar clave:"));
        txtDelete = new JTextField();
        panelControls.add(txtDelete);
        btnDelete = new JButton("Eliminar");
        panelControls.add(btnDelete);
        panelControls.add(new JLabel(""));

        // Buscar
        panelControls.add(new JLabel("Buscar clave:"));
        txtBuscar = new JTextField();
        panelControls.add(txtBuscar);
        btnBuscar = new JButton("Buscar");
        panelControls.add(btnBuscar);
        panelControls.add(new JLabel(""));

        // Reiniciar
        btnReset = new JButton("Reiniciar");
        panelControls.add(btnReset);
        panelControls.add(new JLabel(""));

        add(panelControls, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"Índice", "Clave(s)", "Colisiones"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    // Métodos getters y setters
    public String getTxtInsert() { return txtInsert.getText().trim(); }
    public String getTxtUpdateOld() { return txtUpdateOld.getText().trim(); }
    public String getTxtUpdateNew() { return txtUpdateNew.getText().trim(); }
    public String getTxtDelete() { return txtDelete.getText().trim(); }
    public String getTxtBuscar() { return txtBuscar.getText().trim(); }

    public void setTxtInsert(String text) { txtInsert.setText(text); }
    public void setTxtUpdateOld(String text) { txtUpdateOld.setText(text); }
    public void setTxtUpdateNew(String text) { txtUpdateNew.setText(text); }
    public void setTxtDelete(String text) { txtDelete.setText(text); }
    public void setTxtBuscar(String text) { txtBuscar.setText(text); }

    public JButton getBtnInsert() { return btnInsert; }
    public JButton getBtnUpdate() { return btnUpdate; }
    public JButton getBtnDelete() { return btnDelete; }
    public JButton getBtnBuscar() { return btnBuscar; }
    public JButton getBtnReset() { return btnReset; }
    public DefaultTableModel getTableModel() { return tableModel; }
    public JTable getTable() { return table; }
}
