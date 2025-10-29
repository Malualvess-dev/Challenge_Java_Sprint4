package org.acme.Model.DTO;

public class HistoricoDTO {
    private String tp_atendimento;
    private String dt_historico;
    private int id_paciente;

    //Construtores


    public HistoricoDTO() {
    }

    public HistoricoDTO(String tp_atendimento, String dt_historico, int id_paciente) {
        this.tp_atendimento = tp_atendimento;
        this.dt_historico = dt_historico;
        this.id_paciente = id_paciente;
    }

    //GET E SET


    public String getTp_atendimento() {
        return tp_atendimento;
    }

    public void setTp_atendimento(String tp_atendimento) {
        this.tp_atendimento = tp_atendimento;
    }

    public String getDt_atendimento() {
        return dt_historico;
    }

    public void setDt_atendimento(String dt_atendimento) {
        this.dt_historico = dt_atendimento;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }
}
