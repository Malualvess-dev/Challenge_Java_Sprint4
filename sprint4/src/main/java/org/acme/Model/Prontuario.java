package org.acme.Model;

public class Prontuario {
    private int id_prontuario;
    private String descricao;
    private String dt_registro;
    private int id_paciente;

    //Construtores


    public Prontuario() {
    }

    public Prontuario(int id_prontuario, String descricao, String dt_registro, int id_paciente) {
        this.id_prontuario = id_prontuario;
        this.descricao = descricao;
        this.dt_registro = dt_registro;
        this.id_paciente = id_paciente;
    }

    //GET E SET


    public int getId_prontuario() {
        return id_prontuario;
    }

    public void setId_prontuario(int id_prontuario) {
        this.id_prontuario = id_prontuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDt_registro() {
        return dt_registro;
    }

    public void setDt_registro(String dt_registro) {
        this.dt_registro = dt_registro;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }
}
