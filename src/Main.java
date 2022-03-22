import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Calculos calcular = new Calculos();
        ArrayList<Matriz> matrizes = new ArrayList<>();
        String string1, string2;
        int opcaoMenu, int1, int2;

        do {
            mostrarMatrizes(matrizes);
            System.out.println("------------MENU------------\n");
            System.out.println("1 - Criar matriz");
            System.out.println("2 - Excluir matriz");
            System.out.println("3 - Somar matrizes");
            System.out.println("4 - Subtrair matrizes");
            System.out.println("5 - Multiplicar matrizes");
            System.out.println("6 - Sair\n");
            System.out.print("Insira a opção: ");
            opcaoMenu = scan.nextInt();

            switch (opcaoMenu) {
                case 1:
                    limpar();
                    mostrarMatrizes(matrizes);

                    //Informações da matriz:
                    System.out.println("--------CRIAR MATRIZ--------\n");
                    System.out.print("Informe o nome da matriz: ");
                    string1 = scan.next();
                    System.out.print("Informe o número de linhas da matriz: ");
                    int1 = scan.nextInt();
                    System.out.print("Informe o número de colunas da matriz: ");
                    int2 = scan.nextInt();
                    System.out.println();

                    //Criação da matriz:
                    Matriz matriz = new Matriz(string1, int1, int2);
                    matriz.setElementos();
                    matriz.setTipoTamanho();
                    matriz.setTipoElementos();
                    salvarMatriz(matrizes, matriz);

                    voltarMenu();
                    limpar();
                    break;
                case 2:
                    limpar();
                    mostrarMatrizes(matrizes);

                    //Informações da matriz
                    System.out.println("-------EXCLUIR MATRIZ-------\n");
                    System.out.print("Insira o nome da matriz que deseja excluir: ");
                    string1 = scan.next();
                    int1 = procurarIndex(matrizes, string1);
                    System.out.println();

                    //Nome inválido
                    if (int1 == -1) {
                        System.out.println("Matriz não encontrada!\n");
                        voltarMenu();
                        limpar();
                        break;
                    }

                    //Nome válido
                    matrizes.remove(int1);
                    System.out.println("Matriz excluída com sucesso!\n");

                    voltarMenu();
                    limpar();
                    break;
                case 3:
                    limpar();
                    mostrarMatrizes(matrizes);

                    //Informações das matrizes
                    System.out.println("-------SOMAR MATRIZES-------\n");
                    System.out.print("Insira o nome da primeira matriz: ");
                    string1 = scan.next();
                    int1 = procurarIndex(matrizes, string1);
                    System.out.print("Insira o nome da segunda matriz: ");
                    string2 = scan.next();
                    int2 = procurarIndex(matrizes, string2);
                    System.out.println();

                    //Nomes inválidos
                    if (nomesInvalidos(int1, int2)) {
                        voltarMenu();
                        limpar();
                        break;
                    }

                    //Nomes válidos
                    Matriz matrizSoma = new Matriz
                            (string1 + "+" + string2,
                            matrizes.get(int1).getLinhas(),
                            matrizes.get(int2).getColunas());
                    matrizSoma.setElementos
                            (calcular.somarMatrizes(matrizes.get(int1), matrizes.get(int2)));
                    if (matrizSoma.getElementos() == null) {
                        voltarMenu();
                        limpar();
                        break;
                    }
                    salvarMatriz(matrizes, matrizSoma);

                    voltarMenu();
                    limpar();
                    break;
                case 4:
                    limpar();
                    mostrarMatrizes(matrizes);

                    //Informações das matrizes
                    System.out.println("------SUBTRAIR MATRIZES------\n");
                    System.out.print("Insira o nome da primeira matriz: ");
                    string1 = scan.next();
                    int1 = procurarIndex(matrizes, string1);
                    System.out.print("Insira o nome da segunda matriz: ");
                    string2 = scan.next();
                    int2 = procurarIndex(matrizes, string2);
                    System.out.println();

                    //Nomes inválidos
                    if (nomesInvalidos(int1, int2)) {
                        voltarMenu();
                        limpar();
                        break;
                    }

                    //Nomes válidos
                    Matriz matrizSubtracao = new Matriz
                            (string1 + "-" + string2,
                            matrizes.get(int1).getLinhas(),
                            matrizes.get(int2).getColunas());
                    matrizSubtracao.setElementos
                            (calcular.subtrairMatrizes(matrizes.get(int1), matrizes.get(int2)));
                    if (matrizSubtracao.getElementos() == null) {
                        voltarMenu();
                        limpar();
                        break;
                    }
                    salvarMatriz(matrizes, matrizSubtracao);

                    voltarMenu();
                    limpar();
                    break;
                case 5:
                    limpar();
                    mostrarMatrizes(matrizes);

                    //Informações das matrizes
                    System.out.println("----MULTIPLICAR MATRIZES----\n");
                    System.out.print("Insira o nome da primeira matriz: ");
                    string1 = scan.next();
                    int1 = procurarIndex(matrizes, string1);
                    System.out.print("Insira o nome da segunda matriz: ");
                    string2 = scan.next();
                    int2 = procurarIndex(matrizes, string2);
                    System.out.println();

                    //Nomes inválidos
                    if (nomesInvalidos(int1, int2)) {
                        voltarMenu();
                        limpar();
                        break;
                    }

                    //Nomes válidos
                    Matriz matrizMultiplicacao = new Matriz
                            (string1 + "." + string2,
                            matrizes.get(int1).getLinhas(),
                            matrizes.get(int2).getColunas());
                    matrizMultiplicacao.setElementos
                            (calcular.multiplicarMatrizes(matrizes.get(int1), matrizes.get(int2)));
                    if (matrizMultiplicacao.getElementos() == null) {
                        voltarMenu();
                        limpar();
                        break;
                    }
                    salvarMatriz(matrizes, matrizMultiplicacao);

                    voltarMenu();
                    limpar();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opção não encontrada!\n");
                    voltarMenu();
                    limpar();
                    break;
            }
        }
        while (opcaoMenu != 6);
    }

    private static void mostrarMatriz(Matriz matriz){
        System.out.print("Matriz" + "(" + matriz.getNome() + ")" +
                "[" + matriz.getLinhas() + "x" + matriz.getColunas() + "]");
        if (matriz.getTipoTamanho() != null && matriz.getTipoElementos() != null) {
            System.out.println("{Matriz " + matriz.getTipoTamanho() + " e " + matriz.getTipoElementos() + "}:");
        }
        else if (matriz.getTipoTamanho() != null) {
            System.out.println("{Matriz " + matriz.getTipoTamanho() + "}:");
        }
        else if (matriz.getTipoElementos() != null) {
            System.out.println("{Matriz " + matriz.getTipoElementos() + "}:");
        }
        else {
            System.out.println("{Matriz Normal}:");
        }

        for (int i = 0; i < matriz.getElementos().length; i++) {
            for (int j = 0; j < matriz.getElementos()[0].length; j++) {
                if (j != 0) {
                    System.out.print("\t\t");
                }
                System.out.print(matriz.getElementos()[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void mostrarMatrizes(List<Matriz> matrizes){
        System.out.println("----------MATRIZES----------\n");
        if (matrizes.isEmpty()){
            System.out.println("Nenhuma matriz encontrada.\n");
        }
        for (Matriz matriz : matrizes){
            mostrarMatriz(matriz);
        }
    }

    private static void salvarMatriz(List<Matriz> matrizes, Matriz matriz){
        Scanner scan = new Scanner(System.in);

        System.out.println("Matriz resultante: ");
        mostrarMatriz(matriz);
        System.out.print("Deseja salvar a matriz?(Insira '1' para salvar): ");
        int opcaoSalvar = scan.nextInt();
        if(opcaoSalvar == 1){
            matrizes.add(matriz);
            System.out.println("Matriz salva com sucesso.\n");
        }
        else {
            System.out.println();
        }
    }

    private static int procurarIndex(List<Matriz> matrizes, String nome) {
        int index = -1;
        for (Matriz m : matrizes) {
            if (m.getNome().equals(nome)) {
                index = matrizes.indexOf(m);
            }
        }

        return index;
    }

    private static boolean nomesInvalidos(int int1, int int2) {
        if (int1 == -1 && int2 == -1) {
            System.out.println("Matrizes não encontradas!\n");
            return true;
        }
        else if (int1 == -1) {
            System.out.println("Primeira matriz não encontrada!\n");
            return true;
        }
        else if (int2 == -1) {
            System.out.println("Segunda matriz não encontrada!\n");
            return true;
        }
        else {
            return false;
        }
    }

    private static void limpar() {
        for(int clear = 0; clear < 1000; clear++)
        {
            System.out.println("\r");
        }
    }

    private static void voltarMenu() throws InterruptedException {
        for (int i = 3; i >= 1; i--){
            System.out.println("Voltando ao menu em " + i + " segundo(s)...");
            Thread.sleep(1000);
        }
    }
}