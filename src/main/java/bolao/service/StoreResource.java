package bolao.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import bolao.model.StoreValue;

@Path("/storeavalue")
public class StoreResource {
	
	public static String frase;
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String storeValor(@FormParam("tag") String tag, @FormParam("value") String valor){
		System.out.println(tag + ": " + valor);
		StoreValue.add(tag, valor);
		return tag + ": " + valor;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String getValue(@QueryParam("tag") String tag){
		return StoreValue.getValue(tag);
	}
	
	@POST
	@Path("/frase")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String recebeFrase(String f){
		frase = f;
		return "Frase enviada com sucesso, realize um GET pra recuperá-la";
	}
	
	@GET
	@Path("/frase")
	@Produces(MediaType.TEXT_PLAIN)
	public String getFrase(){
		return frase;
	}
}