package com.example.khristian.futizinbeta;

/**
 * Created by Khristian on 11/05/2017.
 */

public class Partida {
    private long ID;
    private String local;
    private String data;
    private String horario;
    private String faixaEtaria;
    private int valor;
    private int quantidadeJogadores;

    public Partida(){}//INICIANDO O CONSTRUTOR QUE TEM A FUNCAO DE INICIAR O OBJETO.

    //ESTA FUNCAO FAZ A REFERENCIA AO PROPRIO OBJETO.
    public Partida(Long ID, String local, String data, String horario, String faixaEtaria, int quantidadeJogadores, int valor){
        this.ID = ID;
        this.local = local;
        this.data = data;
        this.horario = horario;
        this.faixaEtaria = faixaEtaria;
        this.quantidadeJogadores = quantidadeJogadores;
        this.valor = valor;
    }
    //ESTA FUNCAO FAZ A REFERENCIA AO PROPRIO OBJETO.

    // OS DADOS GET E SET POSSIBILITAM A MANIPULACAO DOS DADOS INSERIDOS NAS VARIAVEIS.
    public long getID() {
        return ID;
    }
    public void setID(long ID) {
        this.ID = ID;
    }

    public String getLocal() {return local;}
    public void setLocal(String local) {this.local = local;}

    public String getData() {return data;}
    public void setData(String data) {this.data = data;}

    public String getHorario() {return horario;}
    public void setHorario(String horario) {this.horario = horario;}

    public String getFaixaEtaria() {return faixaEtaria;}
    public void setFaixaEtaria(String faixaEtaria ) {this.faixaEtaria = faixaEtaria;}

    public int getValor() {return valor;}
    public void setValor(int valor) {this.valor = valor;}

    public int getQuantidadeJogadores() {return quantidadeJogadores;}
    public void setQuantidadeJogadores(int quantidadeJogadores) {this.quantidadeJogadores = quantidadeJogadores;}
// OS DADOS GET E SET POSSIBILITAM A MANIPULACAO DOS DADOS INSERIDOS NAS VARIAVEIS.
}
