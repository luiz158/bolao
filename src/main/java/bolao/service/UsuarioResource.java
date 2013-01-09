package bolao.service;

import java.util.List;

import javax.ws.rs.Consumes;
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
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuario(@PathParam("id") int id){
		UsuarioController usuarioController = new UsuarioController();
		return usuarioController.carregar(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String adicionaUsuario(Usuario usuario){
		usuario.setUsuario(null);
		UsuarioController usuarioController = new UsuarioController();
		usuarioController.adcionar(usuario);
		return "Adicionado";
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String atualizaUsuario(Usuario usuario, @PathParam("id") int id){
		
		UsuarioController usuarioController = new UsuarioController();
		Usuario usuarioAtual = usuarioController.carregar(id);
		usuarioAtual.setAtivo(usuario.isAtivo());
		usuarioAtual.setEmail(usuario.getEmail());
		usuarioAtual.setLogin(usuario.getLogin());
		usuarioAtual.setNome(usuario.getNome());
		usuarioAtual.setPermissao(usuario.getPermissao());
		usuarioAtual.setSenha(usuario.getSenha());
		
		usuarioController.atualizar(usuarioAtual);
		
		return "Usuario atualizado";
	}
}