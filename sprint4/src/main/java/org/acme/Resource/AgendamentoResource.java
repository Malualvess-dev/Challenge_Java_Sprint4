package org.acme.Resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Model.DTO.AgendamentoDTO;
import org.acme.Service.AgendamentoService;

import java.sql.SQLException;

@Path("/agendamentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class AgendamentoResource {
    @Inject
    AgendamentoService agendamentoService;


    //Criação de dados

    @POST
    public Response criar(AgendamentoDTO agendamentoDTO){
        try {
            agendamentoService.inserir(agendamentoDTO);
            return Response.status(Response.Status.CREATED).entity("Crido com sucesso").build();

        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro com a base de dados").build();

        } catch (IllegalArgumentException e){
            return Response.status(422).entity(e.getMessage()).build();
        }
    }

    //Listar


}
