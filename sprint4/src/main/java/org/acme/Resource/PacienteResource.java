package org.acme.Resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import oracle.jdbc.proxy.annotation.Post;
import org.acme.Model.DTO.AgendamentoDTO;
import org.acme.Model.DTO.PacienteDTO;
import org.acme.Model.Paciente;
import org.acme.Service.PacienteService;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Path("/pacientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class PacienteResource {
    @Inject
    PacienteService pacienteService;

    //Criação de dados
    @POST
    public Response criar(PacienteDTO pacienteDTO){
        try{
            pacienteService.inserir(pacienteDTO);
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
            List<Paciente> listaPaciente = pacienteService.listar();
            return  Response.status(Response.Status.OK).entity(listaPaciente).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro de conexão com a Base de Dados").build();
        }
    }

    //DELETE

    //ELE não deleta caso esteja associado com outra tabela
    @DELETE
    @Path("/{id_paciente}")
    public Response deletar(@PathParam("id_paciente") int id_paciente){
        try {
            pacienteService.remove(id_paciente);
            return Response.status(Response.Status.OK).entity("Dado removido").build();
        } catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(422).entity(e.getMessage()).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    //UPDATE

    @PUT
    @Path("/{id_paciente}")
    public Response atualizador(@PathParam("id_paciente")int id_paciente, PacienteDTO pacienteDTO){
        try{
            pacienteService.atualizar(id_paciente, pacienteDTO);
            return Response.status(Response.Status.OK).entity("Paciente com id " + id_paciente + " atualizado").build();
        }catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } catch (IllegalArgumentException e){
            return  Response.status(422).entity(e.getMessage()).build();
        }
    }



}
