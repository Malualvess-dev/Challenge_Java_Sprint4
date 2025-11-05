package org.acme.Repository;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.AgendamentoDTO;
import org.acme.Model.DTO.PacienteDTO;
import org.acme.Model.Paciente;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped //Gerencia o ciclo de vida da API
public class PacienteRepository {
    @Inject
    DataSource dataSource; //Gerencia conexão com base de dados

    //Classe Inserção de dados---- Funcionando
    public void inserir(PacienteDTO p) throws SQLException {
        String sql = "Insert into paciente(nm_paciente,cpf_paciente,email_paciente, telefone_paciente, dt_nascimento,senha) values (?,?,?,?,?,?)";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1,p.getNm_paciente());
            ps.setString(2, p.getCpf_paciente());
            ps.setString(3,p.getEmail_paciente());
            ps.setString(4,p.getTelefone_paciente());
            ps.setString(5,p.getDt_nascimento());
            ps.setString(6,p.getSenha());

            ps.executeUpdate();
        }
    }

    //LER informações //Funcionando

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
                                          rs.getString(6),
                                          rs.getString(7)
                );
                listaPaciente.add(p);

            }

            return listaPaciente;
    }
    }

    //Delete

    public void remover(int id_paciente) throws SQLException{
        String sql = "Delete from Paciente where id_paciente = ?";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1,id_paciente);

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas == 0){
                throw  new IllegalArgumentException("Não deletou");
            }
        }
    }

    public void atualizar(int id_paciente, PacienteDTO pacienteDTO) throws SQLException{
        String sql = "Update paciente set nm_paciente = ?, email_paciente = ?, telefone_paciente = ?, senha = ? where id_paciente = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1,pacienteDTO.getNm_paciente());
            ps.setString(2, pacienteDTO.getEmail_paciente());
            ps.setString(3,pacienteDTO.getTelefone_paciente());
            ps.setString(4,pacienteDTO.getSenha());
            ps.setInt(5,id_paciente);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas == 0){
                throw new SQLException("SQL não removeu dados");
            }
        }
    }







    //Verifica ID

    public boolean verificaID(int id_paciente)throws SQLException{
        String sql ="Select count(*) from paciente where id = ?";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,id_paciente);
            ResultSet rs = ps.executeQuery();
            //tem proximo elemento? e se tem é maior que 0
            return (rs.next() && rs.getInt(1)>0);
        }

    }





}
