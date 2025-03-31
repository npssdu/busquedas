package modelo;

import java.util.ArrayList;
import java.util.Collections;

public class BusquedaBinariaModel {
    private ArrayList<Integer> lista;
    private int tamano;

    public BusquedaBinariaModel(int tamano) {
        this.tamano = tamano;
        lista = new ArrayList<>();
    }

    public boolean insertar(int clave) {
        if (lista.size() < tamano) {
            lista.add(clave);
            Collections.sort(lista);
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getLista() {
        return lista;
    }

    public boolean actualizar(int index, int nuevoValor) {
        if (index >= 0 && index < lista.size()) {
            lista.set(index, nuevoValor);
            Collections.sort(lista);
            return true;
        }
        return false;
    }

    public boolean eliminar(int index) {
        if (index >= 0 && index < lista.size()) {
            lista.remove(index);
            return true;
        }
        return false;
    }

    public int buscar(int clave) {
        // Se implementa la búsqueda binaria
        int low = 0, high = lista.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = lista.get(mid);
            if (midVal < clave)
                low = mid + 1;
            else if (midVal > clave)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public void reiniciar() {
        lista.clear();
    }
}
