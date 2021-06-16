package br.com.thiago.básico;

import java.util.Scanner;

class Fila {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean acabou = false;
        int qtdElementos = 0;
        Integer[] arr = new Integer[10];

        while(!acabou) {
            switch(menu(input)){
                case 1:
                    arr = enqueue(input, arr, qtdElementos);
                    qtdElementos++;
                    break;
                case 2:
                    mostrarFila(arr);
                    break;
                case 3:
                    dequeue(arr, qtdElementos);
                    qtdElementos--;
                    break;
                case 4:
                    acabou = true;
                    break;
                default:
                    System.out.println("Informe uma opção valida");
                    break;
            }
        }
    }

    private static int menu(Scanner input) {
        int opc;
        do {
            System.out.println(
                    "1 - Adicionar na fila\n" +
                            "2 - Mostrar a fila\n" +
                            "3 - Remover da fila\n" +
                            "4 - sair\n" +
                            "Entre com a opção desejada");
            opc = input.nextInt();
        } while(opc<1 || opc>4);
        return opc;
    }

    private static Integer[] enqueue(Scanner input, Integer[] arr, int qtdElementos) {
        if(qtdElementos == arr.length){
            Integer[] temp = arr;
            arr = new Integer[qtdElementos << 1];
            System.arraycopy(temp, 0, arr, 0, qtdElementos);
        }
        System.out.println("Informe o próximo da fila");
        int n = input.nextInt();
        arr[qtdElementos] = n;
        return arr;
    }

    private static void mostrarFila(Integer[] arr) {
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] != null){
                if (i != 0){
                    System.out.print(arr[i] + " / ");
                } else {
                    System.out.print(arr[i]);
                }
            }
        }
        System.out.println();
    }

    private static void dequeue(Integer[] arr, int qtdElementos) {
        int temp = arr[0];
        if (qtdElementos - 1 >= 0) System.arraycopy(arr, 1, arr, 0, qtdElementos - 1);
        arr[qtdElementos-1] = null;
        System.out.println("Valor retirado da fila: " + temp);
        System.out.println("Nova fila:");
        mostrarFila(arr);
    }
}