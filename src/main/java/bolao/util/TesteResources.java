package bolao.util;

import java.util.ArrayList;
import java.util.List;

import bolao.model.Jogo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class TesteResources {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client client = Client.create();
		
		WebResource webResourceJson = client.resource("http://localhost:8080/bolaoShow/jogos");
		
		System.out.println("PRODUZINDO JSON");
		
		String json = webResourceJson.get(String.class);
		System.out.println(json);
		
		List<Jogo> p2 = new ArcomrayList<Jogo>(); 
		p2 = webResourceJson.get(List.class);
		System.out.println(p2.toString());
	}
}