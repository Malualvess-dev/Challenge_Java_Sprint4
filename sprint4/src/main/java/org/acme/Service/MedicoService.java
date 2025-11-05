package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.EspecialidadeDTO;
import org.acme.Model.DTO.MedicoDTO;
import org.acme.Model.DTO.PacienteDTO;
import org.acme.Model.Medico;
import org.acme.Model.Paciente;
import org.acme.Repository.MedicoRepository;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class MedicoService {
    @Inject
    MedicoRepository medicoRepository;

    //Inserir
    public void inserir(MedicoDTO m) throws SQLException {
        medicoRepository.inserir(m);
    }


    //Listar
    public List<Medico> listar()throws SQLException{
        return medicoRepository.listar();
    }

    //Delete

    public void remove(int id_medico) throws SQLException, IllegalArgumentException,RuntimeException{
        if (id_medico < 0){
            throw new IllegalArgumentException("ID menor do que 0");
        }
        medicoRepository.remover(id_medico);
    }

    //Atualizar

    //Atualizar

    public void atualizar(int id_medico, MedicoDTO medicoDTO) throws SQLException, IllegalArgumentException{
        validacao(medicoDTO);
        if (id_medico < 0){
            throw new IllegalArgumentException("ID menor que 1");
        }
        medicoRepository.atualizar(id_medico, medicoDTO);
    }



    public void validacao(MedicoDTO medicoDTO){
        if (medicoDTO==null|| medicoDTO.getNm_medico().isEmpty() ){
            throw new IllegalArgumentException("Nome de especialidade incorreta");
        }
        if (medicoDTO == null || medicoDTO.getEmail_medico().isEmpty()){
            throw new IllegalArgumentException("Email incorreto");
        }
        if (medicoDTO == null || medicoDTO.getTf_medico().isEmpty()){
            throw  new IllegalArgumentException("Telefone incorreeto");
        }

    }
}
