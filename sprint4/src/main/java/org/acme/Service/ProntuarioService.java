package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.PacienteDTO;
import org.acme.Model.DTO.ProntuarioDTO;
import org.acme.Model.Paciente;
import org.acme.Model.Prontuario;
import org.acme.Repository.ProntuarioRepository;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class ProntuarioService {
    @Inject
    ProntuarioRepository prontuarioRepository;


    //Inserir
    public void inserir(ProntuarioDTO p) throws SQLException {
        prontuarioRepository.inserir(p);
    }


    //Listar
    public List<Prontuario> listar()throws SQLException{
        return prontuarioRepository.listar();
    }

    //Delete

    public void remove(int id_prontuario) throws SQLException, IllegalArgumentException,RuntimeException{
        if (id_prontuario < 0){
            throw new IllegalArgumentException("ID menor do que 0");
        }
        prontuarioRepository.remover(id_prontuario);
    }
}
