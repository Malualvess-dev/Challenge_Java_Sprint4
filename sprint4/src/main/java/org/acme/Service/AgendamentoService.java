package org.acme.Service;

import jakarta.inject.Inject;
import org.acme.Model.DTO.AgendamentoDTO;
import org.acme.Repository.AgendamentoRepository;

import java.sql.SQLException;

public class AgendamentoService {
    @Inject
    AgendamentoRepository agendamentoRepository;


    //Inserir
    public void inserir(AgendamentoDTO a) throws SQLException{
        agendamentoRepository.inserir(a);
    }
}
