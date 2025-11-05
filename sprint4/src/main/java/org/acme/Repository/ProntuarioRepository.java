package org.acme.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.PacienteDTO;
import org.acme.Model.DTO.ProntuarioDTO;
import org.acme.Model.Paciente;
import org.acme.Model.Prontuario;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProntuarioRepository {
    @Inject
    DataSource dataSource;

    //Criar

    public void inserir(ProntuarioDTO p) throws SQLException {
        String sql = "Insert into prontuario(descricao,dt_registro,id_paciente) values (?,?,?)";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1,p.getDescricao());
            ps.setString(2, p.getDt_registro());
            ps.setInt(3,p.getId_paciente());

            ps.executeUpdate();
        }
    }

    //LER informações //Funcionando

    public List<Prontuario> listar() throws  SQLException{
        String sql = "Select * from prontuario Order by id_prontuario";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ResultSet rs = ps.executeQuery(); // Lista

            List<Prontuario> listaProntuario = new ArrayList<>();
            while (rs.next()){

                Prontuario p = new Prontuario(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));

                listaProntuario.add(p);

            }

            return listaProntuario;
        }
    }

    //DELETE

    public void remover(int id_prontuario) throws SQLException{
        String sql = "Delete from Prontuario where id_prontuario = ?";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1,id_prontuario);

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas == 0){
                throw  new IllegalArgumentException("Não deletou");
            }
        }
    }

    public void atualizar(int id_prontuario, ProntuarioDTO prontuarioDTO) throws SQLException{
        String sql = "Update prontuario set descricao = ?, dt_registro = ? where id_prontuario = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1,prontuarioDTO.getDt_registro());
            ps.setString(2, prontuarioDTO.getDescricao());
            ps.setInt(3,id_prontuario);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas == 0){
                throw new SQLException("SQL não removeu dados");
            }
        }
    }
}
