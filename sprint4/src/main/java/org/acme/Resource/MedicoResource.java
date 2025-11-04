package org.acme.Resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Model.DTO.MedicoDTO;
import org.acme.Model.DTO.PacienteDTO;
import org.acme.Model.Medico;
import org.acme.Model.Paciente;
import org.acme.Service.MedicoService;

import java.sql.SQLException;
import java.util.List;

@Path("/medicos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class MedicoResource {
    @Inject
    MedicoService medicoService;

    //Criação de dados
    @POST
    public Response criar(MedicoDTO medicoDTO){
        try{
            medicoService.inserir(medicoDTO);
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
            List<Medico> listaMedico = medicoService.listar();
            return  Response.status(Response.Status.OK).entity(listaMedico).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro de conexão com a Base de Dados").build();
        }
    }


    //DELETE

    //ELE não deleta caso esteja associado com outra tabela
    @DELETE
    @Path("/{id_medico}")
    public Response deletar(@PathParam("id_medico") int id_medico){
        try {
            medicoService.remove(id_medico);
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
