package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.EspecialidadeDTO;
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

    //Atualizar

    public void atualizar(int id_paciente, PacienteDTO pacienteDTO) throws SQLException, IllegalArgumentException{
        validacao(pacienteDTO);
        if (id_paciente < 0){
            throw new IllegalArgumentException("ID menor que 1");
        }
        pacienteRepository.atualizar(id_paciente, pacienteDTO);
    }



    public void validacao(PacienteDTO pacienteDTO){
        if (pacienteDTO==null|| pacienteDTO.getNm_paciente().isEmpty() ){
            throw new IllegalArgumentException("Nome do paciente incorreto");
        }
        if (pacienteDTO == null || pacienteDTO.getEmail_paciente().isEmpty()){
            throw new IllegalArgumentException("Email incorreto");
        }
        if (pacienteDTO == null || pacienteDTO.getTelefone_paciente().isEmpty()){
            throw new IllegalArgumentException("Telefone incorreto");
        }
    }

    }

