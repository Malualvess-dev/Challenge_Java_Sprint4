package org.acme.Model.DTO;

public class PacienteDTO {
    private String nm_paciente;
    private String cpf_paciente;
    private String email_paciente;
    private String telefone_paciente;
    private String dt_nascimento;
    private String senha;

    //Construtores

    public PacienteDTO() {
    }

    public PacienteDTO(String nm_paciente, String cpf_paciente, String email_paciente, String telefone_paciente, String dt_nascimento, String senha) {
        this.nm_paciente = nm_paciente;
        this.cpf_paciente = cpf_paciente;
        this.email_paciente = email_paciente;
        this.telefone_paciente = telefone_paciente;
        this.dt_nascimento = dt_nascimento;
        this.senha = senha;
    }


//Get e Set


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
