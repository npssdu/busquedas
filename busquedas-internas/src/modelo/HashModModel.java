package modelo;

public class HashModModel extends HashModel {

    public HashModModel(int tamanoTabla) {
        super(tamanoTabla);
    }

    @Override
    protected int calcularHash(String clave) {
        try {
            int num = Integer.parseInt(clave);
            return num % tamanoTabla + 1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
