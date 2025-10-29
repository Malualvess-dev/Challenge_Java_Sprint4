package org.acme.Model;

public class Historico {
    private int id_historico;
    private String tp_atendimento;
    private String dt_atendimento;
    private int id_paciente;

    //Construtores


    public Historico() {
    }

    public Historico(int id_historico, String tp_atendimento, String dt_atendimento, int id_paciente) {
        this.id_historico = id_historico;
        this.tp_atendimento = tp_atendimento;
        this.dt_atendimento = dt_atendimento;
        this.id_paciente = id_paciente;
    }

    //GET E SET


    public int getId_historico() {
        return id_historico;
    }

    public void setId_historico(int id_historico) {
        this.id_historico = id_historico;
    }

    public String getTp_atendimento() {
        return tp_atendimento;
    }

    public void setTp_atendimento(String tp_atendimento) {
        this.tp_atendimento = tp_atendimento;
    }

    public String getDt_atendimento() {
        return dt_atendimento;
    }

    public void setDt_atendimento(String dt_atendimento) {
        this.dt_atendimento = dt_atendimento;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }
}
