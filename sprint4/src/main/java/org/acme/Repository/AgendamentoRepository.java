package org.acme.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.Agendamento;
import org.acme.Model.DTO.AgendamentoDTO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Agendamento> listar() throws SQLException{
        String sql = "Select * from agendamento Order by id_agendamento";

        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ResultSet rs = ps.executeQuery();

            List<Agendamento> listaAgendamento = new ArrayList<>();
            while (rs.next()){
                Agendamento a = new Agendamento(rs.getInt(1),
                                                rs.getString(2),
                                                rs.getString(3),
                                                rs.getString(4).charAt(0),
                                                rs.getInt(5)
                );

                listaAgendamento.add(a);

            }

            return listaAgendamento;
        }
    }

    //DELETE

    public void remover(int id_agendamento) throws SQLException{
        String sql = "Delete from Agendamento where id_agendamento = ?";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1,id_agendamento);

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas == 0){
                throw  new IllegalArgumentException("Não deletou");
            }
        }
    }

    //--------------------------------------------------------------------------
}


