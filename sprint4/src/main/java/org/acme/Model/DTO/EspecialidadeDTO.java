package org.acme.Model.DTO;

public class EspecialidadeDTO {

    private String nm_especialidade;


    //Construtores

    public EspecialidadeDTO() {
    }

    public EspecialidadeDTO(String nm_especialidade) {
        this.nm_especialidade = nm_especialidade;
    }

    //GET e SET


    public String getNm_especialidade() {
        return nm_especialidade;
    }

    public void setNm_especialidade(String nm_especialidade) {
        this.nm_especialidade = nm_especialidade;
    }
}
