package controlador;

import modelo.BusquedaBinariaModel;
import vista.BusquedaBinariaView;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BusquedaBinariaController {
    private BusquedaBinariaModel model;
    private BusquedaBinariaView view;

    public BusquedaBinariaController(BusquedaBinariaModel model, BusquedaBinariaView view) {
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
        try {
            int clave = Integer.parseInt(view.getTxtInsert());
            if (model.insertar(clave)) {
                int index = model.getLista().indexOf(clave);
                String mensaje = "Clave '" + clave + "' insertada en el índice " + index + " (Sin colisión)";
                JOptionPane.showMessageDialog(view, mensaje);
            } else {
                JOptionPane.showMessageDialog(view, "Estructura llena.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Ingrese un valor numérico.");
        }
        view.setTxtInsert("");
        actualizarTabla();
    }

    private void actualizar() {
        try {
            int index = Integer.parseInt(view.getTxtUpdateIndex());
            int nuevoValor = Integer.parseInt(view.getTxtUpdateValue());
            if (model.actualizar(index, nuevoValor)) {
                JOptionPane.showMessageDialog(view, "Índice " + index + " actualizado a '" + nuevoValor + "'");
            } else {
                JOptionPane.showMessageDialog(view, "Índice inválido.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Valores inválidos.");
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
        try {
            int clave = Integer.parseInt(view.getTxtBuscar());
            int indice = model.buscar(clave);
            if (indice != -1) {
                JOptionPane.showMessageDialog(view, "Clave '" + clave + "' encontrada en el índice " + indice);
            } else {
                JOptionPane.showMessageDialog(view, "Clave no encontrada.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Ingrese un valor numérico.");
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
        int index = 0;
        for (Integer valor : model.getLista()) {
            dtm.addRow(new Object[]{index, valor, "-"});
            index++;
        }
    }
}
