package org.acme.Model.DTO;

public class MedicoDTO {
    private int CRM;
    private String nm_medico;
    private String email_medico;
    private String tf_medico;
    private int id_especialidade;

    //Construtores


    public MedicoDTO() {
    }

    public MedicoDTO(int CRM, String nm_medico, String email_medico, String tf_medico, int id_especialidade) {
        this.CRM = CRM;
        this.nm_medico = nm_medico;
        this.email_medico = email_medico;
        this.tf_medico = tf_medico;
        this.id_especialidade = id_especialidade;
    }

    //GET e SET


    public int getCRM() {
        return CRM;
    }

    public void setCRM(int CRM) {
        this.CRM = CRM;
    }

    public String getNm_medico() {
        return nm_medico;
    }

    public void setNm_medico(String nm_medico) {
        this.nm_medico = nm_medico;
    }

    public String getEmail_medico() {
        return email_medico;
    }

    public void setEmail_medico(String email_medico) {
        this.email_medico = email_medico;
    }

    public String getTf_medico() {
        return tf_medico;
    }

    public void setTf_medico(String tf_medico) {
        this.tf_medico = tf_medico;
    }

    public int getId_especialidade() {
        return id_especialidade;
    }

    public void setId_especialidade(int id_especialidade) {
        this.id_especialidade = id_especialidade;
    }
}
