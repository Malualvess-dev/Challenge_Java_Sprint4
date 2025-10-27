package org.acme.Model;

public class Agendamento {
    private int id_agendamento;
    private String dt_agendamento;
    private String hr_agendamento;
    private char st_agendamento;
    private int id_paciente;

    //Construtores


    public Agendamento() {
    }

    public Agendamento(int id_agendamento, String dt_agendamento, String hr_agendamento, char st_agendamento, int id_paciente) {
        this.id_agendamento = id_agendamento;
        this.dt_agendamento = dt_agendamento;
        this.hr_agendamento = hr_agendamento;
        this.st_agendamento = st_agendamento;
        this.id_paciente = id_paciente;
    }

    //GET e SET


    public int getId_agendamento() {
        return id_agendamento;
    }

    public void setId_agendamento(int id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public String getDt_agendamento() {
        return dt_agendamento;
    }

    public void setDt_agendamento(String dt_agendamento) {
        this.dt_agendamento = dt_agendamento;
    }

    public String getHr_agendamento() {
        return hr_agendamento;
    }

    public void setHr_agendamento(String hr_agendamento) {
        this.hr_agendamento = hr_agendamento;
    }

    public char getSt_agendamento() {
        return st_agendamento;
    }

    public void setSt_agendamento(char st_agendamento) {
        this.st_agendamento = st_agendamento;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }
}
