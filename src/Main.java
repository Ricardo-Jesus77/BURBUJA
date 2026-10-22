import java.util.Arrays;

public class Main {

    public static void ordenamientoBurbuja(int[] arreglo) {
        int n = arreglo.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    public static void ordenamientoBurbujaMejorado(int[] arreglo) {
        int n = arreglo.length;
        boolean huboIntercambio;
        int pasadas = 0;

        for (int i = 0; i < n - 1; i++) {
            huboIntercambio = false;
            pasadas++;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    huboIntercambio = true;
                }
            }

            // sin intercambios: ya está ordenado
            if (!huboIntercambio) {
                break;
            }
        }

        System.out.println("   [mejorado] pasadas: " + pasadas);
    }

    public static void imprimir(String etiqueta, int[] arreglo) {
        System.out.println(etiqueta + Arrays.toString(arreglo));
    }

    public static void ejecutarPrueba(String nombre, int[] original) {
        System.out.println("==================================================");
        System.out.println("CASO: " + nombre);
        System.out.println("==================================================");

        int[] copiaTradicional = original.clone();
        int[] copiaMejorado = original.clone();

        imprimir("Estado inicial          : ", original);

        ordenamientoBurbuja(copiaTradicional);
        imprimir("Burbuja tradicional     : ", copiaTradicional);

        ordenamientoBurbujaMejorado(copiaMejorado);
        imprimir("Burbuja mejorado (flag) : ", copiaMejorado);

        System.out.println("¿Coinciden? " + Arrays.equals(copiaTradicional, copiaMejorado));
        System.out.println();
    }

    public static void main(String[] args) {

        // desordenado
        ejecutarPrueba("Arreglo desordenado",
                new int[]{64, 34, 25, 12, 22, 11, 90});

        // parcialmente ordenado
        ejecutarPrueba("Arreglo parcialmente ordenado",
                new int[]{1, 2, 3, 4, 5, 7, 6});

        // ya ordenado
        ejecutarPrueba("Arreglo ya ordenado",
                new int[]{10, 20, 30, 40, 50, 60});

        // peor caso
        ejecutarPrueba("Arreglo en orden inverso",
                new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1});

        // duplicados y negativos
        ejecutarPrueba("Arreglo con duplicados y negativos",
                new int[]{5, -3, 0, 5, 2, -8, 2, 9, 0});
    }
}