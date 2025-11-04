package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.EspecialidadeDTO;
import org.acme.Model.DTO.PacienteDTO;
import org.acme.Model.Especialidade;
import org.acme.Model.Paciente;
import org.acme.Repository.EspecialidadeRepository;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class EspecialidadeService {
    @Inject
    EspecialidadeRepository especialidadeRepository;

    //Inserir
    public void inserir(EspecialidadeDTO esp) throws SQLException {
        especialidadeRepository.inserir(esp);
    }

    //Ler

    public List<Especialidade> listar()throws SQLException{
        return especialidadeRepository.listar();
    }

    //Delete

    public void remove(int id_especialidade) throws SQLException, IllegalArgumentException,RuntimeException{
        if (id_especialidade < 0){
            throw new IllegalArgumentException("ID menor do que 0");
        }
        especialidadeRepository.remover(id_especialidade);
    }
}
