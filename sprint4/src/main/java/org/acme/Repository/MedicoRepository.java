package org.acme.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.EspecialidadeDTO;
import org.acme.Model.DTO.MedicoDTO;
import org.acme.Model.DTO.PacienteDTO;
import org.acme.Model.Medico;
import org.acme.Model.Paciente;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MedicoRepository {
    @Inject
    DataSource dataSource;

    //create

    public void inserir(MedicoDTO m) throws SQLException {
        String sql = "Insert into medico(crm,nm_medico,email_medico,tf_medico,id_especialidade) values (?,?,?,?,?)";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,m.getCRM());
            ps.setString(2,m.getNm_medico());
            ps.setString(3,m.getEmail_medico());
            ps.setString(4,m.getTf_medico());
            ps.setInt(5,m.getId_especialidade());

            ps.executeUpdate();
        }
    }

    //LER

    public List<Medico> listar() throws  SQLException{
        String sql = "Select * from medico Order by id_medico";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ResultSet rs = ps.executeQuery(); // Lista

            List<Medico> listaMedico = new ArrayList<>();
            while (rs.next()){

                Medico m = new Medico(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
                listaMedico.add(m);

            }

            return listaMedico;
        }

    }

    //DELETE

    public void remover(int id_medico) throws SQLException{
        String sql = "Delete from medico where id_medico = ?";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1,id_medico);

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas == 0){
                throw  new IllegalArgumentException("Não deletou");
            }
        }
    }

    //Atualizar

    public void atualizar(int id_medico, MedicoDTO medicoDTO) throws SQLException{
        String sql = "Update medico set nm_medico = ?, email_medico = ?, tf_medico = ? where id_medico = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1,medicoDTO.getNm_medico());
            ps.setString(2,medicoDTO.getEmail_medico());
            ps.setString(3,medicoDTO.getTf_medico());
            ps.setInt(4,id_medico);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas == 0){
                throw new SQLException("SQL não removeu dados");
            }
        }
    }
}
