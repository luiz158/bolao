package bolao.util;

import bolao.controller.ClubeController;
import bolao.model.Clube;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Clube a = new Clube();
		
		a.setNome("Palmeiras");
		
		Clube b = new Clube();
		
		b.setNome("Cruzeiro");
		
		ClubeController cc= new ClubeController();
		
		cc.adicionar(a);
		cc.adicionar(b);
		System.out.println("CLube adicionado!");
	}

}
