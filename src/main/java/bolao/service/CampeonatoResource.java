package bolao.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bolao.controller.CampeonatoController;
import bolao.model.Campeonato;

@Path("/campeonatos")
public class CampeonatoResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Campeonato> getCampeonatos(){
		CampeonatoController campeonatoController = new CampeonatoController();
		return campeonatoController.listar();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String adicionaCampeonato(Campeonato campeonato){
		CampeonatoController campeonatoController = new CampeonatoController();
		return campeonatoController.adicionar(campeonato);
	}
	
}
