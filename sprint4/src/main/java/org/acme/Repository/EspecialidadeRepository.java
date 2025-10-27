package org.acme.Repository;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.EspecialidadeDTO;
import org.acme.Model.Especialidade;
import org.acme.Model.Paciente;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class EspecialidadeRepository {
    @Inject
    DataSource dataSource;

    //Inserção de dados

    public void inserir(EspecialidadeDTO esp) throws SQLException{
        String sql = "Insert into especialidade (nm_especialidade) values (?)";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, esp.getNm_especialidade());

            ps.executeUpdate();
        }
    }

    //Ler Dados

    public List<Especialidade> listar() throws  SQLException{
        String sql = "Select * from especialidade Order by id_especialidade";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ResultSet rs = ps.executeQuery(); // Lista

            List<Especialidade> listaEspecialidade = new ArrayList<>();
            while (rs.next()){

                Especialidade esp = new Especialidade(rs.getInt(1),
                                                    rs.getString(2));
                listaEspecialidade.add(esp);

            }

            return listaEspecialidade;
        }
    }
}
