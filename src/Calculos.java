public class Calculos {
    public float determinante1(float[][] matriz) {
        return matriz[0][0];
    }

    public float determinante2(float[][] matriz) {
        return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz [1][0];
    }

    public float determinanteSarrus(float[][] matriz) {
        float somatorioDiagPrinc = 0;
        for (int k = 0; k < 3; k++) {
            float multiplicador = 1;
            int contadorI = 0, contadorJ = k;
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if (contadorJ == matriz[0].length) {
                        contadorJ = 0;
                    }
                    if (i == contadorI && j == contadorJ) {
                        multiplicador *= matriz[i][j];
                        contadorI++;
                        contadorJ++;
                    }
                }
            }
            somatorioDiagPrinc += multiplicador;
        }

        float somatorioDiagSec = 0;
        for (int k = 2; k >= 0; k--) {
            float multiplicador = 1;
            int contadorI = 0, contadorJ = k;
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if (contadorJ == -1) {
                        contadorJ = matriz[0].length - 1;
                    }
                    if (i == contadorI && j == contadorJ) {
                        multiplicador *= matriz[i][j];
                        contadorI++;
                        contadorJ--;
                    }
                }
            }
            somatorioDiagSec += multiplicador;
        }

        return somatorioDiagPrinc - somatorioDiagSec;
    }

    public float[][] inverterMatriz(Matriz matriz) {
        if (matriz.getElementos().length != matriz.getElementos()[0].length) {
            System.out.println(
                    "A matriz precisa possuir a mesma quantidade de linhas e colunas!\n");
            return null;
        }

        float[][] matrizIdentidade = new float[matriz.getLinhas()][matriz.getColunas()];
        float[][] matrizResultante = new float[matriz.getLinhas()][matriz.getColunas()];
        for (int i = 0; i < matrizResultante.length; i++) {
            for (int j = 0; j < matrizResultante[0].length; j++) {

                if (i == j) {
                    int[] n = new int[matriz.getElementos()[0].length * 4];
                    int contador = 0;
                    for (int aux = 0; aux < matriz.getElementos()[0].length; aux++) {
                        n[contador] = i;
                        contador++;
                        n[contador] = aux;
                        contador++;
                        n[contador] = aux;
                        contador++;
                        n[contador] = j;
                        contador++;
                    }

                }
                else {

                }
            }
        }

        return matrizResultante;
    }

    public float[][] transporMatriz(Matriz matriz) {
        float[][] matrizResultante = new float[matriz.getColunas()][matriz.getLinhas()];

        for (int i = 0; i < matriz.getLinhas(); i++){
            for (int j = 0; j < matriz.getColunas(); j++){
                matrizResultante[j][i] = matriz.getElementos()[i][j];
            }
        }

        return matrizResultante;
    }

    public float[][] oporMatriz(Matriz matriz) {
        float[][] matrizResultante = new float[matriz.getLinhas()][matriz.getColunas()];

        for (int i = 0; i < matriz.getLinhas(); i++){
            for (int j = 0; j < matriz.getColunas(); j++){
                if (matriz.getElementos()[i][j] == 0) {
                    matrizResultante[i][j] = 0;
                    continue;
                }
                matrizResultante[i][j] = matriz.getElementos()[i][j] * -1;
            }
        }

        return matrizResultante;
    }

    public float[][] somarMatrizes(Matriz matriz1, Matriz matriz2) {
        if (matriz1.getLinhas() != matriz2.getLinhas()
                || matriz2.getColunas() != matriz2.getColunas()) {
            System.out.println("As matrizes precisam ser iguais em números de linhas e colunas.\n");
            return null;
        }

        float[][] matrizResultante = new float[matriz1.getLinhas()][matriz2.getColunas()];
        for (int i = 0; i < matrizResultante.length; i++){
            for (int j = 0; j < matrizResultante[0].length; j++){
                matrizResultante[i][j] = matriz1.getElementos()[i][j] + matriz2.getElementos()[i][j];
            }
        }

        return matrizResultante;
    }

    public float[][] subtrairMatrizes(Matriz matriz1, Matriz matriz2) {
        if (matriz1.getLinhas() != matriz2.getLinhas()
                || matriz2.getColunas() != matriz2.getColunas()) {
            System.out.println("As matrizes precisam ser iguais em números de linhas e colunas.\n");
            return null;
        }

        float[][] matrizResultante = new float[matriz1.getLinhas()][matriz2.getColunas()];
        for (int i = 0; i < matrizResultante.length; i++){
            for (int j = 0; j < matrizResultante[0].length; j++){
                matrizResultante[i][j] = matriz1.getElementos()[i][j] - matriz2.getElementos()[i][j];
            }
        }

        return matrizResultante;
    }

    public float[][] multiplicarMatrizes(Matriz matriz1, Matriz matriz2) {
        if (matriz1.getElementos()[0].length != matriz2.getElementos().length) {
            System.out.println(
                    "O número de colunas da primeira matriz deve ser igual ao número de linhas da segunda matriz.\n");
            return null;
        }

        float[][] matrizResultante = new float[matriz1.getElementos().length][matriz2.getElementos()[0].length];
        for (int i = 0; i < matrizResultante.length; i++) {
            for (int j = 0; j < matrizResultante[0].length; j++) {

                //Calcular elemento [i][j] da matriz resultante
                float somatorio = 0;
                for (int aux = 0; aux < matriz1.getElementos()[0].length; aux++) {
                    float mult = matriz1.getElementos()[i][aux] * matriz2.getElementos()[aux][j];
                    somatorio += mult;
                }
                matrizResultante[i][j] = somatorio;

            }
        }

        return matrizResultante;
    }
}