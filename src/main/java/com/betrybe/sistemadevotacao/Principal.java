package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe principal do sistema de votação.
 */
public class Principal {

  /**
   * Método principal do sistema de votação.

   * @param args Argumentos passados para o sistema.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    // TODO Auto-generated method stub

    while (true) {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      
      int opcao = scanner.nextInt();
      scanner.nextLine();

      if (opcao == 2) {
        break;
      } else if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nome = scanner.nextLine();

        System.out.println("Entre com o número da pessoa candidata:");
        int numero = scanner.nextInt();
        scanner.nextLine();

        gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);
      }
    }

    while (true) {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");

      int opcao = scanner.nextInt();

      if (opcao == 2) {
        break;
      } else if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nome = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Entre com o CPF da pessoa eleitora:");
        String cpf = scanner.nextLine();

        gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
      }
    }
    scanner.close();
  }
}
