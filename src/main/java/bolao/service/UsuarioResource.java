package bolao.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bolao.controller.UsuarioController;
import bolao.model.Usuario;

@Path("/usuarios")
public class UsuarioResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsuarios(){
		UsuarioController usuarioController = new UsuarioController();
		return usuarioController.listar();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String adicionarUsuario(Usuario usuario){
		UsuarioController usuarioController = new UsuarioController();
		return usuarioController.adicionar(usuario);
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuario(@PathParam("id") int id){
		UsuarioController usuarioController = new UsuarioController();
		return usuarioController.carregar(id);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String excluirUsuario(Usuario usuario){
		UsuarioController usuarioController = new UsuarioController();
		return usuarioController.excluir(usuario);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String atualizaUsuario(Usuario usuario){
		UsuarioController usuarioController = new UsuarioController();
		return usuarioController.atualizar(usuario);
	}
}