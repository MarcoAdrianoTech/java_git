/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import view.Alunos;

/**
 *
 * @author mmgti
 */
public class PlanoModel {

    private int id;
    private String descricao;
    private Double valor;

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
  public AlunosModel getAlunos() {
        return alunos;
    }

    public void setAlunos(AlunosModel alunos) {
        this.alunos = alunos;
    }

    private AlunosModel alunos;// chave estrangeria representada pelo objeto alunos
    // para maninupular todos os dados do fornecedor 
    

}
