package br.com.thiago;

import br.com.thiago.estruturas.Fila;
import br.com.thiago.exceptions.FilaVaziaException;
import br.com.thiago.exceptions.IndiceInexistenteException;
import br.com.thiago.exceptions.PessoaNaoEcontradaException;
import br.com.thiago.exceptions.TipoDeRemocaoException;

import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continua = true;
        Fila fila = new Fila();

        while (continua) {
            switch(menu(input)) {
                case 1:
                    System.out.println("Qual o nome da pessoa?");
                    input.nextLine();
                    String nome = input.nextLine();
                    System.out.println("Qual a idade da pessoa?");
                    int idade = input.nextInt();
                    fila.adicionar(new Pessoa(nome, idade));
                    break;
                case 2:
                    fila.listarTodos();
                    break;
                case 3:
                    try{
                        System.out.println("Qual o índice da pessoa que deseja mostrar?");
                        fila.getPessoa(input.nextInt());
                    } catch (IndiceInexistenteException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    try{
                        System.out.println("Qual o nome da pessoa que deseja mostrar?");
                        input.nextLine();
                        fila.buscar(input.nextLine());
                    } catch (PessoaNaoEcontradaException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    try{
                        fila.remover();
                    } catch (FilaVaziaException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 6:
                    try{
                        Pessoa pessoa = new Pessoa();
                        fila.remover(pessoa);
                    } catch (TipoDeRemocaoException e){
                        System.err.println(e.getMessage());
                    }

                    break;
                case 7:
                    try{
                        int index = 0;
                        fila.remover(index);
                    } catch (TipoDeRemocaoException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 8:
                    continua = false;
                    break;
                default:
                    System.out.println("Informe uma opção valida");
                    break;
            }
        }
    }

    private static int menu(Scanner input) {
        int opcao;
        do {
            System.out.println(
                    "1 - Adicionar na fila\n" +
                    "2 - Mostrar a fila\n" +
                    "3 - Mostrar a pessoa da fila por índice\n" +
                    "4 - Mostrar a pessoa da fila por nome\n" +
                    "5 - Remover da fila\n" +
                    "6 - Remover pelo nome\n" +
                    "7 - Remover por índice\n" +
                    "8 - Sair\n" +
                    "Entre com a opção desejada");
            opcao = input.nextInt();
        } while(opcao<1 || opcao>8);
        return opcao;
    }
}
