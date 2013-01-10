package bolao.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bolao.controller.BolaoController;
import bolao.model.Bolao;

@Path("/boloes")
public class BolaoResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bolao> getBoloes(){
		BolaoController bolao = new BolaoController();
		return bolao.listar();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String adicionaBolao(Bolao bolao){
		BolaoController bolaoController = new BolaoController();
		bolaoController.adicionar(bolao);
		return "Bolao Adicionado";
	}
}