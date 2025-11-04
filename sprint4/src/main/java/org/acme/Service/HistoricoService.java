package org.acme.Service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.HistoricoDTO;
import org.acme.Model.DTO.PacienteDTO;
import org.acme.Model.Historico;
import org.acme.Model.Paciente;
import org.acme.Repository.HistoricoRepository;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class HistoricoService {
    @Inject
    HistoricoRepository historicoRepository;

    //Inserir

    public void inserir(HistoricoDTO his) throws SQLException {
        historicoRepository.inserir(his);
    }

    //LER

    public List<Historico> listar()throws SQLException{
        return historicoRepository.listar();
    }

    //Delete

    public void remove(int id_historico) throws SQLException, IllegalArgumentException,RuntimeException{
        if (id_historico < 0){
            throw new IllegalArgumentException("ID menor do que 0");
        }
        historicoRepository.remover(id_historico);
    }
}
