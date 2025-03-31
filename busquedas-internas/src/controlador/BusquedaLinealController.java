package controlador;

import modelo.BusquedaLinealModel;
import vista.BusquedaLinealView;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BusquedaLinealController {
    private BusquedaLinealModel model;
    private BusquedaLinealView view;

    public BusquedaLinealController(BusquedaLinealModel model, BusquedaLinealView view) {
        this.model = model;
        this.view = view;
        initController();
        view.setVisible(true);
    }

    private void initController() {
        view.getBtnInsert().addActionListener(e -> insertar());
        view.getBtnUpdate().addActionListener(e -> actualizar());
        view.getBtnDelete().addActionListener(e -> eliminar());
        view.getBtnBuscar().addActionListener(e -> buscar());
        view.getBtnReset().addActionListener(e -> reiniciar());
        actualizarTabla();
    }

    private void insertar() {
        String clave = view.getTxtInsert();
        if (clave.isEmpty())
            return;
        boolean exito = model.insertar(clave);
        if (exito) {
            int indice = model.getUltimoIndiceInsertado();
            // En búsqueda lineal cada inserción es secuencial, sin colisiones
            String mensaje = "Clave '" + clave + "' insertada en el índice " + indice + " (Sin colisión)";
            JOptionPane.showMessageDialog(view, mensaje);
        } else {
            JOptionPane.showMessageDialog(view, "Estructura llena.");
        }
        view.setTxtInsert("");
        actualizarTabla();
    }

    private void actualizar() {
        try {
            int index = Integer.parseInt(view.getTxtUpdateIndex());
            String valor = view.getTxtUpdateValue();
            if (model.actualizar(index, valor)) {
                JOptionPane.showMessageDialog(view, "Índice " + index + " actualizado a '" + valor + "'");
            } else {
                JOptionPane.showMessageDialog(view, "Índice inválido.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Índice inválido.");
        }
        view.setTxtUpdateIndex("");
        view.setTxtUpdateValue("");
        actualizarTabla();
    }

    private void eliminar() {
        try {
            int index = Integer.parseInt(view.getTxtDelete());
            if (model.eliminar(index)) {
                JOptionPane.showMessageDialog(view, "Índice " + index + " eliminado.");
            } else {
                JOptionPane.showMessageDialog(view, "Índice inválido.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Índice inválido.");
        }
        view.setTxtDelete("");
        actualizarTabla();
    }

    private void buscar() {
        String clave = view.getTxtBuscar();
        int indice = model.buscar(clave);
        if (indice != -1) {
            JOptionPane.showMessageDialog(view, "Clave '" + clave + "' encontrada en el índice " + indice);
        } else {
            JOptionPane.showMessageDialog(view, "Clave no encontrada.");
        }
        view.setTxtBuscar("");
    }

    private void reiniciar() {
        model.reiniciar();
        actualizarTabla();
    }

    private void actualizarTabla() {
        DefaultTableModel dtm = view.getTableModel();
        dtm.setRowCount(0);
        String[] estructura = model.getEstructura();
        for (int i = 0; i < estructura.length; i++) {
            String valor = (estructura[i] == null) ? "-" : estructura[i];
            dtm.addRow(new Object[]{i, valor, "-"});
        }
    }
}
