public class radixSort {
    public int[][] cam(int[] arr) {
        if (arr.length == 0) // Verificar vacio
            return null;
        int[][] np = new int[arr.length][2]; // Aqui se almancena las listas
        int[] q = new int[256];// Arreglo axuiliar
        int i, j, k, l, f = 0;// Variables a usar
        for (k = 0; k < 4; k++) {// Inicio del recorrido
            for (i = 0; i < (np.length - 1); i++)// Usando la matriz para colocar indice de lista
                np[i][1] = i + 1;
            np[i][1] = -1;// Ultimo valor
            for (i = 0; i < q.length; i++)// Inicializando la auxiliar
                q[i] = -1;
            for (f = i = 0; i < arr.length; i++) {// Inicio de metodo
                j = ((255 << (k << 3)) & arr[i]) >> (k << 3);// Hace los corrimientos necesarios para ordenar
                System.out.println((255 << (k << 3)));
                if (q[j] == -1) {// Asigna las listas del 0 al tamano del arreglo
                    l = q[j] = f;
                } else {
                    l = q[j];
                    while (np[l][1] != -1) {// Le dice hasta donde va llegar en los caso 1121231234
                        l = np[l][1];
                    }
                    np[l][1] = f;// Asigna las listas en la matris
                    l = np[l][1];// Limite
                }
                f = np[f][1];// Asignacion en cada lista
                np[l][0] = arr[i];// Se pasan del array origunal al auxiliar
                np[l][1] = -1;
            }
            for (l = q[i = j = 0]; i < 256; i++)// Regresa lo de auxiliar a el original
                for (l = q[i]; l != -1; l = np[l][1])
                    arr[j++] = np[l][0];
        }
        return np;
    }
}
