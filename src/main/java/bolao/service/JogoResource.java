package bolao.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bolao.controller.JogoController;
import bolao.model.Jogo;

@Path("/jogos")
public class JogoResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Jogo> getJogos(){
		JogoController jogoController = new JogoController();
		return jogoController.listar();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String adicionarJogo(Jogo jogo){
		JogoController jogoController = new JogoController();
		return jogoController.adicionar(jogo);
	}
}