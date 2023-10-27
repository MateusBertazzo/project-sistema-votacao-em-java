package com.betrybe.sistemadevotacao;


/**
 * Esta classe representa uma pessoa candidata no sistema de votação.
 */
public class PessoaCandidata extends Pessoa {
  public int numero;
  public int votos;

  /**
 * Construtor da classe PessoaCandidata.
 *
 * @param nome   O nome da pessoa candidata.
 * @param numero O número da pessoa candidata.
 */
  public PessoaCandidata(String nome, int numero) {
    super(nome);
    this.numero = numero;
    this.votos = 0;
  }

  // public String getNome() {
  //   return nome;
  // }

  // public void setNome(String nome) {
  //   this.nome = nome;
  // }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getvotos() {
    return votos;
  }

  public void setvotos(int votos) {
    this.votos = votos;
  }

  public void receberVoto() {
    this.votos += 1;
  }
}
