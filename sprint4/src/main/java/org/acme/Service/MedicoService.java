package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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
}
