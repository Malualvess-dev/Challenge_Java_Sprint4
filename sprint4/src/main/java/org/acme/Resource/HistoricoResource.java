package org.acme.Resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Model.DTO.HistoricoDTO;
import org.acme.Model.DTO.PacienteDTO;
import org.acme.Model.Historico;
import org.acme.Model.Paciente;
import org.acme.Service.HistoricoService;

import java.sql.SQLException;
import java.util.List;

@Path("/historicos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class HistoricoResource {
    @Inject
    HistoricoService historicoService;

    //Criação de dados

    @POST
    public Response criar(HistoricoDTO historicoDTO){
        try{
            historicoService.inserir(historicoDTO);
            return Response.status(Response.Status.CREATED).entity("Criado com sucesso").build();

        } catch (SQLException e) { //Erro de conexão com a base
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro com a base de dados").build();

        } catch (IllegalArgumentException e){ //Erro de dados na validação
            return Response.status(422).entity(e.getMessage()).build();
        }
    }

    //ler

    @GET
    public Response listar(){
        try{
            List<Historico> listaHistorico = historicoService.listar();
            return  Response.status(Response.Status.OK).entity(listaHistorico).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro de conexão com a Base de Dados").build();
        }
    }
}
