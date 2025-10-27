package org.acme.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.Agendamento;
import org.acme.Model.DTO.AgendamentoDTO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@ApplicationScoped
public class AgendamentoRepository {
    @Inject
    DataSource dataSource;

    //Inserção de dados

    public void inserir(AgendamentoDTO a) throws SQLException{
        String sql = " Insert into agendamento (dt_agendamento, hr_agendamento,st_agendamento, id_paciente) values (?,?,?,?)";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1,a.getDt_agendamento());
            ps.setString(2,a.getHr_agendamento());
            ps.setString(3,String.valueOf(a.getSt_agendamento()));
            ps.setInt(4,a.getId_paciente());

            ps.executeUpdate();

        }
    }


    //LER dados
}


