package org.acme.Resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Model.DTO.PacienteDTO;
import org.acme.Model.DTO.ProntuarioDTO;
import org.acme.Model.Paciente;
import org.acme.Model.Prontuario;
import org.acme.Service.ProntuarioService;

import java.sql.SQLException;
import java.util.List;

@Path("/prontuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ProntuarioResource {
    @Inject
    ProntuarioService prontuarioService;

    //Criação de dados
    @POST
    public Response criar(ProntuarioDTO prontuarioDTO){
        try{
            prontuarioService.inserir(prontuarioDTO);
            return Response.status(Response.Status.CREATED).entity("Criado com sucesso").build();

        } catch (SQLException e) { //Erro de conexão com a base
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro com a base de dados").build();

        } catch (IllegalArgumentException e){ //Erro de dados na validação
            return Response.status(422).entity(e.getMessage()).build();
        }
    }

    //Listar

    @GET
    public Response listar(){
        try{
            List<Prontuario> listaProntuario = prontuarioService.listar();
            return  Response.status(Response.Status.OK).entity(listaProntuario).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro de conexão com a Base de Dados").build();
        }
    }

    //DELETE

    //ELE não deleta caso esteja associado com outra tabela
    @DELETE
    @Path("/{id_prontuario}")
    public Response deletar(@PathParam("id_prontuario") int id_prontuario){
        try {
            prontuarioService.remove(id_prontuario);
            return Response.status(Response.Status.OK).entity("Dado removido").build();
        } catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(422).entity(e.getMessage()).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }
}
