package bolao.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bolao.controller.ClubeController;
import bolao.model.Clube;

@Path("/clubes")
public class ClubeResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Clube> getClubes(){
		ClubeController clubeController = new ClubeController();
		return clubeController.listar();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String adicionarClube(Clube clube){
		ClubeController clubeController = new ClubeController();
		String msg = clubeController.adicionar(clube);
		return msg;
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Clube getClube(@PathParam("id") int id){
		ClubeController clubeController = new ClubeController();
		return clubeController.carregar(id);
	}
	
}
