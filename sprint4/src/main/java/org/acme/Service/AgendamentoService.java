package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.Agendamento;
import org.acme.Model.DTO.AgendamentoDTO;
import org.acme.Model.DTO.EspecialidadeDTO;
import org.acme.Model.Paciente;
import org.acme.Repository.AgendamentoRepository;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class AgendamentoService {
    @Inject
    AgendamentoRepository agendamentoRepository;


    //Inserir
    public void inserir(AgendamentoDTO a) throws SQLException{
        agendamentoRepository.inserir(a);
    }

    //Listar

    public List<Agendamento> listar()throws SQLException{
        return agendamentoRepository.listar();
    }

    //Delete

    public void remove(int id_agendamento) throws SQLException, IllegalArgumentException,RuntimeException{
        if (id_agendamento < 0){
            throw new IllegalArgumentException("ID menor do que 0");
        }
        agendamentoRepository.remover(id_agendamento);
    }

    //Atualizar

    public void atualizar(int id_agendamento, AgendamentoDTO agendamentoDTO) throws SQLException, IllegalArgumentException{
        validacao(agendamentoDTO);
        if (id_agendamento < 0){
            throw new IllegalArgumentException("ID menor que 1");
        }
        agendamentoRepository.atualizar(id_agendamento, agendamentoDTO);
    }



    public void validacao(AgendamentoDTO agendamentoDTO){
        if (agendamentoDTO==null|| agendamentoDTO.getDt_agendamento().isEmpty() ){
            throw new IllegalArgumentException("Data do agendamento incorreta");
        }
        if(agendamentoDTO == null || agendamentoDTO.getHr_agendamento().isEmpty()){
            throw new IllegalArgumentException("Horário incorreto");
        }


    }
}
