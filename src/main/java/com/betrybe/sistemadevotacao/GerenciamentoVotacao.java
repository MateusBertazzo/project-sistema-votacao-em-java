package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * Esta classe é responsável pelo gerenciamento das votações no sistema.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  private static ArrayList<PessoaCandidata> pessoasCandidatas;
  private static ArrayList<PessoaEleitora> pessoasEleitoras;
  private static ArrayList<String> cpfsComputados;

  /**
   * Construtor da classe GerenciamentoVotacao.
   */
  public GerenciamentoVotacao() {
    pessoasCandidatas = new ArrayList<PessoaCandidata>();
    pessoasEleitoras = new ArrayList<PessoaEleitora>();
    cpfsComputados = new ArrayList<String>();
  }

  public ArrayList<PessoaCandidata> getPessoasCandidatas() {
    return pessoasCandidatas;
  }

  public ArrayList<PessoaEleitora> getPessoasEleitoras() {
    return pessoasEleitoras;
  }

  public ArrayList<String> getCpfsComputados() {
    return cpfsComputados;
  }

  /**
   * Método para cadastrar uma pessoa candidata no sistema.
   *
   * @param nome   O nome da pessoa candidata.
   * @param numero O número da pessoa candidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    if (pessoasCandidatas.isEmpty()) {
      PessoaCandidata novaPessoaCandidata = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(novaPessoaCandidata);
    } else {
      for (PessoaCandidata pessoa : pessoasCandidatas) {
        if (pessoa.getNumero() == numero) {
          System.out.println("Número da pessoa candidata já utilizado!");
          return;
        }
        PessoaCandidata novaPessoaCandidata = new PessoaCandidata(nome, numero);
        pessoasCandidatas.add(novaPessoaCandidata);
      }
    }
    
  }

  /**
   * Método para cadastrar uma pessoa eleitora no sistema.
   *
   * @param nome O nome da pessoa eleitora.
   * @param cpf  O CPF da pessoa eleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    if (pessoasEleitoras.isEmpty()) {
      PessoaEleitora novaPessoaEleitora = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(novaPessoaEleitora);
    } else {
      for (PessoaEleitora pessoa : pessoasEleitoras) {
        if (pessoa.getCpf().equals(cpf)) {
          System.out.println("Pessoa eleitora já cadastrada!");
          return;
        }
        PessoaEleitora novaPessoaEleitora = new PessoaEleitora(nome, cpf);
        pessoasEleitoras.add(novaPessoaEleitora);
      }
    }
  }

  /**
   * Método para realizar uma votação.
   *
   * @param cpfPessoaEleitora     O CPF da pessoa eleitora.
   * @param numeroPessoaCandidata O número da pessoa candidata.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfsComputados.isEmpty()) {
      return;
    }
    if (cpfsComputados.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    }
    for (PessoaEleitora pessoa : pessoasEleitoras) {
      if (pessoa.getCpf().equals(cpfPessoaEleitora)) {
        cpfsComputados.add(cpfPessoaEleitora);

        for (PessoaCandidata candidato : pessoasCandidatas) {
          if (candidato.getNumero() == numeroPessoaCandidata) {
            candidato.receberVoto();
            return;
          }
        }
      }
    }
  }

  /**
   * Método para mostrar o resultado da votação.
   */
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado!");
      return;
    }

    int totalVotos = cpfsComputados.size();

    for (PessoaCandidata candidato : pessoasCandidatas) {
      int votosCandidatos = candidato.getVotos();
      int porcentagemVotos = Math.round(votosCandidatos * 100 / totalVotos);

      System.out.printf("Nome: %s - %d votos (%d%%)%n", 
          candidato.getNome(), votosCandidatos, porcentagemVotos);
    }
    System.out.printf("Total de votos: %d%n", totalVotos);
  }
}
