public class Calculos {
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