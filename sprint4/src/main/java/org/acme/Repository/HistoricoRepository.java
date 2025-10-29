package org.acme.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.HistoricoDTO;
import org.acme.Model.DTO.PacienteDTO;
import org.acme.Model.Historico;
import org.acme.Model.Paciente;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class HistoricoRepository {
    @Inject
    DataSource dataSource;

    //Inserir

    public void inserir(HistoricoDTO his) throws SQLException {
        String sql = "Insert into historico(tp_atendimento, dt_atendimento, id_paciente) values (?,?,?)";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1,his.getTp_atendimento());
            ps.setString(2, his.getTp_atendimento());
            ps.setInt(3,his.getId_paciente());

            ps.executeUpdate();
        }
    }

    //LER

    public List<Historico> listar() throws  SQLException{
        String sql = "Select * from historico Order by id_historico";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ResultSet rs = ps.executeQuery(); // Lista

            List<Historico> listaHistorico = new ArrayList<>();
            while (rs.next()){

                Historico his = new Historico(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));

                listaHistorico.add(his);

            }

            return listaHistorico;
        }
    }
}
