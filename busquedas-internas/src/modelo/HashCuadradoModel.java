package modelo;

public class HashCuadradoModel extends HashModel {

    public HashCuadradoModel(int tamanoTabla) {
        super(tamanoTabla);
    }

    @Override
    protected int calcularHash(String clave) {
        try {
            int num = Integer.parseInt(clave);
            long cuadrado = (long) (num * num);
            String cuadradoStr = String.valueOf(cuadrado);

            // Determinar cuántos dígitos centrales tomar según el tamaño de la tabla
            int digitosCentrales = String.valueOf(tamanoTabla).length();
            int longitud = cuadradoStr.length();
            int inicio;

            if (longitud % 2 == 0 || digitosCentrales == 1) {
                // Si la longitud es par o solo se toma un dígito, calcular inicio normalmente
                inicio = (longitud - digitosCentrales) / 2;
            } else {
                // Si la longitud es impar y se toman dos dígitos, incluir el central y el de la izquierda
                inicio = (longitud - digitosCentrales) / 2 - 1;
            }

            // Extraer los dígitos centrales
            String centralStr = cuadradoStr.substring(inicio, inicio + digitosCentrales);
            int centralNum = Integer.parseInt(centralStr) + 1; // Sumar 1 al número central
            int hash = centralNum % tamanoTabla;

            // Resolver colisiones buscando un índice válido
            int indice = hash;
            while (!esIndiceValido(indice)) {
                indice = (indice + 1) % tamanoTabla; // Prueba lineal
            }
            return indice;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Método auxiliar para verificar si un índice es válido
    private boolean esIndiceValido(int indice) {
        // Implementa la lógica para verificar si el índice está disponible
        // Por ejemplo, verifica si la posición en la tabla está vacía
        return true;
    }
}