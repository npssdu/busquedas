package modelo;

public class HashPlegamientoModel extends HashModel {

    public HashPlegamientoModel(int tamanoTabla) {
        super(tamanoTabla);
    }

    @Override
    protected int calcularHash(String clave) {
        // Se define el tamaño del grupo como la longitud del máximo índice (tamanoTabla - 1)
        int groupSize = String.valueOf(tamanoTabla - 1).length();
        int suma = 0;

        // Se recorren la clave en grupos de "groupSize" dígitos
        for (int i = 0; i < clave.length(); i += groupSize) {
            int fin = Math.min(i + groupSize, clave.length());
            String grupo = clave.substring(i, fin);
            try {
                int num = Integer.parseInt(grupo);
                suma += num;
            } catch (NumberFormatException e) {
                // En caso de error, se retorna -1
                return -1;
            }
        }
        // Se le suma 1 al resultado de la suma de grupos
        suma += 1;
        // Se aplica el módulo para asegurar que el hash esté en el rango de la tabla
        return suma % tamanoTabla;
    }
}
