import java.sql.Array;
import java.util.Arrays;

public class Prueba {

    public static void main(String[] args) {
        radixSort rs = new radixSort();
        Prueba prueba = new Prueba();
        int[] a = { 10, 20, 22, 30, 40, 50, 60, 70, 80, 90, 12 };
        System.out.println(Arrays.deepToString(rs.cam(a)));
        System.out.println(Arrays.toString(a));
        prueba.radix(a);
    }

    public void radix(int[] arreglo) {
        int x, i, j;
        for (x = Integer.SIZE - 1; x >= 0; x--) {
            int aux[] = new int[arreglo.length];
            j = 0;
            for (i = 0; i < arreglo.length; i++) {
                boolean mover = arreglo[i] << x >= 0;
                if (x == 0 ? !mover : mover) {
                    aux[j] = arreglo[i];
                    j++;
                } else {
                    arreglo[i - j] = arreglo[i];
                }
            }
            for (i = j; i < aux.length; i++) {
                aux[i] = arreglo[i - j];
            }
            arreglo = aux;
        }
        System.out.println(Arrays.toString(arreglo));
    }

}