package org.acme.Model;

public class Paciente {
    private int id_paciente;
    private String nm_paciente;
    private String cpf_paciente;
    private String email_paciente;
    private String telefone_paciente;
    private String dt_nascimento;

    //Construtores


    public Paciente() {
    }

    public Paciente(int id_paciente, String nm_paciente, String cpf_paciente, String email_paciente, String telefone_paciente, String dt_nascimento) {
        this.id_paciente = id_paciente;
        this.nm_paciente = nm_paciente;
        this.cpf_paciente = cpf_paciente;
        this.email_paciente = email_paciente;
        this.telefone_paciente = telefone_paciente;
        this.dt_nascimento = dt_nascimento;
    }

    //Get e Set


    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNm_paciente() {
        return nm_paciente;
    }

    public void setNm_paciente(String nm_paciente) {
        this.nm_paciente = nm_paciente;
    }

    public String getCpf_paciente() {
        return cpf_paciente;
    }

    public void setCpf_paciente(String cpf_paciente) {
        this.cpf_paciente = cpf_paciente;
    }

    public String getEmail_paciente() {
        return email_paciente;
    }

    public void setEmail_paciente(String email_paciente) {
        this.email_paciente = email_paciente;
    }

    public String getTelefone_paciente() {
        return telefone_paciente;
    }

    public void setTelefone_paciente(String telefone_paciente) {
        this.telefone_paciente = telefone_paciente;
    }

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }
}
