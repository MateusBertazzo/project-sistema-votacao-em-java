package com.betrybe.sistemadevotacao;

import java.util.ArrayList;



/**
 * Esta classe é responsável pelo gerenciamento das votações no sistema.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfsComputados;

  /**
   * Construtor da classe GerenciamentoVotacao.
   */
  public GerenciamentoVotacao() {
    this.pessoasCandidatas = new ArrayList<>();
    this.pessoasEleitoras = new ArrayList<>();
    this.cpfsComputados = new ArrayList<>();
  }

  @Override
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
      }
      PessoaCandidata novaPessoaCandidata = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(novaPessoaCandidata);
    }
    
  }

  @Override
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
      }
      PessoaEleitora novaPessoaEleitora = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(novaPessoaEleitora);
    }
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    boolean jaVotou = false;

    if (!cpfsComputados.isEmpty()) {
      for (String cpf : cpfsComputados) {
        if (cpf.equals(cpfPessoaEleitora)) {
          jaVotou = true;
          System.out.println("Pessoa eleitora já votou!");
          return;
        }
      }
    }
    if (!jaVotou) {
      cpfsComputados.add(cpfPessoaEleitora);
    }

    for (PessoaCandidata pessoa : pessoasCandidatas) {
      if (pessoa.getNumero() == numeroPessoaCandidata) {
        pessoa.receberVoto();
      }
    }
  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado");
      return;
    }

    int totalVotos = cpfsComputados.size();

    for (PessoaCandidata candidata : pessoasCandidatas) {
      System.out.printf("Nome: %s - %d votos ( %d%% )%n",
          candidata.getNome(), candidata.getVotos(),
          Math.round((float) candidata.getVotos() / totalVotos * 100));
    }
    System.out.printf("Total de votos: %d%n", totalVotos);
  }
}
