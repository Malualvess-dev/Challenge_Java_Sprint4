package org.acme.Model;

public class Especialidade {
    private  int id_especialidade;
    private String nm_especialidade;

    //Construtores


    public Especialidade() {
    }

    public Especialidade(int id_especialidade, String nm_especialidade) {
        this.id_especialidade = id_especialidade;
        this.nm_especialidade = nm_especialidade;
    }

    //GET E SET


    public int getId_especialidade() {
        return id_especialidade;
    }

    public void setId_especialidade(int id_especialidade) {
        this.id_especialidade = id_especialidade;
    }

    public String getNm_especialidade() {
        return nm_especialidade;
    }

    public void setNm_especialidade(String nm_especialidade) {
        this.nm_especialidade = nm_especialidade;
    }
}
