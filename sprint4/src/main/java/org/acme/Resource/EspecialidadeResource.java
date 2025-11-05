package org.acme.Resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Model.DTO.EspecialidadeDTO;
import org.acme.Model.DTO.PacienteDTO;
import org.acme.Model.Especialidade;
import org.acme.Model.Paciente;
import org.acme.Service.EspecialidadeService;

import java.sql.SQLException;
import java.util.List;

@Path("/especialidades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class EspecialidadeResource {
    @Inject
    EspecialidadeService especialidadeService;

    //Inserção

    @POST  //É not null e unique, então não vai criar se ja existir
    public Response criar(EspecialidadeDTO especialidadeDTO){
        try{
            especialidadeService.inserir(especialidadeDTO);
            return Response.status(Response.Status.CREATED).entity("Criado com sucesso").build();

        } catch (SQLException e) { //Erro de conexão com a base
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro com a base de dados").build();

        } catch (IllegalArgumentException e){ //Erro de dados na validação
            return Response.status(422).entity(e.getMessage()).build();
        }
    }

    //LER


    @GET
    public Response listar(){
        try{
            List<Especialidade> listaEspecialidade = especialidadeService.listar();
            return  Response.status(Response.Status.OK).entity(listaEspecialidade).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro de conexão com a Base de Dados").build();
        }
    }

    //DELETE

    //ELE não deleta caso esteja associado com outra tabela
    @DELETE
    @Path("/{id_especialidade}")
    public Response deletar(@PathParam("id_especialidade") int id_especialidade){
        try {
            especialidadeService.remove(id_especialidade);
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
    @Path("/{id_especialidade}")
    public Response atualizador(@PathParam("id_especialidade")int id_especialidade, EspecialidadeDTO especialidadeDTO){
        try{
            especialidadeService.atualizar(id_especialidade,especialidadeDTO);
            return Response.status(Response.Status.OK).entity("Especialidade com id " + id_especialidade + " atualizada").build();
        }catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } catch (IllegalArgumentException e){
            return  Response.status(422).entity(e.getMessage()).build();
        }
    }
}
