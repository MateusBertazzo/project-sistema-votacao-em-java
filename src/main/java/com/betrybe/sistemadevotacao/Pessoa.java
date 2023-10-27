package com.betrybe.sistemadevotacao;


/**
 * Esta classe representa uma pessoa no sistema de votação.
 */
public abstract class Pessoa {
  protected String nome;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
