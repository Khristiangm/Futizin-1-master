package com.example.khristian.futizinbeta;

/**
 * Created by Khristian on 11/05/2017.
 */

public class Usuario {

    public long ID;
    public String nome;
    public String email;
    public String dataNascimento;
    public String contato;
    public String senha;

    public Usuario(){}

    public Usuario(Long ID, String nome, String email, String dataNascimento, String contato, String senha){
        this.ID = ID;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.contato = contato;
        this.senha = senha;
    }

    public long getID() {
        return ID;
    }
    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getDataNascimento() {return dataNascimento;}
    public void setDataNascimento(String dataNascimento) {this.dataNascimento = dataNascimento;}

    public String getContato() {return contato;}
    public void setContato(String contato ) {this.contato = contato;}

    public String  getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}

}
