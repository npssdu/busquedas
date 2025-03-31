package modelo;

public class BusquedaLinealModel {
    private String[] estructura;
    private int nextIndex;

    public BusquedaLinealModel(int tamano) {
        estructura = new String[tamano];
        nextIndex = 0;
    }

    public boolean insertar(String clave) {
        if (nextIndex < estructura.length) {
            estructura[nextIndex] = clave;
            nextIndex++;
            return true;
        }
        return false;
    }

    public int getUltimoIndiceInsertado() {
        return nextIndex - 1;
    }

    public String[] getEstructura() {
        return estructura;
    }

    public boolean actualizar(int index, String valor) {
        if (index >= 0 && index < estructura.length) {
            estructura[index] = valor;
            return true;
        }
        return false;
    }

    public boolean eliminar(int index) {
        if (index >= 0 && index < estructura.length) {
            estructura[index] = null;
            return true;
        }
        return false;
    }

    public int buscar(String clave) {
        for (int i = 0; i < estructura.length; i++) {
            if (clave.equals(estructura[i])) {
                return i;
            }
        }
        return -1;
    }

    public void reiniciar() {
        for (int i = 0; i < estructura.length; i++) {
            estructura[i] = null;
        }
        nextIndex = 0;
    }
}
