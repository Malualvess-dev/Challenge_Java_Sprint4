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

    //Delete

    public void remove(int id_paciente) throws SQLException, IllegalArgumentException,RuntimeException{
        if (id_paciente < 0){
            throw new IllegalArgumentException("ID menor do que 0");
        }
        pacienteRepository.remover(id_paciente);
    }














    //Validações

    public void validacao(PacienteDTO p)  {
        if(p == null || p.getNm_paciente().isEmpty() ){
            throw  new IllegalArgumentException("Nome incorreto");
        }

        if (p == null || p.getCpf_paciente().isEmpty()){
            throw  new IllegalArgumentException("CPF incorreto");
        }
        if (p == null || p.getEmail_paciente().isEmpty()){
            throw  new IllegalArgumentException("Email incorreto");
        }
        if (p== null || p.getTelefone_paciente().isEmpty()){
            throw new IllegalArgumentException("Telefone incorreto");
        }
    }
    }





