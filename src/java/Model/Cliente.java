/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author SnakeGnr <adaognr.lima@gmail.com>
 */
public class Cliente {
    private int id_cliente;
    private String nome, email, cpf, dataNasc, fone, cep, senha;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nome, String email, String cpf, String dataNasc, String fone, String cep) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.fone = fone;
        this.cep = cep;
    }

      public Cliente( String nome, String email, String cpf, String dataNasc, String fone, String cep) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.fone = fone;
        this.cep = cep;
    }
    
    
    public int getId_cliente() {
        return id_cliente;
    }

   
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

   
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

  
    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
