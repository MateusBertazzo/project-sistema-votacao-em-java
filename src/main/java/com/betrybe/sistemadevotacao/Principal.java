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

    Boolean votacaoEmAndamento = true;
    while (votacaoEmAndamento) {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar votação");

      int opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          System.out.println("Entre com o CPF da pessoa eleitora:");
          String cpf = scanner.nextLine();
          scanner.nextLine();

          System.out.println("Entre com o número da pessoa candidata:");
          int numero = scanner.nextInt();
          gerenciamentoVotacao.votar(cpf, numero);
          break;
      
        case 2:
          gerenciamentoVotacao.mostrarResultado();
          break;

        case 3:
          gerenciamentoVotacao.mostrarResultado();
          votacaoEmAndamento = false;
          break;

        default:
          System.out.println("Opção inválida! Tente novamente.");
          break;
      }
    }
    scanner.close();
  }
}
