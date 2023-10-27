package com.betrybe.sistemadevotacao;
import java.util.ArrayList;

/**
 * Esta classe é responsável pelo gerenciamento das votações no sistema.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface{
  private static ArrayList<PessoaCandidata> pessoasCandidatas;
  private static ArrayList<PessoaEleitora> pessoasEleitoras;
  private static ArrayList<String> cpfsComputados;


  public GerenciamentoVotacao() {
    pessoasCandidatas = new ArrayList<PessoaCandidata>();
    pessoasEleitoras = new ArrayList<PessoaEleitora>();
    cpfsComputados = new ArrayList<String>();
  }

  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata pessoa : pessoasCandidatas) {
      if (pessoa.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
        return;
      }
      PessoaCandidata novaPessoaCandidata = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(novaPessoaCandidata);
    }
  }

  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora pessoa : pessoasEleitoras) {
      if (pessoa.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        return;
      }
      PessoaEleitora novaPessoaEleitora = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(novaPessoaEleitora);
    }
  }

  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

  }

  public void mostrarResultado() {
  }
}
