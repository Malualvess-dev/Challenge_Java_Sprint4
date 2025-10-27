package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.PacienteDTO;
import org.acme.Model.Paciente;
import org.acme.Repository.PacienteRepository;

import java.sql.SQLException;
import java.util.List;


@ApplicationScoped
public class PacienteService {
    @Inject //Inserir
    PacienteRepository pacienteRepository;

    //Inserir
    public void inserir(PacienteDTO p) throws SQLException {
        pacienteRepository.inserir(p);
    }


    //Listar
    public List<Paciente> listar()throws SQLException{
        return pacienteRepository.listar();
    }




    public void validacao(PacienteDTO p)  {
        if(p == null || p.getNm_paciente().isEmpty() ){
            throw  new IllegalArgumentException("Nome incorreto");
        }

        if (p == null || p.getCpf_paciente().isEmpty()){
            throw  new IllegalArgumentException("CPF incorreto");
        }
    }
}
