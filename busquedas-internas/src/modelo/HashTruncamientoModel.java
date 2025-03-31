package modelo;

public class HashTruncamientoModel extends HashModel {

    private int[] posiciones; // Array de posiciones (se asume que son 1-indexadas)

    public HashTruncamientoModel(int tamanoTabla) {
        super(tamanoTabla);
    }

    // Setter para las posiciones
    public void setPosiciones(int[] posiciones) {
        this.posiciones = posiciones;
    }

    @Override
    protected int calcularHash(String clave) {
        // Si no se han especificado posiciones, se usa el comportamiento por defecto:
        if (posiciones == null || posiciones.length == 0) {
            int digitos = String.valueOf(tamanoTabla - 1).length();
            String truncada = (clave.length() > digitos) ? clave.substring(clave.length() - digitos) : clave;
            try {
                int num = Integer.parseInt(truncada);
                return (num + 1) % tamanoTabla;
            } catch (NumberFormatException e) {
                return -1;
            }
        } else {
            // Se recorren las posiciones especificadas para extraer los dígitos (asumiendo posiciones 1-indexadas)
            StringBuilder sb = new StringBuilder();
            for (int pos : posiciones) {
                int idx = pos - 1; // Convertir a índice 0-based
                if (idx >= 0 && idx < clave.length()) {
                    sb.append(clave.charAt(idx));
                }
            }
            try {
                int num = Integer.parseInt(sb.toString());
                num = num + 1;
                return num % tamanoTabla;
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }
}
