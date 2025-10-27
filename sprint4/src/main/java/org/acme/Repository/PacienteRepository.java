package org.acme.Repository;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.PacienteDTO;
import org.acme.Model.Paciente;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped //Gerencia o ciclo de vida da API
public class PacienteRepository {
    @Inject
    DataSource dataSource; //Gerencia conexão com base de dados

    //Classe Inserção de dados
    public void inserir(PacienteDTO p) throws SQLException {
        String sql = "Insert into paciente(nm_paciente,cpf_paciente,email_paciente, telefone_paciente, dt_nascimento) values (?,?,?,?,?)";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1,p.getNm_paciente());
            ps.setString(2, p.getCpf_paciente());
            ps.setString(3,p.getEmail_paciente());
            ps.setString(4,p.getTelefone_paciente());
            ps.setString(5,p.getDt_nascimento());

            ps.executeUpdate();
        }
    }

    //LER informações

    public List<Paciente> listar() throws  SQLException{
        String sql = "Select * from paciente Order by id_paciente";
        try(Connection con = dataSource.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){

            ResultSet rs = ps.executeQuery(); // Lista

            List<Paciente> listaPaciente = new ArrayList<>();
            while (rs.next()){

                Paciente p = new Paciente(rs.getInt(1),
                                          rs.getString(2),
                                          rs.getString(3),
                                          rs.getString(4),
                                          rs.getString(5),
                                          rs.getString(6));
                listaPaciente.add(p);

            }

            return listaPaciente;
    }
    }


}
